package pabloaraya.org.domain.usecase;

import dagger.internal.Preconditions;
import io.reactivex.Observable;
import io.reactivex.Scheduler;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;

public abstract class UseCase<T> extends BaseUseCase<T>{

    private Scheduler scheduler;

    public UseCase(Scheduler scheduler) {
        this.scheduler = scheduler;
    }

    public void execute(DisposableObserver<T> disposableObserver) {
        Preconditions.checkNotNull(disposableObserver);
        final Observable<T> observable = buildUseCaseObservable().subscribeOn(Schedulers.io())
                .observeOn(scheduler);

        DisposableObserver observer = observable.subscribeWith(disposableObserver);
        compositeDisposable.add(observer);
    }

    protected abstract Observable<T> buildUseCaseObservable();
}
