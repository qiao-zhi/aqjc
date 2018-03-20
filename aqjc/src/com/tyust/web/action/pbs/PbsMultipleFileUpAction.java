package com.tyust.web.action.pbs;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.Date;
import java.util.Map;
import com.opensymphony.xwork2.ActionSupport;
import com.tyust.bean.pbs.PbsPic;
import com.tyust.common.DefaultValue;
import com.tyust.common.FileNameUtil;
import com.tyust.common.ResourcesUtil;
import com.tyust.common.UUIDUtil;
import com.tyust.common.image.ImageScale;
import com.tyust.service.pbs.PbsTestReportService;

 /*      
  * 项目名称：aqjc   
  * 类名称：MultipleFileUpAction   
  * 类描述：struts多文件上传，保存屏蔽室检测报告的图片信息   
  * 创建人：LL   
  * 创建时间：2018年3月9日 下午2:11:12     
  * @version    
  *    
  */
public class  PbsMultipleFileUpAction extends ActionSupport{
    
	private static final long serialVersionUID = 1L;
	
	private File[] fileName;
    private String[] fileNameContentType;
    private String[] fileNameFileName;
    private String applyId;//申请ID
    private String pictureType;//图片类型
    private String fileNewName;//生成文件的UUID的名称
    private Map<String, Object> jsonStr;//回显结果
         
    private PbsTestReportService pbsTestReportService;
    
    public String execute() throws Exception{
    	PbsPic pbsPic = null;
        for(int i=0;i<fileName.length;i++){
                //从资源文件中读取到路径
            String basePath = ResourcesUtil.getValue("path", "pbspicture");//获取到保存图片的目录           
            String sufix = FileNameUtil.getFileSufix(fileNameFileName[i]);//获取文件的后缀
            fileNewName = UUIDUtil.getUUID2();//利用UUID生成一个新的名字
            
          
            String dir = basePath+fileNewName+"."+sufix;
            FileOutputStream outputStream = new FileOutputStream(dir);
            
            FileInputStream inputStream = new FileInputStream(fileName[i]);
            byte[] buffer = new byte[1024];
            int len = 0;
            //从此输入流中将最多 b.length 个字节的数据读入一个 byte 数组中.读入缓冲区的字节总数，如果因为已经到达文件末尾而没有更多的数据，则返回 -1。
            while((len = inputStream.read(buffer))!=-1){
                //将指定 byte 数组中从偏移量 off 开始的 len 个字节写入此文件输出流。
                outputStream.write(buffer, 0, len);
            }
            inputStream.close();
            outputStream.close();
           
            //文件名称
            String imageFileName = fileNewName+"."+sufix;
            //缩放图片
            scalePicToDisk(imageFileName,"pbspicture");
            
            //保存完毕之后保存数据库信息                       
            pbsPic = new PbsPic();
            pbsPic.setPbsApplyId(applyId);
            pbsPic.setPbsPicDate(new Date());
            pbsPic.setPbsPicId(UUIDUtil.getUUID2());
            pbsPic.setPbsPicName(fileNameFileName[i]);
            pbsPic.setPbsPicType(pictureType);
            pbsPic.setPbsPicUrl(fileNewName+"."+sufix);
            pbsTestReportService.getPbsPicDAO().insert(pbsPic);            
        }
        return SUCCESS;
    } 	
 	
    //压缩图片
    public void scalePicToDisk(String imageFileName,String pathKey){
    	//图片伸缩的宽度、高度
		int scaledWidth,scaledHeight;
		//设置图片伸缩大小 1：平面简图  2：检测过程图片 4、屏蔽室图片
		if (pictureType.equals("1")) {
			scaledWidth = DefaultValue.PIC_PLANE_DIAGRAM_WIDTH;
			scaledHeight = DefaultValue.PIC_PLANE_DIAGRAM_HEIGHT;
		}else if(pictureType.equals("2")||pictureType.equals("4")){
			scaledWidth = 280;
			scaledHeight = 280;
		}else{
			scaledWidth = 280;
			scaledHeight = 280;
		}
        
        //对磁盘中的文件进行缩放处理
        ImageScale.scaleToDisk(imageFileName,pathKey, scaledWidth, scaledHeight);
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

	public PbsTestReportService getPbsTestReportService() {
		return pbsTestReportService;
	}

	public void setPbsTestReportService(PbsTestReportService pbsTestReportService) {
		this.pbsTestReportService = pbsTestReportService;
	}

	
	
	
}