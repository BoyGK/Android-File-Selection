package com.gkpoter.localfileselectionlibrary.impl.conversion;

import android.app.Activity;
import android.content.Intent;

import com.gkpoter.localfileselectionlibrary.base.SelectVideo;
import com.gkpoter.localfileselectionlibrary.base.SimpleBase;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersionVideo;
import com.gkpoter.localfileselectionlibrary.thread.interface_.TaskCallBack;

public class ConVersionVideoImpl extends ConVersionBase<String, Void, Object>
        implements ConVersionVideo {

    public ConVersionVideoImpl(Activity activity, Intent intent) {
        super(activity, intent);
    }

    @Override
    protected Object doInBackground(String... strings) {
        return doWork(strings[0]);
    }

    @Override
    public String getPath() {
        return getFile().getPath();
    }

    @Override
    public Object forCall() {
        return doWork(getActivity().getIntent().getStringExtra(SimpleBase.RETURN_FUNCTION));
    }

    @Override
    public void forCall(TaskCallBack callBack) {
        super.forCall(callBack);
        execute(getActivity().getIntent().getStringExtra(SimpleBase.RETURN_FUNCTION));
    }

    private Object doWork(String fun) {
        switch (fun) {
            case SelectVideo.RETURN_FUNCTION_GET_FILE:
                return getFile();
            case SelectVideo.RETURN_FUNCTION_GET_PATH:
                return getPath();
            default:
                break;
        }
        return null;
    }
}