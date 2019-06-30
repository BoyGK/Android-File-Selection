package com.gkpoter.localfileselectionlibrary;

import com.gkpoter.localfileselectionlibrary.base.SelectImage;
import com.gkpoter.localfileselectionlibrary.base.SelectVideo;
import com.gkpoter.localfileselectionlibrary.base.SimpleBase;

public class Type {

    /**
     * 运行哪种线程，默认异步线程
     */
    static String RUN_THREAD = Async.RUN_ASYNC_THREAD;

    /**
     * 转主线程
     */
    public void main() {
        RUN_THREAD = Async.RUN_MAIN_THREAD;
    }

    /**
     * 转异步
     */
    public void async() {
        RUN_THREAD = Async.RUN_ASYNC_THREAD;
    }

    /**
     * 选择返回参数类型，默认<return>File</return>
     */
    public static String RETURN_TYPE = SimpleBase.RETURN_TYPE_FILE;

    /**
     * 调整为File类型，对应所有文件选择
     */
    public void file() {
        RETURN_TYPE = SimpleBase.RETURN_TYPE_FILE;
    }

    /**
     * 调整为bitmap类型，对应为图片选择
     */
    public void bitmap() {
        RETURN_TYPE = SelectImage.RETURN_TYPE_BITMAP;
    }

    /**
     * 调整为<string>path</string>类型，对应为音视频选择
     */
    public void path() {
        RETURN_TYPE = SelectVideo.RETURN_TYPE_PATH;
    }

    /**
     * 内部类，包含运行线程的标记
     */
    static class Async {
        /**
         * UI线程
         */
        static final String RUN_MAIN_THREAD = "run_main_thread";

        /**
         * 异步线程，基于<class>AsyncTask</class>实现
         */
        static final String RUN_ASYNC_THREAD = "run_async_thread";
    }

}