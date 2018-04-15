package com.example.flickerandroiddoodle.ui.photoscreen;

import android.databinding.DataBindingUtil;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.flickerandroiddoodle.R;
import com.example.flickerandroiddoodle.databinding.LayoutItemBinding;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class ViewHolderFactory {

  public static PhotoViewHolder getViewHolder(ViewGroup parent, int viewType) {
    LayoutItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()),
        R.layout.layout_item, parent, false);
    return new PhotoViewHolder(binding.getRoot(), binding);

  }
}
