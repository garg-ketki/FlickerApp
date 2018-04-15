package com.example.flickerandroiddoodle;

import android.app.Application;

import com.example.flickerandroiddoodle.utils.ContextInteractor;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class AppBaseApplication extends Application {
  @Override
  public void onCreate() {
    super.onCreate();
    ContextInteractor.getInstance().setContext(getApplicationContext());
  }
}
