package com.tyust.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import org.apache.commons.io.FilenameUtils;
import org.apache.struts2.ServletActionContext;

public class FileHandler {
	/**
	 * 上传文件
	 * @param fileName:数据库保存的文件名;path:上传路径
	 * @return
	 */
	public static void uploadFile(File f,String fileName,String path){
		String dir = FilenameUtils.separatorsToSystem(ServletActionContext.getServletContext().getRealPath("/uploads/"+path)+"/");
		try{
			InputStream streamIn = new FileInputStream(f);
			OutputStream streamOut = new FileOutputStream(new File(dir+fileName));
			int bytesRead=0;
			byte[] byffer = new byte[8192];
			while((bytesRead=streamIn.read(byffer,0,8192))!=-1){
				streamOut.write(byffer, 0, bytesRead);
			}
			streamIn.close();
			streamOut.flush();
			streamOut.close();
		} catch (IOException e) {
			e.printStackTrace();
		}	
	}
	//删除上传的文件
	public static void deleteFile(String fileName,String path){
		String dir = FilenameUtils.separatorsToSystem(ServletActionContext.getServletContext().getRealPath("/uploads/"+path)+"/");
		if(fileName != null && !"".equals(fileName)) {
			File f = new File(dir+fileName);
			if(f.exists()){
				f.delete();
			}
		}
	}
}
