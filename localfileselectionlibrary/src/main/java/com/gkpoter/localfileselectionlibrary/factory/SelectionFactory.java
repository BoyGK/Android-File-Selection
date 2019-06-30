package com.gkpoter.localfileselectionlibrary.factory;

import android.app.Activity;

import com.gkpoter.localfileselectionlibrary.impl.SelectionAudioImpl;
import com.gkpoter.localfileselectionlibrary.impl.SelectionImageImpl;
import com.gkpoter.localfileselectionlibrary.impl.SelectionVideoImpl;
import com.gkpoter.localfileselectionlibrary.interface_.Selection;
import com.gkpoter.localfileselectionlibrary.interface_.SelectionAudio;
import com.gkpoter.localfileselectionlibrary.interface_.SelectionImage;
import com.gkpoter.localfileselectionlibrary.interface_.SelectionVideo;

import java.lang.reflect.InvocationTargetException;

/**
 * 选择工厂，返回负责选择数据的Selection对象
 */
public class SelectionFactory {

    public static <T> Selection<T> getSelection(Activity activity, Class<?> clazz) {
        if (clazz == SelectionImage.class) {
            return new SelectionImageImpl<>(activity);
        } else if (clazz == SelectionAudio.class) {
            return new SelectionAudioImpl<>(activity);
        } else if (clazz == SelectionVideo.class) {
            return new SelectionVideoImpl<>(activity);
        }
        try {
            //对应 用户自定义扩展类，生成指定选择对象
            return (Selection<T>) clazz.getConstructor(Activity.class).newInstance(activity);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}