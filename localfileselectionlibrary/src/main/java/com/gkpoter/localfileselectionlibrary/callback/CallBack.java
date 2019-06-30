package com.gkpoter.localfileselectionlibrary.callback;

public interface CallBack<T> {
    /**
     * 用户调用，回调选择对象
     *
     * @param t 指定类型对象
     */
    void call(T t);
}