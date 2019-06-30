package com.gkpoter.localfileselectionlibrary.interface_;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;

import com.gkpoter.localfileselectionlibrary.thread.AsyncConVersionTask;
import com.gkpoter.localfileselectionlibrary.util.FileUtils;

import java.io.File;

public abstract class ConVersionAbs<P, PG, R> extends AsyncConVersionTask<P, PG, R>
        implements ConVersion {

    /**
     * 当前活动实例
     */
    @SuppressLint("StaticFieldLeak")
    private Activity activity;

    /**
     * 包含数据Uri
     */
    private Intent intent;

    public ConVersionAbs(Activity activity, Intent intent) {
        this.activity = activity;
        this.intent = intent;
    }


    @Override
    public File getFile() {
        return new File(FileUtils.getPath(getActivity(), getIntent().getData()));
    }

    protected Activity getActivity() {
        return activity;
    }

    protected Intent getIntent() {
        return intent;
    }

    @Override
    protected void onPostExecute(R r) {
        super.onPostExecute(r);
        flush();
    }

    @Override
    public void flush() {
        activity = null;
    }

}