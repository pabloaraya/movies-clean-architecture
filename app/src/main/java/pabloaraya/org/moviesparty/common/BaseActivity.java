package pabloaraya.org.moviesparty.common;

import android.os.Bundle;
import androidx.annotation.LayoutRes;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity {

  @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    onInject();
    setContentView(getLayoutId());
    onPrepareActivity();
    onPreparePresenter();
  }

  @LayoutRes
  protected abstract int getLayoutId();

  protected void onPreparePresenter() {
  }

  protected void onPrepareActivity() {
  }

  protected void onInject() {
  }

  @Override protected void onResume() {
    super.onResume();
  }

  @Override protected void onPause() {
    super.onPause();
  }
}
