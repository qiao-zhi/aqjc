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
	
	/******S ll*****/
	/**
	 * 配置虚拟路径上传文件到本地磁盘
	 * @param f  需要上传的文件
	 * @param fileName	保存到磁盘的文件名
	 * @param pathKey	资源文件中的键 path.properties
	 */
	public static void uploadFileToDisk(File f,String fileName,String pathKey){
		//从资源文件中读取文件的基本目录	
		String basePath = ResourcesUtil.getValue("path", pathKey);
		//获取文件的后缀
		String sufix = FileNameUtil.getFileSufix(fileName);
		//获取文件的前缀
		String prefix = FileNameUtil.getFilePrefix(fileName);
		//保存到硬盘的文件的完整路径
        String dir = basePath+fileName;
		try{
			InputStream streamIn = new FileInputStream(f);
			OutputStream streamOut = new FileOutputStream(new File(dir));
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
		
		//如果文件是doc或者docx文件将文件转为pdf存一份到服务器
        if("doc".equals(sufix)||"docx".equals(sufix)){
        	try {
				Word2PdfUtil.word2pdf(dir, basePath+prefix+".pdf");
			} catch (Exception e) {				
				e.printStackTrace();
			}
        }
	}
	
	/**
	 * 删除磁盘中的文件
	 * 因为需要将word文档转为PDF，所以有可能有两个文件名相同但是后缀不同的文件，需要一并删除
	 * @param fileName 磁盘中保存的文件名
	 * @param pathKey  资源文件中的key
	 * @return
	 */
	public static boolean deleteFileFromDisk(String fileName,String pathKey){
		if (fileName == null) {
			return false;
		}
		// 获取文件的基本目录
		String dir = ResourcesUtil.getValue("path", pathKey);
		// 获取文件的基本名字
		String baseName = FilenameUtils.getBaseName(fileName);
		if(new File(dir + baseName + ".pdf").exists()) new File(dir + baseName + ".pdf").delete();	
		if(new File(dir + baseName + ".doc").exists()) new File(dir + baseName + ".doc").delete();
		if(new File(dir + baseName + ".docx").exists()) new File(dir + baseName + ".docx").delete();		
		return true;
	}
	
	public static boolean deletePictureFromDisk(String fileName,String pathKey){
		if (fileName == null) {
			return false;
		}
		String dir = ResourcesUtil.getValue("path", pathKey);// 获取文件图片的基本目录
		new File(dir + fileName).delete();
		return true;
	}
	/******D ll*****/
		
}
