package pabloaraya.org.moviesparty.fragment;

import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import butterknife.Unbinder;
import dagger.android.support.DaggerFragment;
import pabloaraya.org.view.presenter.BasePresenter;

public abstract class BaseFragment extends DaggerFragment {

    private Unbinder unbinder;
    private BasePresenter basePresenter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(getLayoutId(), container, false);
        bindViews(view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        onPrepareFragment(view);
        onPreparePresenter();
    }

    protected void bindViews(View view) {
        unbinder = ButterKnife.bind(this, view);
    }

    @Override public void onDestroy() {
        super.onDestroy();
        if(unbinder != null)
            unbinder.unbind();
        releasePresenter();
    }

    public void attachPresenter(BasePresenter basePresenter,BasePresenter.View view){
        this.basePresenter = basePresenter;
        this.basePresenter.attachView(view);
    }

    private void releasePresenter(){
        if(basePresenter != null)
            basePresenter.release();
    }

    protected void onPreparePresenter() {}

    protected void onPrepareFragment(@NonNull View view) {}

    @LayoutRes
    protected abstract int getLayoutId();
}
