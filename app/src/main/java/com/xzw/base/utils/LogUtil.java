package com.xzw.base.utils;

import android.text.TextUtils;
import android.util.Log;

/**
 *
 * LogUtil工具说明：
 * 只输出等级大于等于LEVEL的日志
 * 所以在开发和产品发布后通过修改LEVEL来选择性输出日志.
 * 当LEVEL=NOTHING则屏蔽了所有的日志
 * V,D,I,W,E均对应两个方法.
 * 若不设置TAG或者TAG为空则设置默认TAG
 */

public class LogUtil{

	public static final int VERBOSE = 1;
	public static final int DEBUG = 2;
	public static final int INFO = 3;
	public static final int WARM = 4;
	public static final int ERROR = 5;
	public static final int NOTHING = 6;
	public static int LEVEL = VERBOSE;


	public static void v(String message){
		if(LEVEL <= VERBOSE){
			StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
			Log.v(getDefaultTag(stackTraceElement),message);
		}
	}
	public static void v(String TAG,String message){
		if(LEVEL <= VERBOSE){
			if(TextUtils.isEmpty(TAG)){
				StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
				TAG = getDefaultTag(stackTraceElement);
			}
			Log.v(TAG,message);
		}
	}

	public static void d(String message){
		if(LEVEL <= DEBUG){
			StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
			Log.d(getDefaultTag(stackTraceElement),message);
		}
	}
	public static void d(String TAG,String message){
		if(LEVEL <= DEBUG){
			if(TextUtils.isEmpty(TAG)){
				StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
				TAG = getDefaultTag(stackTraceElement);
			}
			Log.d(TAG,message);
		}
	}

	public static void i(String message){
		if(LEVEL <= INFO){
			StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
			Log.i(getDefaultTag(stackTraceElement),message);
		}
	}

	public static void i(String TAG,String message){
		if(LEVEL <= INFO){
			if(TextUtils.isEmpty(TAG)){
				StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
				TAG = getDefaultTag(stackTraceElement);
			}
			Log.i(TAG,message);
		}
	}

	public static void w(String message){
		if(LEVEL <= WARM){
			StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
			Log.w(getDefaultTag(stackTraceElement),message);
		}
	}
	public static void w(String TAG,String message){
		if(LEVEL <= WARM){
			if(TextUtils.isEmpty(TAG)){
				StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
				TAG = getDefaultTag(stackTraceElement);
			}
			Log.w(TAG,message);
		}
	}

	public static void e(String message){
		if(LEVEL <= ERROR){
			StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
			Log.e(getDefaultTag(stackTraceElement),message);
		}
	}
	public static void e(String TAG,String message){
		if(LEVEL <= ERROR){
			if(TextUtils.isEmpty(TAG)){
				StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
				TAG = getDefaultTag(stackTraceElement);
			}
			Log.e(TAG,message);
		}
	}

	//设置打印日志的等级
	public static void setLevel(int level){
		LEVEL = level;
	}

	//获得当前线程信息，打印所在的行数，文件名等内容
	public static String getLogInfo(StackTraceElement stackTraceElement){
		StringBuilder sb = new StringBuilder();
		String threadName = Thread.currentThread().getName();
		long threadId = Thread.currentThread().getId();
		String fileName = stackTraceElement.getFileName();
		String className = stackTraceElement.getClassName();
		String methodName = stackTraceElement.getMethodName();
		int lineNumber = stackTraceElement.getLineNumber();
		sb.append("[");
		sb.append("threadName=").append(threadName).append(",");
		sb.append("threadid=").append(threadId).append(",");
		sb.append("fileName=").append(fileName).append(",");
		sb.append("className=").append(className).append(",");
		sb.append("methodName=").append(methodName).append(",");
		sb.append("lineNumber=").append(lineNumber).append("]");
		return sb.toString();
	}
	//获得默认的TAG，如果在MainActivity.java中调用，则TAG == MainActivity
	private static String getDefaultTag(StackTraceElement stackTraceElement){
		String filename = stackTraceElement.getFileName();
		String fileArray[] = filename.split("\\.");
		String tag = fileArray[0];
		return tag;
	}


}
