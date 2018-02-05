package com.tyust.web.action.en;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;

import javax.annotation.Resource;
import javax.servlet.ServletContext;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tyust.bean.en.EnAttach;
import com.tyust.common.FileNameUtil;
import com.tyust.common.ResourcesUtil;
import com.tyust.common.UUIDUtil;
import com.tyust.common.Word2PdfUtil;
import com.tyust.service.en.EnApplyInfoService;
/**
 * struts单文件上传
 * @author liqiang
 *
 */
public class OneFileUpAction  extends ActionSupport{

//	@Resource(name="enApplyInfoService")
	private EnApplyInfoService enApplyInfoService;//申请服务
	
	
    private File fileName;
    private String fileNameContentType;
    private String fileNameFileName;
    private String fileNewName;//生成文件的UUID的命称
    private String applyId;//申请编号ID(前台传来)
    private String attachType;//附件类型(前台传来)
    private String result;//附件类型(前台传来)
    
    
    public String execute() throws Exception{
        
        ServletContext servletContext = ServletActionContext.getServletContext();
        
        String basePath = ResourcesUtil.getValue("path", "file");//获取到保存的目录
        String prefix = FileNameUtil.getFilePrefix(fileNameFileName);//获取文件的前缀
        String sufix = FileNameUtil.getFileSufix(fileNameFileName);//获取文件的后缀
        fileNewName = UUIDUtil.getUUID2();//利用UUID生成一个新的名字
        
        //从资源文件中读取到路径
        String dir = basePath+fileNewName+"."+sufix;
        FileOutputStream outputStream = new FileOutputStream(dir);
        
        FileInputStream inputStream = new FileInputStream(fileName);
        byte[] buffer = new byte[1024];
        int len = 0;
//        从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中.读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。
        while((len = inputStream.read(buffer))!=-1){
//            将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
            outputStream.write(buffer, 0, len);
        }
        //关闭流
        inputStream.close();
        outputStream.close();
        //如果文件是doc或者docx文件将文件抓为pdf存一份到服务器
        if("doc".equals(FileNameUtil.getFileSufix(fileNameFileName))||"docx".equals(FileNameUtil.getFileSufix(fileNameFileName))){
        	Word2PdfUtil.word2pdf(dir, basePath+fileNewName+".pdf");
        }
        //根据上传的文件的类型进行判断，保存扫描的附件信息
        EnAttach record = new EnAttach();
        record.setEnvironmentApplyId(applyId);
        record.setEnvironmentAttachDate(new Date());
        record.setEnvironmentAttachId(UUIDUtil.getUUID2());
        record.setEnvironmentAttachName(fileNameFileName);
        record.setEnvironmentAttachUrl(fileNewName+"."+sufix);
        record.setEnvironmentAttachType(attachType);
        this.saveAttarch(record);
        result = "success";//上传结果返回前台
        return SUCCESS;
    }

    
    
    
    public String saveAttarch(EnAttach record){
    	enApplyInfoService.saveEnAttach(record);
    	return null;
    }
    
    
    
    
    
    public File getFileName() {
        return fileName;
    }

    public void setFileName(File fileName) {
        this.fileName = fileName;
    }

    public String getFileNameContentType() {
        return fileNameContentType;
    }

    public void setFileNameContentType(String fileNameContentType) {
        this.fileNameContentType = fileNameContentType;
    }

    public String getFileNameFileName() {
        return fileNameFileName;
    }

    public void setFileNameFileName(String fileNameFileName) {
        this.fileNameFileName = fileNameFileName;
    }


	public String getApplyId() {
		return applyId;
	}




	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}




	public String getAttachType() {
		return attachType;
	}

	public void setAttachType(String attachType) {
		this.attachType = attachType;
	}

	public EnApplyInfoService getEnApplyInfoService() {
		return enApplyInfoService;
	}

	public void setEnApplyInfoService(EnApplyInfoService enApplyInfoService) {
		this.enApplyInfoService = enApplyInfoService;
	}

	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getFileNewName() {
		return fileNewName;
	}

	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}
	
}