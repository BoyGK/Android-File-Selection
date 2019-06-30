package com.gkpoter.localfileselectionlibrary.interface_;

import android.support.annotation.NonNull;

import com.gkpoter.localfileselectionlibrary.SelectionController;
import com.gkpoter.localfileselectionlibrary.Type;
import com.gkpoter.localfileselectionlibrary.callback.CallBack;

import java.util.List;

public interface Selection<T> {
    /**
     * 选择单个指定文件调用接口，由用户调用
     *
     * @param callBack 负责回调数据
     */
    void select(CallBack<T> callBack);

    /**
     * 选择单个或多个指定文件调用接口，由用户调用
     *
     * @param callBack 负责回调数据
     */
    void selects(CallBack<List<T>> callBack);

    /**
     * 返回<class>SelectionController</class>实例
     *
     * @return selection
     */
    SelectionController getSelection();

    /**
     * 返回配置对象
     *
     * @return type
     */
    Type getType();
}