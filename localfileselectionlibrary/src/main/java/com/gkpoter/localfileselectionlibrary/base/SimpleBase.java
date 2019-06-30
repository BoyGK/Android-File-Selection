package com.gkpoter.localfileselectionlibrary.base;

import android.content.Intent;
import android.util.SparseArray;

import com.gkpoter.localfileselectionlibrary.interface_.ConVersion;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersionAudio;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersionImage;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersionVideo;

public class SimpleBase {

    /**
     * intent打开type配置参数
     */
    static final String SELECT_IMAGE = "image/*";
    static final String SELECT_AUDIO = "audio/*";
    static final String SELECT_VIDEO = "video/*";

    public static final String SELECT_ALL = "*/*";
    public static final String SELECT_APPLICATION = "application/*";
    public static final String SELECT_TEXT = "text/*";

    /**
     * 指定调用函数的key
     */
    public static final String RETURN_FUNCTION = "re_function";

    /**
     * 通用返回数据类型
     */
    public static final String RETURN_TYPE_FILE = "file";

    /**
     * startActivityForResult请求码
     */
    public static final int REQUEST_CODE_IMAGE = 0;
    public static final int REQUEST_CODE_AUDIO = 1;
    public static final int REQUEST_CODE_VIDEO = 2;
    // public static final int REQUEST_CODE_ALL = 3;

    /**
     * requestCode和ConVersion映射关系
     */
    private static SparseArray<Class<? extends ConVersion>> REQUEST_CODE_FOR_CONVERSION;

    static {
        REQUEST_CODE_FOR_CONVERSION = new SparseArray<>();
        REQUEST_CODE_FOR_CONVERSION.put(REQUEST_CODE_IMAGE, ConVersionImage.class);
        REQUEST_CODE_FOR_CONVERSION.put(REQUEST_CODE_AUDIO, ConVersionAudio.class);
        REQUEST_CODE_FOR_CONVERSION.put(REQUEST_CODE_VIDEO, ConVersionVideo.class);
        // REQUEST_CODE_FOR_CONVERSION.put(REQUEST_CODE_ALL,ConVersion.class);
    }

    /**
     * 通过指定code获取ConVersion
     *
     * @param code code
     * @return conversion
     */
    public static Class<? extends ConVersion> getConVersionClass(int code) {
        return REQUEST_CODE_FOR_CONVERSION.get(code);
    }

    /**
     * 扩展对应关系
     *
     * @param clazz conversion
     */
    public static void setConVersionClass(Class<? extends ConVersion> clazz) {
        REQUEST_CODE_FOR_CONVERSION.put(REQUEST_CODE_FOR_CONVERSION.size(), clazz);
    }

    /**
     * 最近扩展的请求码
     *
     * @return code
     */
    public static int requestCode() {
        return REQUEST_CODE_FOR_CONVERSION.size() - 1;
    }

    /**
     * 基本选择配置
     *
     * @return intent
     */
    public static Intent getIntent(String selectType) {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(selectType);
        return intent;
    }

}