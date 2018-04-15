package com.example.flickerandroiddoodle.data.remote.service;

import com.example.flickerandroiddoodle.data.model.api.PhotosResponse;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by ketkigarg on 21/02/18.
 */

public interface GetPhotosService {
  @GET("services/rest/?method=flickr.photos" +
      ".search&api_key=3e7cc266ae2b0e0d78e279ce8e361736&format=json&nojsoncallback=1")
  Single<PhotosResponse> getPhotos(@Query("text") String searchText);
}
