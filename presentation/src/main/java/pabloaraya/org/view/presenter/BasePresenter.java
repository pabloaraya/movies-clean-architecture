package pabloaraya.org.view.presenter;

import java.util.ArrayList;
import java.util.List;
import pabloaraya.org.domain.common.BaseUseCase;

public abstract class BasePresenter<V extends BasePresenter.View> {

    private List<BaseUseCase> useCases = new ArrayList<>();

    private V view;

    protected V getView() {
        return view;
    }

    public void attachView(V view) {
        this.view = view;
    }

    public void detachView() {
        this.view = null;
    }

    public interface View {

        void showLoading();

        void hideLoading();

        void showConnectionError();
    }

    public void registerUseCase(BaseUseCase useCase){
        useCases.add(useCase);
    }

    public void unregisterUseCases(){
        for(BaseUseCase useCase:useCases){
            useCase.dispose();
        }
        useCases.clear();
    }

    public void release(){
        detachView();
        unregisterUseCases();
    }
}
