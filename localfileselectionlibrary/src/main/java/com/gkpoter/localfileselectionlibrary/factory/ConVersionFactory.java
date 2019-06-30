package com.gkpoter.localfileselectionlibrary.factory;

import android.app.Activity;
import android.content.Intent;

import com.gkpoter.localfileselectionlibrary.impl.conversion.ConVersionAudioImpl;
import com.gkpoter.localfileselectionlibrary.impl.conversion.ConVersionImageImpl;
import com.gkpoter.localfileselectionlibrary.impl.conversion.ConVersionVideoImpl;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersion;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersionAudio;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersionImage;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersionVideo;

import java.lang.reflect.InvocationTargetException;

/**
 * 转换工厂，返回负责转换数据的ConVersion对象
 */
public class ConVersionFactory {

    public static ConVersion getConVersion(Class<? extends ConVersion> clazz, Activity activity, Intent intent) {
        if (clazz == ConVersionImage.class) {
            return new ConVersionImageImpl(activity, intent);
        } else if (clazz == ConVersionVideo.class) {
            return new ConVersionVideoImpl(activity, intent);
        } else if (clazz == ConVersionAudio.class) {
            return new ConVersionAudioImpl(activity, intent);
        }
        try {
            //对应 用户自定义扩展类，生成指定转换对象
            return clazz.getConstructor(Activity.class, Intent.class)
                    .newInstance(activity, intent);
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