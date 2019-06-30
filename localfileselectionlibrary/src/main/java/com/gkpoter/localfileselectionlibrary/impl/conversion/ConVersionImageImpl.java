package com.gkpoter.localfileselectionlibrary.impl.conversion;

import android.app.Activity;
import android.content.ClipData;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;

import com.gkpoter.localfileselectionlibrary.base.SelectImage;
import com.gkpoter.localfileselectionlibrary.base.SimpleBase;
import com.gkpoter.localfileselectionlibrary.interface_.ConVersionImage;
import com.gkpoter.localfileselectionlibrary.thread.interface_.TaskCallBack;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class ConVersionImageImpl extends ConVersionBase<String, Void, Object>
        implements ConVersionImage {

    public ConVersionImageImpl(Activity activity, Intent intent) {
        super(activity, intent);
    }

    @Override
    public Bitmap getBitmap() {
        return getBitmap(getIntent().getData());
    }

    @Override
    public List<Bitmap> getBitmaps() {
        ClipData clipData = getIntent().getClipData();
        List<Bitmap> bitmaps;
        if (clipData != null) {
            int itemCount = clipData.getItemCount();
            bitmaps = new ArrayList<>(itemCount);
            for (int i = 0; i < itemCount; i++) {
                Bitmap bitmap = getBitmap(clipData.getItemAt(i).getUri());
                bitmaps.add(bitmap);
            }
        } else {
            bitmaps = new ArrayList<>(1);
            Bitmap bitmap = getBitmap(getIntent().getData());
            bitmaps.add(bitmap);
        }
        return bitmaps;
    }

    @Override
    public List<File> getFiles() {
        return null;
    }

    @Override
    protected Object doInBackground(String... strings) {
        return doWork(strings[0]);
    }

    @Override
    public Object forCall() {
        return doWork(getActivity().getIntent().getStringExtra(SimpleBase.RETURN_FUNCTION));
    }

    @Override
    public void forCall(TaskCallBack callBack) {
        super.forCall(callBack);
        execute(getActivity().getIntent().getStringExtra(SimpleBase.RETURN_FUNCTION));
    }

    private Bitmap getBitmap(Uri uri) {
        InputStream is = null;
        try {
            is = getActivity().getContentResolver().openInputStream(uri);
            return BitmapFactory.decodeStream(is);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    private Object doWork(String fun) {
        switch (fun) {
            case SelectImage.RETURN_FUNCTION_GET_BITMAP:
                return getBitmap(getIntent().getData());
            case SelectImage.RETURN_FUNCTION_GET_BITMAPS:
                return getBitmaps();
            case SelectImage.RETURN_FUNCTION_GET_FILE:
                return getFile();
            case SelectImage.RETURN_FUNCTION_GET_FILES:
                return getFiles();
            default:
                break;
        }
        return null;
    }
}