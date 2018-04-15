package com.example.flickerandroiddoodle.ui.photoscreen;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.text.Editable;
import android.util.Log;
import android.widget.Toast;

import com.example.flickerandroiddoodle.BR;
import com.example.flickerandroiddoodle.R;
import com.example.flickerandroiddoodle.data.model.api.Photo;
import com.example.flickerandroiddoodle.databinding.ActivityPhotosBinding;
import com.example.flickerandroiddoodle.ui.base.BaseActivity;
import com.example.flickerandroiddoodle.utils.AppConstants;

import java.util.ArrayList;

public class PhotosActivity extends BaseActivity<ActivityPhotosBinding, PhotoViewModel>
    implements PhotoActivityNavigator {
  private IScrollListenerRV scrollListenerRV;
  private PhotoViewModel mPhotoViewModel;
  private ActivityPhotosBinding mBinding;
  private PhotoAdapter mAdapter;
  private String searchText = "";

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mBinding = getDataBinding();
    initRecyclerView();
    initData();
    initEditText();
  }

  private void initEditText() {
    mBinding.button.setOnClickListener(view -> {
      searchText = "";
      Editable value = mBinding.editText.getText();
      if (value == null) {
        Toast.makeText(PhotosActivity.this, "Please enter something", Toast.LENGTH_SHORT).show();
      } else {
        searchText = value.toString();
        mPhotoViewModel.getPhotos(searchText, true);
      }
    });
  }

  private void initRecyclerView() {
    mBinding.rv.setLayoutManager(new GridLayoutManager(this, AppConstants.COLUMNS));
    mAdapter = new PhotoAdapter(mPhotoViewModel.getObservableArrayList());
    scrollListenerRV = new IScrollListenerRV(this, mPhotoViewModel.getIsLoading());
    mBinding.rv.addOnScrollListener(scrollListenerRV);
    mBinding.rv.setAdapter(mAdapter);
  }

  private void initData() {
    mPhotoViewModel.setNavigator(this);
    subscribeToLiveData();
  }

  private void subscribeToLiveData() {
    mPhotoViewModel.getMutableLiveData().observe(this,
        photos -> {
          scrollListenerRV.canPaginate(mPhotoViewModel.getPaginationIndex());
          mPhotoViewModel.setObservableArrayList(photos);
        });
  }

  @Override
  protected int getBindingVariable() {
    return BR.viewModel;
  }

  @Override
  protected PhotoViewModel getViewModel() {
    mPhotoViewModel = ViewModelProviders.of(this).get(PhotoViewModel.class);
    return mPhotoViewModel;
  }

  @Override
  protected int getLayoutRes() {
    return R.layout.activity_photos;
  }

  @Override
  public void updateList(ArrayList<Photo> list) {
    Log.v("ketki", "inside updateList: " + list.size());
    mAdapter.setData(list);
  }

  @Override
  public void onLoadNextPage() {
    mPhotoViewModel.getPhotos(searchText, false);
  }
}
