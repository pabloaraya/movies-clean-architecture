package pabloaraya.org.moviesparty.activity;

import android.support.annotation.IdRes;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

public abstract class BaseFragmentActivity extends BaseActivity {

    private Fragment fragment;

    @Override protected void onPrepareActivity() {
        super.onPrepareActivity();
        onPrepareFragment();
    }

    private void onPrepareFragment() {
        final FragmentManager fragmentManager = getSupportFragmentManager();
        final int containerViewId = getContainerViewId();
        fragment = fragmentManager.findFragmentById(containerViewId);
        if (fragment == null) {
            fragment = getFragmentInstance();
            fragmentManager.beginTransaction().add(containerViewId, fragment).commit();
        }
    }

    public Fragment getTargetNestedFragment() {
        return fragment;
    }

    @IdRes
    protected abstract int getContainerViewId();

    protected abstract Fragment getFragmentInstance();
}
