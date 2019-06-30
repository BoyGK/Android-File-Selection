package com.gkpoter.localfileselectionlibrary.interface_;

import android.graphics.Bitmap;

import java.io.File;
import java.util.List;

public interface ConVersionImage extends ConVersion {

    /**
     * 以bitmap格式返回图片
     *
     * @return bitmap
     */
    Bitmap getBitmap();

    /**
     * 以bitmap格式返回多张图片
     *
     * @return list
     */
    List<Bitmap> getBitmaps();

    /**
     * 以file格式返回多张图片
     *
     * @return list
     */
    List<File> getFiles();
}