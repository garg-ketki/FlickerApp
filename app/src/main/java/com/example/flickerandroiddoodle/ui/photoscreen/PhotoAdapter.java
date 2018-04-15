package com.example.flickerandroiddoodle.ui.photoscreen;

import android.databinding.ObservableArrayList;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.example.flickerandroiddoodle.data.model.api.Photo;

import java.util.ArrayList;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class PhotoAdapter extends RecyclerView.Adapter<PhotoViewHolder> {
  private ObservableArrayList<Photo> observableArrayList;

  public PhotoAdapter(ObservableArrayList<Photo> observableArrayList) {
    this.observableArrayList = observableArrayList;
  }

  @Override
  public PhotoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return ViewHolderFactory.getViewHolder(parent, viewType);
  }

  @Override
  public void onBindViewHolder(PhotoViewHolder holder, int position) {
    holder.bindData(observableArrayList.get(position));
  }

  @Override
  public int getItemCount() {
    if (observableArrayList == null) {
      return 0;
    }
    return observableArrayList.size();
  }

  public void setData(ArrayList<Photo> data) {
    observableArrayList.addAll(data);
    notifyDataSetChanged();
  }
}
