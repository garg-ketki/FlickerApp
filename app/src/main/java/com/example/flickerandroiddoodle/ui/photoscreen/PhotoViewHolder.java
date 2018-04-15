package com.example.flickerandroiddoodle.ui.photoscreen;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.bumptech.glide.Glide;
import com.example.flickerandroiddoodle.data.model.api.Photo;
import com.example.flickerandroiddoodle.databinding.LayoutItemBinding;
import com.example.flickerandroiddoodle.utils.AppConstants;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class PhotoViewHolder extends RecyclerView.ViewHolder {
  private LayoutItemBinding binding;
  private View root;

  public PhotoViewHolder(View root, LayoutItemBinding binding) {
    super(root);
    this.root = root;
    this.binding = binding;
  }

  public void bindData(Photo photo) {
    String url = buildUrl(photo);
    Glide.with(root.getContext()).load(url).into(binding.imageView);
  }

  private String buildUrl(Photo photo) {
    return AppConstants.GET_PHOTO.replace("{farm}", photo.farm + "").replace("{server}", photo
        .server)
        .replace("{id}", photo.id).replace("{secret}", photo.secret);
  }
}
