package com.example.flickerandroiddoodle.ui.photoscreen;

import android.databinding.ObservableBoolean;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

/**
 * Created by ketkigarg on 21/02/18.
 */

public class IScrollListenerRV extends RecyclerView.OnScrollListener {
  private boolean endOfList = false;
  private static final int PAGINATION_MARGIN = 2;
  private PhotoActivityNavigator navigator;
  private ObservableBoolean isLoading;

  public IScrollListenerRV(PhotoActivityNavigator navigator, ObservableBoolean isLoading) {
    this.navigator = navigator;
    this.isLoading = isLoading;
  }

  @Override
  public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
    super.onScrolled(recyclerView, dx, dy);
    int visibleItemCount = recyclerView.getLayoutManager().getChildCount();
    int totalItemCount = recyclerView.getLayoutManager().getItemCount();
    int firstVisibleItemPosition =
        ((LinearLayoutManager) recyclerView.getLayoutManager()).findFirstVisibleItemPosition();
    if (!isLoading.get() && !endOfList) {
      if ((visibleItemCount + firstVisibleItemPosition) >= totalItemCount - PAGINATION_MARGIN &&
          firstVisibleItemPosition >= 0) {
        navigator.onLoadNextPage();
      }
    }
  }

  public void canPaginate(int paginationIndex) {
    if (paginationIndex == -1) {
      this.endOfList = true;
    } else {
      this.endOfList = false;
    }
  }
}
