package com.example.flickerandroiddoodle.ui.base;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.flickerandroiddoodle.utils.CommonUtils;

/**
 * Created by ketkigarg on 21/02/18.
 */

public abstract class BaseActivity<T extends ViewDataBinding, V extends BaseViewModel>
    extends AppCompatActivity {
  private T mViewDataBinding;
  private V mViewModel;
  private ProgressDialog progressDialog;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mViewDataBinding = DataBindingUtil.setContentView(this, getLayoutRes());
    mViewModel = getViewModel();
    mViewDataBinding.setVariable(getBindingVariable(), mViewModel);
    mViewDataBinding.executePendingBindings();
  }

  protected abstract int getBindingVariable();

  protected abstract V getViewModel();

  protected abstract int getLayoutRes();

  public void showProgressBar() {
    hideProgressBar();
    if (progressDialog == null) {
      progressDialog = CommonUtils.showLoadingDialog(this);
    }
    progressDialog.show();
  }

  public void hideProgressBar() {
    if (progressDialog != null && progressDialog.isShowing()) {
      progressDialog.dismiss();
    }
  }


  public T getDataBinding() {
    return mViewDataBinding;
  }

}
