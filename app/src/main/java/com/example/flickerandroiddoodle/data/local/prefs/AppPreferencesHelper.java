package com.example.flickerandroiddoodle.data.local.prefs;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.flickerandroiddoodle.utils.AppConstants;
import com.example.flickerandroiddoodle.utils.ContextInteractor;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class AppPreferencesHelper implements PreferencesHelper {
  private static volatile AppPreferencesHelper INSTANCE;
  private SharedPreferences mPrefs;

  private AppPreferencesHelper() {

  }

  public static AppPreferencesHelper getInstance() {
    if (INSTANCE == null) {
      synchronized (AppPreferencesHelper.class) {
        if (INSTANCE == null) {
          INSTANCE = new AppPreferencesHelper();
          INSTANCE.mPrefs = ContextInteractor.getInstance()
              .getContext()
              .getSharedPreferences(AppConstants.PREF_FILE_NAME, Context.MODE_PRIVATE);
        }
      }
    }
    return INSTANCE;
  }


  @Override
  public int getNextPageIndex() {
    return mPrefs.getInt(AppConstants.PREF_KEY_NEXT_PAGE, -1);
  }

  @Override
  public int getTotalPageSize() {
    return mPrefs.getInt(AppConstants.PREF_KEY_TOTAL_PAGES, -1);
  }

  public void setNextPageIndex(int index) {
    mPrefs.edit().putInt(AppConstants.PREF_KEY_NEXT_PAGE, index).apply();
  }

  public void setTotalPageSize(int pages) {
    mPrefs.edit().putInt(AppConstants.PREF_KEY_TOTAL_PAGES, pages).apply();
  }
}
