package com.xzw.base.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.media.AudioManager;
import android.net.ConnectivityManager;
import android.net.Uri;
import android.net.wifi.WifiManager;
import android.os.Build;
import android.provider.Settings;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Administrator on 2017/5/3.
 */

public class SettingUtil {

	//打开wifi设置页面
	public static void intentWifiSetting(Context context){
		if(Build.VERSION.SDK_INT > 10){//android3.0以上
			context.startActivity(new Intent(Settings.ACTION_SETTINGS));
		}else{
			context.startActivity(new Intent(Settings.ACTION_WIRELESS_SETTINGS));
		}
	}

	//设置wifi开关
	public static void toggleWifi(Context context,boolean enabled){
		WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);
		wifiManager.setWifiEnabled(enabled);
	}

	 //移动网络开关
	public static void toggleMobileData(Context context, boolean enabled) {
		ConnectivityManager conMgr = (ConnectivityManager) context
				.getSystemService(Context.CONNECTIVITY_SERVICE);
		Class<?> conMgrClass = null; // ConnectivityManager类
		Field iConMgrField = null; // ConnectivityManager类中的字段
		Object iConMgr = null; // IConnectivityManager类的引用
		Class<?> iConMgrClass = null; // IConnectivityManager类
		Method setMobileDataEnabledMethod = null; // setMobileDataEnabled方法
		try {
			// 取得ConnectivityManager类
			conMgrClass = Class.forName(conMgr.getClass().getName());
			// 取得ConnectivityManager类中的对象mService
			iConMgrField = conMgrClass.getDeclaredField("mService");
			// 设置mService可访问
			iConMgrField.setAccessible(true);
			// 取得mService的实例化类IConnectivityManager
			iConMgr = iConMgrField.get(conMgr);
			// 取得IConnectivityManager类
			iConMgrClass = Class.forName(iConMgr.getClass().getName());
			// 取得IConnectivityManager类中的setMobileDataEnabled(boolean)方法
			setMobileDataEnabledMethod = iConMgrClass.getDeclaredMethod(
					"setMobileDataEnabled", Boolean.TYPE);
			// 设置setMobileDataEnabled方法可访问
			setMobileDataEnabledMethod.setAccessible(true);
			// 调用setMobileDataEnabled方法
			setMobileDataEnabledMethod.invoke(iConMgr, enabled);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (NoSuchFieldException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
	}

	//GPS开关 当前若关则打开 当前若开则关闭
	public static void toggleGPS(Context context) {
		Intent gpsIntent = new Intent();
		gpsIntent.setClassName("com.android.settings",
				"com.android.settings.widget.SettingsAppWidgetProvider");
		gpsIntent.addCategory("android.intent.category.ALTERNATIVE");
		gpsIntent.setData(Uri.parse("custom:3"));
		try {
			PendingIntent.getBroadcast(context, 0, gpsIntent, 0).send();
		} catch (PendingIntent.CanceledException e) {
			e.printStackTrace();
		}
	}

	//调节系统音量
	public static void holdSystemAudio(Context context){
		AudioManager audioManager = (AudioManager) context.getSystemService(Context.AUDIO_SERVICE);
		audioManager.adjustStreamVolume(AudioManager.STREAM_SYSTEM,AudioManager.ADJUST_RAISE,AudioManager.FLAG_SHOW_UI);
	}

	/**
	 * 设置亮度
	 *
	 */
	public static void setBrightness(Activity activity,int step) {
		ContentResolver resolver = activity.getContentResolver();
		Uri uri = Settings.System
				.getUriFor("screen_brightness");
		int nowScreenBri = getScreenBrightness(activity);
		nowScreenBri = nowScreenBri <= 225 ? nowScreenBri + step : step;
		Settings.System.putInt(resolver, "screen_brightness",
				nowScreenBri);
		resolver.notifyChange(uri, null);
	}

	/**
	 * 获取屏幕的亮度
	 */
	public static int getScreenBrightness(Activity activity) {
		int nowBrightnessValue = 0;
		ContentResolver resolver = activity.getContentResolver();
		try {
			nowBrightnessValue = Settings.System.getInt(
					resolver, Settings.System.SCREEN_BRIGHTNESS);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return nowBrightnessValue;
	}


	//跳转到系统设置
	public static void intentSetting(Context context){
		String pkg = "com.android.settings";
		String cls = "com.android.settings.Settings";
		ComponentName componentName = new ComponentName(pkg,cls);
		Intent intent = new Intent();
		intent.setComponent(componentName);
		context.startActivity(intent);
	}



}
