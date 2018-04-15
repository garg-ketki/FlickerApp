package com.example.flickerandroiddoodle.ui.photoscreen;

import com.example.flickerandroiddoodle.data.model.api.Photo;

import java.util.ArrayList;

/**
 * Created by ketkigarg on 21/02/18.
 */

public interface PhotoActivityNavigator {
  void updateList(ArrayList<Photo> list);

  void onLoadNextPage();
}
