package com.gkpoter.localfileselectionlibrary.impl;

import android.app.Activity;
import android.support.annotation.NonNull;

import com.gkpoter.localfileselectionlibrary.SelectionController;
import com.gkpoter.localfileselectionlibrary.Type;
import com.gkpoter.localfileselectionlibrary.callback.CallBack;
import com.gkpoter.localfileselectionlibrary.interface_.Selection;

import java.util.List;

public abstract class SelectionBase<T> extends SelectionController
        implements Selection<T> {

    public SelectionBase(Activity activity) {
        super(activity);
    }

    @Override
    public void select(CallBack<T> callBack) {
        setCallBack(callBack);
    }

    @Override
    public void selects(CallBack<List<T>> callBack) {
        setCallBack(callBack);
    }

    @Override
    public SelectionController getSelection() {
        return this;
    }

    @Override
    public Type getType() {
        return new Type();
    }
}