package com.gkpoter.localfileselectionlibrary.impl;

import android.app.Activity;

import com.gkpoter.localfileselectionlibrary.Type;
import com.gkpoter.localfileselectionlibrary.base.SelectVideo;
import com.gkpoter.localfileselectionlibrary.base.SimpleBase;
import com.gkpoter.localfileselectionlibrary.callback.CallBack;
import com.gkpoter.localfileselectionlibrary.interface_.SelectionVideo;

import java.util.List;

public class SelectionVideoImpl<T> extends SelectionBase<T> implements SelectionVideo<T> {

    public SelectionVideoImpl(Activity activity) {
        super(activity);
    }

    @Override
    public void select(CallBack<T> callBack) {
        setCallBack(callBack);
        if (Type.RETURN_TYPE.equals(SelectVideo.RETURN_TYPE_FILE)) {
            getActivity().getIntent().putExtra(SimpleBase.RETURN_FUNCTION, SelectVideo.RETURN_FUNCTION_GET_FILE);
        } else if (Type.RETURN_TYPE.equals(SelectVideo.RETURN_TYPE_PATH)) {
            getActivity().getIntent().putExtra(SimpleBase.RETURN_FUNCTION, SelectVideo.RETURN_FUNCTION_GET_PATH);
        }
        getActivity().startActivityForResult(SelectVideo.getIntent(), SimpleBase.REQUEST_CODE_VIDEO);
    }

    @Override
    public void selects(CallBack<List<T>> callBack) {
        setCallBack(callBack);
        // TODO: 2019/6/29 视频未考虑多个同时选取，可自定义添加
    }

}