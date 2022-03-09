package com.example.popfinder.databinding;
import com.example.popfinder.R;
import com.example.popfinder.BR;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import android.view.View;
@SuppressWarnings("unchecked")
public class PlaceItemLayoutBindingImpl extends PlaceItemLayoutBinding  {

    @Nullable
    private static final androidx.databinding.ViewDataBinding.IncludedLayouts sIncludes;
    @Nullable
    private static final android.util.SparseIntArray sViewsWithIds;
    static {
        sIncludes = null;
        sViewsWithIds = new android.util.SparseIntArray();
        sViewsWithIds.put(R.id.rating, 6);
        sViewsWithIds.put(R.id.imgSaveLocation, 7);
    }
    // views
    @NonNull
    private final androidx.cardview.widget.CardView mboundView0;
    @NonNull
    private final android.widget.ImageView mboundView1;
    @NonNull
    private final com.google.android.material.textview.MaterialTextView mboundView3;
    // variables
    // values
    // listeners
    // Inverse Binding Event Handlers

    public PlaceItemLayoutBindingImpl(@Nullable androidx.databinding.DataBindingComponent bindingComponent, @NonNull View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 8, sIncludes, sViewsWithIds));
    }
    private PlaceItemLayoutBindingImpl(androidx.databinding.DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0
            , (android.widget.ImageView) bindings[7]
            , (android.widget.RelativeLayout) bindings[6]
            , (android.widget.TextView) bindings[5]
            , (com.google.android.material.textview.MaterialTextView) bindings[2]
            , (android.widget.TextView) bindings[4]
            );
        this.mboundView0 = (androidx.cardview.widget.CardView) bindings[0];
        this.mboundView0.setTag(null);
        this.mboundView1 = (android.widget.ImageView) bindings[1];
        this.mboundView1.setTag(null);
        this.mboundView3 = (com.google.android.material.textview.MaterialTextView) bindings[3];
        this.mboundView3.setTag(null);
        this.txtPlaceAddress.setTag(null);
        this.txtPlaceDRating.setTag(null);
        this.txtPlaceName.setTag(null);
        setRootTag(root);
        // listeners
        invalidateAll();
    }

    @Override
    public void invalidateAll() {
        synchronized(this) {
                mDirtyFlags = 0x2L;
        }
        requestRebind();
    }

    @Override
    public boolean hasPendingBindings() {
        synchronized(this) {
            if (mDirtyFlags != 0) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean setVariable(int variableId, @Nullable Object variable)  {
        boolean variableSet = true;
        if (BR.googlePlaceModel == variableId) {
            setGooglePlaceModel((com.example.popfinder.GooglePlaceModel) variable);
        }
        else {
            variableSet = false;
        }
            return variableSet;
    }

    public void setGooglePlaceModel(@Nullable com.example.popfinder.GooglePlaceModel GooglePlaceModel) {
        this.mGooglePlaceModel = GooglePlaceModel;
        synchronized(this) {
            mDirtyFlags |= 0x1L;
        }
        notifyPropertyChanged(BR.googlePlaceModel);
        super.requestRebind();
    }

    @Override
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        switch (localFieldId) {
        }
        return false;
    }

    @Override
    protected void executeBindings() {
        long dirtyFlags = 0;
        synchronized(this) {
            dirtyFlags = mDirtyFlags;
            mDirtyFlags = 0;
        }
        java.lang.String javaLangStringStringValueOfGooglePlaceModelUserRatingsTotalJavaLangString = null;
        java.lang.String googlePlaceModelUserRatingsTotalJavaLangObjectNullJavaLangStringStringValueOfGooglePlaceModelUserRatingsTotalJavaLangStringJavaLangString = null;
        boolean googlePlaceModelVicinityJavaLangObjectNull = false;
        java.lang.Double googlePlaceModelRating = null;
        double androidxDatabindingViewDataBindingSafeUnboxGooglePlaceModelRating = 0.0;
        java.lang.String googlePlaceModelName = null;
        com.example.popfinder.GooglePlaceModel googlePlaceModel = mGooglePlaceModel;
        java.lang.String googlePlaceModelVicinity = null;
        java.lang.String googlePlaceModelIcon = null;
        java.lang.String javaLangStringStringValueOfGooglePlaceModelUserRatingsTotal = null;
        boolean googlePlaceModelNameJavaLangObjectNull = false;
        java.lang.String googlePlaceModelVicinityJavaLangObjectNullGooglePlaceModelVicinityJavaLangStringNoAddress = null;
        java.lang.String stringValueOfGooglePlaceModelRating = null;
        java.lang.String googlePlaceModelNameJavaLangObjectNullGooglePlaceModelNameJavaLangStringNoName = null;
        boolean googlePlaceModelRatingJavaLangObjectNull = false;
        java.lang.Integer googlePlaceModelUserRatingsTotal = null;
        int androidxDatabindingViewDataBindingSafeUnboxGooglePlaceModelUserRatingsTotal = 0;
        boolean googlePlaceModelUserRatingsTotalJavaLangObjectNull = false;
        java.lang.String googlePlaceModelRatingJavaLangObjectNullStringValueOfGooglePlaceModelRatingJavaLangStringNew = null;
        java.lang.String stringValueOfGooglePlaceModelUserRatingsTotal = null;

        if ((dirtyFlags & 0x3L) != 0) {



                if (googlePlaceModel != null) {
                    // read googlePlaceModel.rating
                    googlePlaceModelRating = googlePlaceModel.getRating();
                    // read googlePlaceModel.name
                    googlePlaceModelName = googlePlaceModel.getName();
                    // read googlePlaceModel.vicinity
                    googlePlaceModelVicinity = googlePlaceModel.getVicinity();
                    // read googlePlaceModel.icon
                    googlePlaceModelIcon = googlePlaceModel.getIcon();
                    // read googlePlaceModel.userRatingsTotal
                    googlePlaceModelUserRatingsTotal = googlePlaceModel.getUserRatingsTotal();
                }


                // read googlePlaceModel.rating != null
                googlePlaceModelRatingJavaLangObjectNull = (googlePlaceModelRating) != (null);
                // read googlePlaceModel.name != null
                googlePlaceModelNameJavaLangObjectNull = (googlePlaceModelName) != (null);
                // read googlePlaceModel.vicinity != null
                googlePlaceModelVicinityJavaLangObjectNull = (googlePlaceModelVicinity) != (null);
                // read googlePlaceModel.userRatingsTotal != null
                googlePlaceModelUserRatingsTotalJavaLangObjectNull = (googlePlaceModelUserRatingsTotal) != (null);
            if((dirtyFlags & 0x3L) != 0) {
                if(googlePlaceModelRatingJavaLangObjectNull) {
                        dirtyFlags |= 0x200L;
                }
                else {
                        dirtyFlags |= 0x100L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(googlePlaceModelNameJavaLangObjectNull) {
                        dirtyFlags |= 0x80L;
                }
                else {
                        dirtyFlags |= 0x40L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(googlePlaceModelVicinityJavaLangObjectNull) {
                        dirtyFlags |= 0x20L;
                }
                else {
                        dirtyFlags |= 0x10L;
                }
            }
            if((dirtyFlags & 0x3L) != 0) {
                if(googlePlaceModelUserRatingsTotalJavaLangObjectNull) {
                        dirtyFlags |= 0x8L;
                }
                else {
                        dirtyFlags |= 0x4L;
                }
            }
        }
        // batch finished

        if ((dirtyFlags & 0x200L) != 0) {

                // read androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.rating)
                androidxDatabindingViewDataBindingSafeUnboxGooglePlaceModelRating = androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModelRating);


                // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.rating))
                stringValueOfGooglePlaceModelRating = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxGooglePlaceModelRating);
        }
        if ((dirtyFlags & 0x3L) != 0) {

                // read googlePlaceModel.vicinity != null ? googlePlaceModel.vicinity : "No Address"
                googlePlaceModelVicinityJavaLangObjectNullGooglePlaceModelVicinityJavaLangStringNoAddress = ((googlePlaceModelVicinityJavaLangObjectNull) ? (googlePlaceModelVicinity) : ("No Address"));
                // read googlePlaceModel.name != null ? googlePlaceModel.name : "No Name"
                googlePlaceModelNameJavaLangObjectNullGooglePlaceModelNameJavaLangStringNoName = ((googlePlaceModelNameJavaLangObjectNull) ? (googlePlaceModelName) : ("No Name"));
        }
        if ((dirtyFlags & 0x8L) != 0) {

                // read androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.userRatingsTotal)
                androidxDatabindingViewDataBindingSafeUnboxGooglePlaceModelUserRatingsTotal = androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModelUserRatingsTotal);


                // read String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.userRatingsTotal))
                stringValueOfGooglePlaceModelUserRatingsTotal = java.lang.String.valueOf(androidxDatabindingViewDataBindingSafeUnboxGooglePlaceModelUserRatingsTotal);


                // read ("(") + (String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.userRatingsTotal)))
                javaLangStringStringValueOfGooglePlaceModelUserRatingsTotal = ("(") + (stringValueOfGooglePlaceModelUserRatingsTotal);


                // read (("(") + (String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.userRatingsTotal)))) + (")")
                javaLangStringStringValueOfGooglePlaceModelUserRatingsTotalJavaLangString = (javaLangStringStringValueOfGooglePlaceModelUserRatingsTotal) + (")");
        }

        if ((dirtyFlags & 0x3L) != 0) {

                // read googlePlaceModel.userRatingsTotal != null ? (("(") + (String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.userRatingsTotal)))) + (")") : ""
                googlePlaceModelUserRatingsTotalJavaLangObjectNullJavaLangStringStringValueOfGooglePlaceModelUserRatingsTotalJavaLangStringJavaLangString = ((googlePlaceModelUserRatingsTotalJavaLangObjectNull) ? (javaLangStringStringValueOfGooglePlaceModelUserRatingsTotalJavaLangString) : (""));
                // read googlePlaceModel.rating != null ? String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.rating)) : "New"
                googlePlaceModelRatingJavaLangObjectNullStringValueOfGooglePlaceModelRatingJavaLangStringNew = ((googlePlaceModelRatingJavaLangObjectNull) ? (stringValueOfGooglePlaceModelRating) : ("New"));
        }
        // batch finished
        if ((dirtyFlags & 0x3L) != 0) {
            // api target 1

            com.example.popfinder.Model.PhotoModel.loadImage(this.mboundView1, googlePlaceModelIcon);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.mboundView3, googlePlaceModelUserRatingsTotalJavaLangObjectNullJavaLangStringStringValueOfGooglePlaceModelUserRatingsTotalJavaLangStringJavaLangString);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtPlaceAddress, googlePlaceModelVicinityJavaLangObjectNullGooglePlaceModelVicinityJavaLangStringNoAddress);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtPlaceDRating, googlePlaceModelRatingJavaLangObjectNullStringValueOfGooglePlaceModelRatingJavaLangStringNew);
            androidx.databinding.adapters.TextViewBindingAdapter.setText(this.txtPlaceName, googlePlaceModelNameJavaLangObjectNullGooglePlaceModelNameJavaLangStringNoName);
        }
    }
    // Listener Stub Implementations
    // callback impls
    // dirty flag
    private  long mDirtyFlags = 0xffffffffffffffffL;
    /* flag mapping
        flag 0 (0x1L): googlePlaceModel
        flag 1 (0x2L): null
        flag 2 (0x3L): googlePlaceModel.userRatingsTotal != null ? (("(") + (String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.userRatingsTotal)))) + (")") : ""
        flag 3 (0x4L): googlePlaceModel.userRatingsTotal != null ? (("(") + (String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.userRatingsTotal)))) + (")") : ""
        flag 4 (0x5L): googlePlaceModel.vicinity != null ? googlePlaceModel.vicinity : "No Address"
        flag 5 (0x6L): googlePlaceModel.vicinity != null ? googlePlaceModel.vicinity : "No Address"
        flag 6 (0x7L): googlePlaceModel.name != null ? googlePlaceModel.name : "No Name"
        flag 7 (0x8L): googlePlaceModel.name != null ? googlePlaceModel.name : "No Name"
        flag 8 (0x9L): googlePlaceModel.rating != null ? String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.rating)) : "New"
        flag 9 (0xaL): googlePlaceModel.rating != null ? String.valueOf(androidx.databinding.ViewDataBinding.safeUnbox(googlePlaceModel.rating)) : "New"
    flag mapping end*/
    //end
}