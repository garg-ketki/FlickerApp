package com.example.flickerandroiddoodle.utils;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class AppConstants {

  private AppConstants() {
  }

  public static String BASE_URL = "https://api.flickr.com/";
  public static long NETWORK_TIME_OUT = 8000; //in ms
  public static int COLUMNS = 3;
  public static final String GET_PHOTO = "http://farm{farm}.static.flickr" +
      ".com/{server}/{id}_{secret}.jpg";
  public static final String PREF_FILE_NAME = "sharedPrefs";
  public static final String PREF_KEY_TOTAL_PAGES = "PREF_KEY_TOTAL_PAGES";
  public static final String PREF_KEY_NEXT_PAGE = "PREF_KEY_NEXT_PAGE";
}
