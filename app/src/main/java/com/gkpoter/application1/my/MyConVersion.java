package com.gkpoter.application1.my;

import android.app.Activity;
import android.content.Intent;

import com.gkpoter.localfileselectionlibrary.impl.conversion.ConVersionBase;
import com.gkpoter.localfileselectionlibrary.thread.interface_.TaskCallBack;

/**
 * Created by "nullpointexception0" on 2019/6/29.
 */
public class MyConVersion extends ConVersionBase<Void,Void,String> {

    public MyConVersion(Activity activity, Intent intent) {
        super(activity, intent);
    }


    @Override
    protected String doInBackground(Void... voids) {
        return null;
    }

    @Override
    public Object forCall() {
        return null;
    }

    @Override
    public void forCall(TaskCallBack callBack) {
        super.forCall(callBack);
    }
}
