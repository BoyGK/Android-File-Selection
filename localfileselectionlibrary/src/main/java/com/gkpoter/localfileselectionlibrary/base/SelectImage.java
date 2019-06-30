package com.gkpoter.localfileselectionlibrary.base;

import android.content.Intent;

public class SelectImage extends SimpleBase {

    /**
     * Selection对应函数标记
     */
    public static final String RETURN_FUNCTION_GET_BITMAP = "getBitmap";
    public static final String RETURN_FUNCTION_GET_BITMAPS = "getBitmaps";
    public static final String RETURN_FUNCTION_GET_FILE = "getFile";
    public static final String RETURN_FUNCTION_GET_FILES = "getFiles";

    /**
     * 数据返回类型
     */
    public static final String RETURN_TYPE_BITMAP = "bitmap";


    /**
     * 获取选择图片intent
     * @return intent
     */
    public static Intent getIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(SELECT_IMAGE);
        return intent;
    }

    /**
     * 获取选择多张图片intent
     * @return intent
     */
    public static Intent getChooserIntent() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType(SELECT_IMAGE);
        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, true);
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        return intent;
    }

}