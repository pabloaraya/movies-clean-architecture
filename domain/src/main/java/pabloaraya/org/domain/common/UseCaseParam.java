package pabloaraya.org.domain.common;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCaseParam<P, T> extends BaseUseCase<T> {

    private Scheduler scheduler;

    public UseCaseParam(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void execute(DisposableObserver<T> disposableObserver, P param) {
        Preconditions.checkNotNull(disposableObserver);
        final Observable<T> observable = buildUseCaseObservable(param).subscribeOn(Schedulers.io())
                .observeOn(scheduler);

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    protected abstract Observable<T> buildUseCaseObservable(P param);
}
