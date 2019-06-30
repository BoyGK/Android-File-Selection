package com.gkpoter.localfileselectionlibrary;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.Nullable;

import com.gkpoter.localfileselectionlibrary.base.SimpleBase;
import com.gkpoter.localfileselectionlibrary.callback.CallBack;
import com.gkpoter.localfileselectionlibrary.factory.ConVersionFactory;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersion;
import com.gkpoter.localfileselectionlibrary.thread.interface_.TaskCallBack;

import static android.app.Activity.RESULT_OK;

public class SelectionController {

    /**
     * 选择界面的活动实例
     */
    private Activity activity;

    /**
     * 负责回调选择数据的接口
     */
    private CallBack callBack;

    /**
     * 负责将系统返回的Uri数据进行转换为指定需求的接口
     */
    private ConVersion conVersion;

    protected SelectionController(Activity activity) {
        this.activity = activity;
    }

    /**
     * 核心类，由用户调用
     * 参数对应于Activity内置方法onActivityResult的参数
     *
     * @param requestCode
     * @param resultCode
     * @param data
     */
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        if (resultCode != RESULT_OK) {
            return;
        }
        if (data != null) {
            conVersion = ConVersionFactory
                    .getConVersion(SimpleBase.getConVersionClass(requestCode), activity, data);
            if (conVersion != null) {
                if (Type.RUN_THREAD.equals(Type.Async.RUN_MAIN_THREAD)) {
                    callBack.call(conVersion.forCall());
                } else if (Type.RUN_THREAD.equals(Type.Async.RUN_ASYNC_THREAD)) {
                    conVersion.forCall(new TaskCallBack() {
                        @Override
                        public void call(Object object) {
                            callBack.call(object);
                        }
                    });
                }
            }
        }
    }

    /**
     * 清空AsyncTask对Activity的引用
     */
    public void flush() {
        conVersion.flush();
    }

    /**
     * 返回活动实例对象
     *
     * @return 当前活动
     */
    protected Activity getActivity() {
        return activity;
    }

    /**
     * 设置回调接口
     *
     * @param callBack 回调对象实例
     */
    protected void setCallBack(CallBack callBack) {
        this.callBack = callBack;
    }
}