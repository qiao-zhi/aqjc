package com.tyust.service.pbs;

import java.io.File;
import java.util.UUID;

import com.tyust.bean.pbs.PbsBaseInfo;
import com.tyust.bean.pbs.PbsBuilder;
import com.tyust.bean.pbs.PbsDevice;
import com.tyust.common.FileHandler;
import com.tyust.dao.pbs.PbsBaseInfoDAO;
import com.tyust.dao.pbs.PbsBuilderDAO;
import com.tyust.dao.pbs.PbsDeviceDAO;

public class PbsInfoService {
	private PbsBaseInfoDAO pbsBaseInfoDAO;
	private PbsBuilderDAO pbsBuilderDAO;
	private PbsDeviceDAO pbsDeviceDAO;

	public PbsDeviceDAO getPbsDeviceDAO() {
		return pbsDeviceDAO;
	}

	public void setPbsDeviceDAO(PbsDeviceDAO pbsDeviceDAO) {
		this.pbsDeviceDAO = pbsDeviceDAO;
	}

	public PbsBuilderDAO getPbsBuilderDAO() {
		return pbsBuilderDAO;
	}

	public void setPbsBuilderDAO(PbsBuilderDAO pbsBuilderDAO) {
		this.pbsBuilderDAO = pbsBuilderDAO;
	}

	public PbsBaseInfoDAO getPbsBaseInfoDAO() {
		return pbsBaseInfoDAO;
	}

	public void setPbsBaseInfoDAO(PbsBaseInfoDAO pbsBaseInfoDAO) {
		this.pbsBaseInfoDAO = pbsBaseInfoDAO;
	}

	public int savePbsInfo(PbsBaseInfo info,String operate,File pmPic,String pmPicName){
		int res = 0;
		if("add".equals(operate)){
			String id = UUID.randomUUID().toString();
			if(pmPic!=null){
				String fileType = pmPicName.substring(pmPicName.indexOf("."));
				String newFileName = id + fileType;
				FileHandler.uploadFile(pmPic, newFileName, "pbsPic");
				info.setPmPic(newFileName);
			}
			info.setPbsId(id);
			pbsBaseInfoDAO.insertSelective(info);
			res = 1;
		}
		if("upd".equals(operate)){
			if(pmPic!=null){
				String picName = pbsBaseInfoDAO.selectByPrimaryKey(info.getPbsId()).getPmPic();
				FileHandler.deleteFile(picName, "pbsPic");
				String fileType = pmPicName.substring(pmPicName.indexOf("."));
				String newFileName = info.getPbsId() + fileType;
				FileHandler.uploadFile(pmPic, newFileName, "pbsPic");
				info.setPmPic(newFileName);
			}
			pbsBaseInfoDAO.updateByPrimaryKeySelective(info);
			res = 2;
		}
		return res;
	}
	
	public int savePbsBuilder(PbsBuilder info,String operate,File zzzs,File yyzz){
		int res = 0;
		if("add".equals(operate)){
			String id = UUID.randomUUID().toString();
			info.setId(id);
			pbsBuilderDAO.insertSelective(info);
			PbsBaseInfo pbs = pbsBaseInfoDAO.selectByPrimaryKey(info.getPbsId());
			pbs.setBuilderUnitId(id);
			pbsBaseInfoDAO.updateByPrimaryKeySelective(pbs);
			if(zzzs!=null){
				String fileType = info.getZzzsUrl().substring(info.getZzzsUrl().indexOf("."));
				String newFileName = id + "_zzzs" + fileType;
				FileHandler.uploadFile(zzzs, newFileName, "cjdw");
			}
			if(yyzz!=null){
				String fileType = info.getYyzzUrl().substring(info.getYyzzUrl().indexOf("."));
				String newFileName = id + "_yyzz" + fileType;
				FileHandler.uploadFile(yyzz, newFileName, "cjdw");
			}
			res = 1;
		}
		if("upd".equals(operate)){
			PbsBuilder pb = pbsBuilderDAO.selectByPrimaryKey(info.getId());
			if(zzzs!=null){
				if(pb.getZzzsUrl()!=null){
					String fileType = pb.getZzzsUrl().substring(pb.getZzzsUrl().indexOf("."));
					String fileName = pb.getId() + "_zzzs" + fileType;
					FileHandler.deleteFile(fileName, "cjdw");
				}
				String newFileType = info.getZzzsUrl().substring(info.getZzzsUrl().indexOf("."));
				String newFileName = info.getId() + "_zzzs" + newFileType;
				FileHandler.uploadFile(zzzs, newFileName, "cjdw");
			}
			if(yyzz!=null){
				if(pb.getYyzzUrl()!=null){
					String fileType = pb.getYyzzUrl().substring(pb.getYyzzUrl().indexOf("."));
					String fileName = pb.getId() + "_yyzz" + fileType;
					FileHandler.deleteFile(fileName, "cjdw");
				}
				String newFileType = info.getYyzzUrl().substring(info.getYyzzUrl().indexOf("."));
				String newFileName = info.getId() + "_yyzz" + newFileType;
				FileHandler.uploadFile(yyzz, newFileName, "cjdw");
			}
			pbsBuilderDAO.updateByPrimaryKeySelective(info);
			res = 2;
		}
		return res;
	}
	
	public int savePbsDve(PbsDevice info,String operate,String id){
		int res = 0;
		if("add".equals(operate)){
			info.setId(UUID.randomUUID().toString());
			info.setPbsId(id);
			pbsDeviceDAO.insertSelective(info);
			PbsBaseInfo pb = pbsBaseInfoDAO.selectByPrimaryKey(id);
			pb.setDeviceNum(pb.getDeviceNum()+1);
			pbsBaseInfoDAO.updateByPrimaryKeySelective(pb);
			res = 1;
		}
		if("upd".equals(operate)){
			info.setId(id);
			pbsDeviceDAO.updateByPrimaryKeySelective(info);
			res = 2;
		}
		return res;
	}
	
	public int deletePbsDve(String dveIds,String pbsId){
		int res = 0;
		String[] ids=dveIds.trim().split(","); 
		for(int i=0;i<ids.length;i++){
			pbsDeviceDAO.deleteByPrimaryKey(ids[i]);
			res++;
		}
		PbsBaseInfo pb = pbsBaseInfoDAO.selectByPrimaryKey(pbsId);
		pb.setDeviceNum(pb.getDeviceNum()-res);
		pbsBaseInfoDAO.updateByPrimaryKeySelective(pb);
		return res;
	}
}
