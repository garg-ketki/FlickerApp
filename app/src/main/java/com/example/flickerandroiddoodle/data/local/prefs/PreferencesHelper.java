package com.example.flickerandroiddoodle.data.local.prefs;

/**
 * Created by ketkigarg on 21/02/18.
 */

public interface PreferencesHelper {

  int getNextPageIndex();

  int getTotalPageSize();

  void setNextPageIndex(int index);

  void setTotalPageSize(int index);

}
