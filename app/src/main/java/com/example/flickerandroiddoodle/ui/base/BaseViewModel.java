package com.example.flickerandroiddoodle.ui.base;

import android.arch.lifecycle.ViewModel;
import android.databinding.ObservableBoolean;

import com.example.flickerandroiddoodle.data.AppDataManager;
import com.example.flickerandroiddoodle.data.DataManager;
import com.example.flickerandroiddoodle.data.local.prefs.AppPreferencesHelper;
import com.example.flickerandroiddoodle.data.remote.AppApiHelper;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class BaseViewModel<T> extends ViewModel {
  private DataManager dataManager;
  private CompositeDisposable compositeDisposable;
  private T navigator;
  public ObservableBoolean isLoading = new ObservableBoolean(false);

  public BaseViewModel() {
    dataManager =
        AppDataManager.getInstance(AppApiHelper.getInstance(), AppPreferencesHelper.getInstance());
    compositeDisposable = new CompositeDisposable();
  }

  protected void addDisposable(Disposable disposable) {
    compositeDisposable.add(disposable);
  }

  public DataManager getDataManager() {
    return dataManager;
  }

  @Override
  protected void onCleared() {
    if (compositeDisposable != null && !compositeDisposable.isDisposed()) {
      compositeDisposable.dispose();
    }
    super.onCleared();
  }

  public void setIsLoading(boolean loading) {
    isLoading.set(loading);
  }

  public ObservableBoolean getIsLoading() {
    return isLoading;
  }

  public void setNavigator(T navigator) {
    this.navigator = navigator;
  }

  public T getNavigator() {
    return navigator;
  }
}
