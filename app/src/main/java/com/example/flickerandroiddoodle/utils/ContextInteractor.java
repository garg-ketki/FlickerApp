package com.example.flickerandroiddoodle.utils;

import android.content.Context;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class ContextInteractor {
  private static volatile ContextInteractor INSTANCE;
  private Context context;

  public static ContextInteractor getInstance() {
    if (INSTANCE == null) {
      synchronized (ContextInteractor.class) {
        if (INSTANCE == null) {
          INSTANCE = new ContextInteractor();
        }
      }
    }
    return INSTANCE;
  }

  private ContextInteractor() {
  }

  public Context getContext() {
    return context;
  }

  public void setContext(Context context) {
    this.context = context;
  }
}
