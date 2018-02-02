package com.tyust.service.pbs;

import com.tyust.bean.pbs.PbsApplyAudit;
import com.tyust.bean.pbs.PbsTestApply;
import com.tyust.dao.pbs.PbsApplyAuditDAO;
import com.tyust.dao.pbs.PbsTestApplyDAO;

public class PbsTestApplyService {
	private PbsTestApplyDAO pbsTestApplyDAO;
	private PbsApplyAuditDAO pbsApplyAuditDAO;

	public PbsApplyAuditDAO getPbsApplyAuditDAO() {
		return pbsApplyAuditDAO;
	}

	public void setPbsApplyAuditDAO(PbsApplyAuditDAO pbsApplyAuditDAO) {
		this.pbsApplyAuditDAO = pbsApplyAuditDAO;
	}

	public PbsTestApplyDAO getPbsTestApplyDAO() {
		return pbsTestApplyDAO;
	}

	public void setPbsTestApplyDAO(PbsTestApplyDAO pbsTestApplyDAO) {
		this.pbsTestApplyDAO = pbsTestApplyDAO;
	}
	
	public int addApply(PbsTestApply record){
		pbsTestApplyDAO.insertSelective(record);
		return 1;
	}
	
	public int manageApply(PbsTestApply app,PbsApplyAudit aud){
		pbsTestApplyDAO.updateByPrimaryKeySelective(app);
		pbsApplyAuditDAO.insertSelective(aud);
		return 10;
	}
}
