package com.tyust.web.action.en;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.tyust.bean.en.EnPic;
import com.tyust.common.FileNameUtil;
import com.tyust.common.ResourcesUtil;
import com.tyust.common.UUIDUtil;
import com.tyust.service.en.EnTestReportService;
/**
 * Struts上传多个文件(用于接收图片)
 * @author QiaoLiQiang
 * @time 2018年2月5日下午3:58:33
 */
public class  MultipleFileUpAction extends ActionSupport{

    private File[] fileName;
    private String[] fileNameContentType;
    private String[] fileNameFileName;
    private String applyId;//申请ID
    private String pictureType;//图片类型
    private String fileNewName;//生成文件的UUID的命称
    private Map<String, Object> jsonStr;//回显结果
    
    
    private EnTestReportService enTestReportService;//报告服务
    
    public String execute() throws Exception{
    	EnPic enPic = null;
        for(int i=0;i<fileName.length;i++){
            ServletContext servletContext = ServletActionContext.getServletContext();
            
            //从资源文件中读取到路径
            String basePath = ResourcesUtil.getValue("path", "picture");//获取到保存图片的目录
            String prefix = FileNameUtil.getFilePrefix(fileNameFileName[i]);//获取文件的前缀
            String sufix = FileNameUtil.getFileSufix(fileNameFileName[i]);//获取文件的后缀
            fileNewName = UUIDUtil.getUUID2();//利用UUID生成一个新的名字
            
          
            String dir = basePath+fileNewName+"."+sufix;
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
            
            //保存完毕之后保存数据库信息
            enPic = new EnPic();
            enPic.setEnApplyId(applyId);
            enPic.setEnPicDate(new Date());
            enPic.setEnPicId(UUIDUtil.getUUID2());
            enPic.setEnPicName(fileNameFileName[i]);
            enPic.setEnPicType(pictureType);
            enPic.setEnPicUrl(fileNewName+"."+sufix);
            this.saveEnPic(enPic);//保存数据库信息
        }
        return SUCCESS;
    }

 	public String saveEnPic(EnPic record) {
		String result = "success";
		jsonStr = new HashMap<String, Object>();
		HttpServletRequest request = ServletActionContext.getRequest();
		String enApplyId = request.getParameter("enApplyId");
		String picType = request.getParameter("picType");
		enTestReportService.getEnPicDAO().insert(record);
		jsonStr.put("result", result);
		return "success";
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

	public String getApplyId() {
		return applyId;
	}

	public void setApplyId(String applyId) {
		this.applyId = applyId;
	}

	public String getPictureType() {
		return pictureType;
	}

	public void setPictureType(String pictureType) {
		this.pictureType = pictureType;
	}

	public String getFileNewName() {
		return fileNewName;
	}

	public void setFileNewName(String fileNewName) {
		this.fileNewName = fileNewName;
	}

	public Map<String, Object> getJsonStr() {
		return jsonStr;
	}

	public void setJsonStr(Map<String, Object> jsonStr) {
		this.jsonStr = jsonStr;
	}

	public EnTestReportService getEnTestReportService() {
		return enTestReportService;
	}

	public void setEnTestReportService(EnTestReportService enTestReportService) {
		this.enTestReportService = enTestReportService;
	}
	
	
}