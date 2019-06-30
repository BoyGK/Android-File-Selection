package com.gkpoter.localfileselectionlibrary.impl.conversion;

import android.app.Activity;
import android.content.Intent;

import com.gkpoter.localfileselectionlibrary.interface_.ConVersionAbs;
import com.gkpoter.localfileselectionlibrary.thread.interface_.TaskCallBack;

public abstract class ConVersionBase<P,PG,R> extends ConVersionAbs<P,PG,R> {

    public ConVersionBase(Activity activity, Intent intent) {
        super(activity, intent);
    }

    @Override
    public void forCall(TaskCallBack callBack) {
        setTaskCallBack(callBack);
    }
}