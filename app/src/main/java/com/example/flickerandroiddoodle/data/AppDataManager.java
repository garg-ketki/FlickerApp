package com.example.flickerandroiddoodle.data;

import com.example.flickerandroiddoodle.data.local.prefs.PreferencesHelper;
import com.example.flickerandroiddoodle.data.model.api.PhotosResponse;
import com.example.flickerandroiddoodle.data.remote.ApiHelper;

import io.reactivex.Single;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class AppDataManager implements DataManager {
  private static volatile AppDataManager INSTANCE;
  private ApiHelper apiHelper;
  private PreferencesHelper preferencesHelper;

  private AppDataManager() {

  }

  public static AppDataManager getInstance(ApiHelper apiHelper,
                                           PreferencesHelper preferencesHelper) {
    if (INSTANCE == null) {
      synchronized (AppDataManager.class) {
        if (INSTANCE == null) {
          INSTANCE = new AppDataManager();
          INSTANCE.apiHelper = apiHelper;
          INSTANCE.preferencesHelper = preferencesHelper;
        }
      }
    }
    return INSTANCE;
  }

  @Override
  public Single<PhotosResponse> getPhotos(String searchText) {
    return apiHelper.getPhotos(searchText);
  }

  @Override
  public int getNextPageIndex() {
    return preferencesHelper.getNextPageIndex();
  }

  @Override
  public int getTotalPageSize() {
    return preferencesHelper.getTotalPageSize();
  }

  @Override
  public void setNextPageIndex(int index) {
    preferencesHelper.setNextPageIndex(index);
  }

  @Override
  public void setTotalPageSize(int index) {
    preferencesHelper.setTotalPageSize(index);
  }
}
