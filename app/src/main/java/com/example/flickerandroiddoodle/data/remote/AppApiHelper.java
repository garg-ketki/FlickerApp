package com.example.flickerandroiddoodle.data.remote;

import com.example.flickerandroiddoodle.data.model.api.PhotosResponse;
import com.example.flickerandroiddoodle.data.remote.service.GetPhotosService;
import com.example.flickerandroiddoodle.utils.NetworkHelper;

import io.reactivex.Single;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class AppApiHelper implements ApiHelper {
  private static volatile AppApiHelper INSTANCE;

  private AppApiHelper() {

  }

  public static AppApiHelper getInstance() {
    if (INSTANCE == null) {
      synchronized (AppApiHelper.class) {
        if (INSTANCE == null) {
          INSTANCE = new AppApiHelper();
        }
      }
    }
    return INSTANCE;
  }

  @Override
  public Single<PhotosResponse> getPhotos(String searchText) {
    return NetworkHelper.getRetrofit().create(GetPhotosService.class).getPhotos(searchText);
  }
}
