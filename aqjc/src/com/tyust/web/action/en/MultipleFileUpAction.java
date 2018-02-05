package com.tyust.web.action.en;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
/**
 * Struts上传多个文件
 * @author QiaoLiQiang
 * @time 2018年2月5日下午3:58:33
 */
public class  MultipleFileUpAction extends ActionSupport{

    private File[] fileName;
    private String[] fileNameContentType;
    private String[] fileNameFileName;
    
    public String execute() throws Exception{
        
        for(int i=0;i<fileName.length;i++){
            ServletContext servletContext = ServletActionContext.getServletContext();
            String dir = servletContext.getRealPath("/files/"+fileNameFileName[i]);
            System.out.println(dir);
            FileOutputStream outputStream = new FileOutputStream(dir);
            FileInputStream inputStream = new FileInputStream(fileName[i]);
            byte[] buffer = new byte[1024];
            int len = 0;
//        从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中.读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。
            while((len = inputStream.read(buffer))!=-1){
//            将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
                outputStream.write(buffer, 0, len);
            }
            inputStream.close();
            outputStream.close();
        }
        return SUCCESS;
    }

    public File[] getFileName() {
        return fileName;
    }

    public void setFileName(File[] fileName) {
        this.fileName = fileName;
    }

    public String[] getFileNameContentType() {
        return fileNameContentType;
    }

    public void setFileNameContentType(String[] fileNameContentType) {
        this.fileNameContentType = fileNameContentType;
    }

    public String[] getFileNameFileName() {
        return fileNameFileName;
    }

    public void setFileNameFileName(String[] fileNameFileName) {
        this.fileNameFileName = fileNameFileName;
    }



    
}