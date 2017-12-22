package com.xzw.base.utils;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/5/3.
 * 文件管理工具类
 */

public class FileUtil {

	//获取指定路径下所有文件
	public static List<File> getFilesArray(String path){
		File[] files = (new File(path)).listFiles();
		List<File> arrayList = new ArrayList<>();
		if(files != null){
			for(File file:files){
				if(file.isFile()){
					arrayList.add(file);
				}else if(file.isDirectory()){
					arrayList.addAll(getFilesArray(file.getPath()));
				}
			}
		}
		return arrayList;
	}
}
