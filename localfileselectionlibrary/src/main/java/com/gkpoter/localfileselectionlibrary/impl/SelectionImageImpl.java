package com.gkpoter.localfileselectionlibrary.impl;

import android.app.Activity;

import com.gkpoter.localfileselectionlibrary.Type;
import com.gkpoter.localfileselectionlibrary.base.SelectImage;
import com.gkpoter.localfileselectionlibrary.base.SimpleBase;
import com.gkpoter.localfileselectionlibrary.callback.CallBack;
import com.gkpoter.localfileselectionlibrary.interface_.SelectionImage;

import java.util.List;

public class SelectionImageImpl<T> extends SelectionBase<T> implements SelectionImage<T> {

    public SelectionImageImpl(Activity activity) {
        super(activity);
    }

    @Override
    public void select(CallBack<T> callBack) {
        setCallBack(callBack);
        if (Type.RETURN_TYPE.equals(SelectImage.RETURN_TYPE_BITMAP)) {
            getActivity().getIntent().putExtra(SimpleBase.RETURN_FUNCTION, SelectImage.RETURN_FUNCTION_GET_BITMAP);
        } else if (Type.RETURN_TYPE.equals(SelectImage.RETURN_TYPE_FILE)) {
            getActivity().getIntent().putExtra(SimpleBase.RETURN_FUNCTION, SelectImage.RETURN_FUNCTION_GET_FILE);
        }
        getActivity().startActivityForResult(SelectImage.getIntent(), SimpleBase.REQUEST_CODE_IMAGE);
    }

    @Override
    public void selects(CallBack<List<T>> callBack) {
        setCallBack(callBack);
        if (Type.RETURN_TYPE.equals(SelectImage.RETURN_TYPE_BITMAP)) {
            getActivity().getIntent().putExtra(SimpleBase.RETURN_FUNCTION, SelectImage.RETURN_FUNCTION_GET_BITMAPS);
        } else if (Type.RETURN_TYPE.equals(SelectImage.RETURN_TYPE_FILE)) {
            getActivity().getIntent().putExtra(SimpleBase.RETURN_FUNCTION, SelectImage.RETURN_FUNCTION_GET_FILES);
        }
        getActivity().startActivityForResult(SelectImage.getChooserIntent(), SimpleBase.REQUEST_CODE_IMAGE);
    }

}