package com.example.flickerandroiddoodle.ui.photoscreen;

import android.arch.lifecycle.MutableLiveData;
import android.databinding.ObservableArrayList;

import com.example.flickerandroiddoodle.data.model.api.Photo;
import com.example.flickerandroiddoodle.ui.base.BaseViewModel;

import java.util.ArrayList;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

/**
 * Created by ketkigarg on 20/02/18.
 */

public class PhotoViewModel extends BaseViewModel<PhotoActivityNavigator> {

  private MutableLiveData<ArrayList<Photo>> listMutableLiveData;
  private ObservableArrayList<Photo> observableArrayList;

  public PhotoViewModel() {
    listMutableLiveData = new MutableLiveData<>();
    observableArrayList = new ObservableArrayList<>();
  }

  public void getPhotos(String searchText, boolean clearData) {
    setIsLoading(true);
    addDisposable(getDataManager().getPhotos(searchText)
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .map(photosResponse -> {
          if (clearData) {
            getObservableArrayList().clear();
          }
          setTotalPageSize(photosResponse.photos.pages);
          setNextPageIndex(photosResponse.photos.page + 1);
          return photosResponse.photos.photo;
        }).subscribe(list -> {
          setIsLoading(false);
          listMutableLiveData.postValue(list);
        }));
  }

  public void setObservableArrayList(ArrayList<Photo> photoArrayList) {
    getNavigator().updateList(photoArrayList);
  }

  public ObservableArrayList<Photo> getObservableArrayList() {
    return observableArrayList;
  }

  public MutableLiveData<ArrayList<Photo>> getMutableLiveData() {
    return listMutableLiveData;
  }


  public int getNextPageIndex() {
    return getDataManager().getNextPageIndex();
  }

  public int getTotalPageSize() {
    return getDataManager().getTotalPageSize();
  }

  public void setNextPageIndex(int index) {
    getDataManager().setNextPageIndex(index);
  }

  public void setTotalPageSize(int index) {
    getDataManager().setTotalPageSize(index);
  }

  public int getPaginationIndex() {
    if (getNextPageIndex() == getTotalPageSize()) {
      return -1;
    }
    return getNextPageIndex();
  }
}
