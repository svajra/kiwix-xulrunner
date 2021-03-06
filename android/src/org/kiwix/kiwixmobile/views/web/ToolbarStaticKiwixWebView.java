package org.kiwix.kiwixmobile.views.web;

import android.content.Context;
import android.view.ViewGroup;

import org.kiwix.kiwixmobile.KiwixMobileActivity;
import org.kiwix.kiwixmobile.WebViewCallback;
import org.kiwix.kiwixmobile.utils.DimenUtils;

/**
 * Created by gmon on 1/14/17.
 */

public class ToolbarStaticKiwixWebView extends KiwixWebView {

  private int heightDifference;
  private int statusBarHeight;
  private ViewGroup viewGroup;

  public ToolbarStaticKiwixWebView(Context context, WebViewCallback callback, ViewGroup toolbarLayout) {
    super(context, callback);
    statusBarHeight = DimenUtils.getTranslucentStatusBarHeight(context);
    viewGroup = toolbarLayout;
    viewGroup.setTranslationY(statusBarHeight);
    heightDifference = DimenUtils.getToolbarAndStatusBarHeight(context);
    setTranslationY(heightDifference);
  }

  @Override
  protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
    if ((KiwixMobileActivity.isFullscreenOpened)) {
      setTranslationY(0);
      super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    } else {
      setTranslationY(heightDifference);
      super.onMeasure(widthMeasureSpec, heightMeasureSpec - heightDifference);
    }
  }
}
