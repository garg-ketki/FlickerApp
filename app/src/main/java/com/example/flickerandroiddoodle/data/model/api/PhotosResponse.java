package com.example.flickerandroiddoodle.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class PhotosResponse implements Parcelable{
  public Photos photos;

  protected PhotosResponse(Parcel in) {
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<PhotosResponse> CREATOR = new Creator<PhotosResponse>() {
    @Override
    public PhotosResponse createFromParcel(Parcel in) {
      return new PhotosResponse(in);
    }

    @Override
    public PhotosResponse[] newArray(int size) {
      return new PhotosResponse[size];
    }
  };
}
