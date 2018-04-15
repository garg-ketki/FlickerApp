package com.example.flickerandroiddoodle.data.model.api;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class Photos implements Parcelable {
  public ArrayList<Photo> photo;
  public int page;
  public int pages;


  protected Photos(Parcel in) {
    photo = in.createTypedArrayList(Photo.CREATOR);
    page = in.readInt();
    pages = in.readInt();
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeTypedList(photo);
    dest.writeInt(page);
    dest.writeInt(pages);
  }

  @Override
  public int describeContents() {
    return 0;
  }

  public static final Creator<Photos> CREATOR = new Creator<Photos>() {
    @Override
    public Photos createFromParcel(Parcel in) {
      return new Photos(in);
    }

    @Override
    public Photos[] newArray(int size) {
      return new Photos[size];
    }
  };
}
