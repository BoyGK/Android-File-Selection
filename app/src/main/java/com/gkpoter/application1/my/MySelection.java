package com.gkpoter.application1.my;

import android.app.Activity;
import android.content.Intent;

import com.gkpoter.localfileselectionlibrary.base.SimpleBase;
import com.gkpoter.localfileselectionlibrary.callback.CallBack;
import com.gkpoter.localfileselectionlibrary.impl.SelectionBase;

import java.util.List;

/**
 * Created by "nullpointexception0" on 2019/6/29.
 */
public class MySelection<T> extends SelectionBase<T> {

    public MySelection(Activity activity) {
        super(activity);
    }

    @Override
    public void select(CallBack<T> callBack) {
        super.select(callBack);
        SimpleBase.setConVersionClass(MyConVersion.class);
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(SimpleBase.SELECT_ALL);
        getActivity().startActivityForResult(intent, SimpleBase.requestCode());
    }

    @Override
    public void selects(CallBack<List<T>> callBack) {
        super.selects(callBack);
    }
}
