package pabloaraya.org.domain.usecase;

import io.reactivex.observers.DisposableObserver;

public abstract class UseCaseObserver<T> extends DisposableObserver<T> {

    @Override public void onComplete() {
    }

    @Override public void onError(Throwable e) {
    }

    @Override public void onNext(T t) {
    }
}
