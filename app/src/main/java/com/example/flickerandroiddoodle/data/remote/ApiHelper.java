package com.example.flickerandroiddoodle.data.remote;

import com.example.flickerandroiddoodle.data.model.api.PhotosResponse;

import io.reactivex.Single;

/**
 * Created by ketkigarg on 21/02/18.
 */

public interface ApiHelper {
  Single<PhotosResponse> getPhotos(String searchText);
}
