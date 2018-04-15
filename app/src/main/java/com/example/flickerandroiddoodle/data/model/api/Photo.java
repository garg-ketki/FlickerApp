package com.example.flickerandroiddoodle.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class Photo implements Parcelable {
  public String id;
  public String secret;
  public String server;
  public int farm;

  protected Photo(Parcel in) {
    id = in.readString();
    secret = in.readString();
    server = in.readString();
    farm = in.readInt();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(id);
    dest.writeString(secret);
    dest.writeString(server);
    dest.writeInt(farm);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Photo> CREATOR = new Creator<Photo>() {
    @Override
    public Photo createFromParcel(Parcel in) {
      return new Photo(in);
    }

    @Override
    public Photo[] newArray(int size) {
      return new Photo[size];
    }
  };
}
