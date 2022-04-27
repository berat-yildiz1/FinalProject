// Generated by data binding compiler. Do not edit!
package com.example.popfinder.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.databinding.Bindable;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.example.popfinder.GooglePlaceModel;
import com.example.popfinder.NearLocationInterface;
import com.example.popfinder.R;
import com.google.android.material.textview.MaterialTextView;
import java.lang.Deprecated;
import java.lang.Object;

public abstract class PlaceItemLayoutBinding extends ViewDataBinding {
  @NonNull
  public final ImageView imgSaveLocation;

  @NonNull
  public final RelativeLayout rating;

  @NonNull
  public final TextView txtPlaceAddress;

  @NonNull
  public final MaterialTextView txtPlaceDRating;

  @NonNull
  public final TextView txtPlaceName;

  @Bindable
  protected GooglePlaceModel mGooglePlaceModel;

  @Bindable
  protected NearLocationInterface mListener;

  protected PlaceItemLayoutBinding(Object _bindingComponent, View _root, int _localFieldCount,
      ImageView imgSaveLocation, RelativeLayout rating, TextView txtPlaceAddress,
      MaterialTextView txtPlaceDRating, TextView txtPlaceName) {
    super(_bindingComponent, _root, _localFieldCount);
    this.imgSaveLocation = imgSaveLocation;
    this.rating = rating;
    this.txtPlaceAddress = txtPlaceAddress;
    this.txtPlaceDRating = txtPlaceDRating;
    this.txtPlaceName = txtPlaceName;
  }

  public abstract void setGooglePlaceModel(@Nullable GooglePlaceModel googlePlaceModel);

  @Nullable
  public GooglePlaceModel getGooglePlaceModel() {
    return mGooglePlaceModel;
  }

  public abstract void setListener(@Nullable NearLocationInterface listener);

  @Nullable
  public NearLocationInterface getListener() {
    return mListener;
  }

  @NonNull
  public static PlaceItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot) {
    return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.place_item_layout, root, attachToRoot, component)
   */
  @NonNull
  @Deprecated
  public static PlaceItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup root, boolean attachToRoot, @Nullable Object component) {
    return ViewDataBinding.<PlaceItemLayoutBinding>inflateInternal(inflater, R.layout.place_item_layout, root, attachToRoot, component);
  }

  @NonNull
  public static PlaceItemLayoutBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.inflate(inflater, R.layout.place_item_layout, null, false, component)
   */
  @NonNull
  @Deprecated
  public static PlaceItemLayoutBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable Object component) {
    return ViewDataBinding.<PlaceItemLayoutBinding>inflateInternal(inflater, R.layout.place_item_layout, null, false, component);
  }

  public static PlaceItemLayoutBinding bind(@NonNull View view) {
    return bind(view, DataBindingUtil.getDefaultComponent());
  }

  /**
   * This method receives DataBindingComponent instance as type Object instead of
   * type DataBindingComponent to avoid causing too many compilation errors if
   * compilation fails for another reason.
   * https://issuetracker.google.com/issues/116541301
   * @Deprecated Use DataBindingUtil.bind(view, component)
   */
  @Deprecated
  public static PlaceItemLayoutBinding bind(@NonNull View view, @Nullable Object component) {
    return (PlaceItemLayoutBinding)bind(component, view, R.layout.place_item_layout);
  }
}
