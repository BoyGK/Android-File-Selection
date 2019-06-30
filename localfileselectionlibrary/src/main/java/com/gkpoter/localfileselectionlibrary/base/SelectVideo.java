package com.gkpoter.localfileselectionlibrary.base;

import android.content.Intent;

public class SelectVideo extends SimpleBase{

	/**
	 * Selection对应函数标记
	 */
	public static final String RETURN_FUNCTION_GET_FILE = "getFile";
	public static final String RETURN_FUNCTION_GET_PATH = "getPath";

	/**
	 * 数据返回类型
	 */
	public static final String RETURN_TYPE_PATH = "path";

	/**
	 * 获取选择视频intent
	 * @return intent
	 */
	public static Intent getIntent(){
		Intent intent  = new Intent(Intent.ACTION_GET_CONTENT);
		intent.setType(SELECT_VIDEO);
		return intent;
	}

}