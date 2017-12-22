package com.xzw.base.utils;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 * 获取系统和用户安装的应用信息
 */

public class AppUtil{

	//获得所有应用信息
	public static List<ResolveInfo> getAllApp(Context context){
		PackageManager manager = context.getPackageManager();
		Intent intent = new Intent(Intent.ACTION_MAIN,null);
		intent.addCategory(Intent.CATEGORY_LAUNCHER);
		List<ResolveInfo> apps = manager.queryIntentActivities(intent,0);
		Collections.sort(apps,new ResolveInfo.DisplayNameComparator(manager));
		return apps;
	}

	//获得用户安装的应用信息
	public static List<ResolveInfo> getUserApp(Context context){
		List<ResolveInfo> apps = new ArrayList<>();
		List<ResolveInfo> temps = getAllApp(context);
		for(ResolveInfo info:temps){
			ApplicationInfo appInfos = info.activityInfo.applicationInfo;
			if((appInfos.flags & ApplicationInfo.FLAG_SYSTEM) <= 0){
				apps.add(info);
			}
		}
		return apps;
	}


}
