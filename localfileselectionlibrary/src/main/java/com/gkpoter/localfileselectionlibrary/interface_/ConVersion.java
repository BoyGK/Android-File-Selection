package com.gkpoter.localfileselectionlibrary.interface_;

import com.gkpoter.localfileselectionlibrary.thread.interface_.TaskCallBack;

import java.io.File;

/**
 * 处理数据转换接口，将本地Uri转换为需求参数
 */
public interface ConVersion {
    /**
     * 返回文件
     * @return file
     */
    File getFile();

    /**
     * 返回指定类型，例如图片bitmap，集合list等
     * @return object
     */
    Object forCall();

    /**
     * 通过TaskCallBack返回指定类型，例如图片bitmap，集合list等
     * @return object
     */
    void forCall(TaskCallBack callBack);

    /**
     * 清空AsyncTask对Activity的引用
     */
    void flush();
}