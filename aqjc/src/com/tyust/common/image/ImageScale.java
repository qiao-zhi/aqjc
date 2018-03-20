package com.tyust.common.image;


import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

import com.tyust.common.ResourcesUtil;

public class ImageScale {
	/**
	 * 对指定的文件进行缩放
	 * @param imageFileName
	 * @param scaledWidth
	 * @param scaledHeight
	 */
	public static void scale(String imageFileName,String path,int scaledWidth,int scaledHeight){
		String dir = FilenameUtils.separatorsToSystem(ServletActionContext.getServletContext().getRealPath(path)+"/");
		String fileType = FilenameUtils.getExtension(imageFileName);
		
		File sourceImageFile = new File(dir+imageFileName);
		File destImageFile = new File(dir+"temp."+fileType);
		System.out.println("s:"+dir+imageFileName);
		System.out.println("d:"+dir+"temp."+fileType);
		ImageUtils.fromFile(sourceImageFile)
			.size(scaledWidth, scaledHeight)
			.quality(0.8f)
			.fixedGivenSize(true)
			.toFile(destImageFile);
		try {
			FileUtils.copyFile(destImageFile, sourceImageFile);
//			FileUtils.deleteDirectory(destImageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 对磁盘中的指定文件进行缩放
	 * @param imageFileName 磁盘中的图片文件名
	 * @param pathKey	资源文件中的键
	 * @param scaledWidth
	 * @param scaledHeight
	 */
	public static void scaleToDisk(String imageFileName,String pathKey,int scaledWidth,int scaledHeight){
		String dir = ResourcesUtil.getValue("path", pathKey);
		String fileType = FilenameUtils.getExtension(imageFileName);
		
		File sourceImageFile = new File(dir+imageFileName);
		File destImageFile = new File(dir+"temp."+fileType);
		System.out.println("s:"+dir+imageFileName);
		System.out.println("d:"+dir+"temp."+fileType);
		ImageUtils.fromFile(sourceImageFile)
			.size(scaledWidth, scaledHeight)
			.quality(0.8f)
			.fixedGivenSize(true)
			.toFile(destImageFile);
		try {
			FileUtils.copyFile(destImageFile, sourceImageFile);
//			FileUtils.deleteDirectory(destImageFile);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
