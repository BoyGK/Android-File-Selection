package com.gkpoter.localfileselectionlibrary.thread;

import android.os.AsyncTask;

import com.gkpoter.localfileselectionlibrary.thread.interface_.TaskCallBack;

public abstract class AsyncConVersionTask<P, PG, R> extends AsyncTask<P, PG, R> {

    /**
     * 异步任务回调接口
     */
    private TaskCallBack taskCallBack;

    /**
     * 设置异步回调对象
     *
     * @param taskCallBack 回调对象实例
     */
    protected void setTaskCallBack(TaskCallBack taskCallBack) {
        this.taskCallBack = taskCallBack;
    }

    /**
     * 任务完成回调，返回数据
     *
     * @param r
     */
    @Override
    protected void onPostExecute(R r) {
        taskCallBack.call(r);
    }
}