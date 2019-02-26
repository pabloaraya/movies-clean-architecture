package pabloaraya.org.domain.common;

import dagger.internal.Preconditions;
import io.reactivex.Completable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableCompletableObserver;
import io.reactivex.schedulers.Schedulers;
import javax.inject.Inject;

public abstract class UseCaseCompletableParam<P> extends BaseUseCase {

    @Inject
    Scheduler scheduler;

    public void execute(DisposableCompletableObserver completableObserver, P params) {
        Preconditions.checkNotNull(completableObserver);
        final Completable completable = buildUseCaseObservable(params).subscribeOn(Schedulers.io())
                .observeOn(scheduler);

        DisposableCompletableObserver observer = completable.subscribeWith(completableObserver);
        compositeDisposable.add(observer);
    }

    protected abstract Completable buildUseCaseObservable(P params);
}
