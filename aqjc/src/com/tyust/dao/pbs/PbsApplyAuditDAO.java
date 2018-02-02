package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsApplyAudit;
import com.tyust.bean.pbs.PbsApplyAuditExample;
import java.util.List;

public interface PbsApplyAuditDAO {
    /**
     * NT_PBS_APPLY_AUDIT countByExample
     */
    int countByExample(PbsApplyAuditExample example);

    /**
     * NT_PBS_APPLY_AUDIT deleteByExample
     */
    int deleteByExample(PbsApplyAuditExample example);

    /**
     * NT_PBS_APPLY_AUDIT deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String auditId);

    /**
     * NT_PBS_APPLY_AUDIT insert
     */
    void insert(PbsApplyAudit record);

    /**
     * NT_PBS_APPLY_AUDIT insertSelective
     */
    void insertSelective(PbsApplyAudit record);

    /**
     * NT_PBS_APPLY_AUDIT selectByExample
     */
    List<PbsApplyAudit> selectByExample(PbsApplyAuditExample example);

    /**
     * NT_PBS_APPLY_AUDIT selectByPrimaryKey
     */
    PbsApplyAudit selectByPrimaryKey(String auditId);

    /**
     * NT_PBS_APPLY_AUDIT updateByExampleSelective
     */
    int updateByExampleSelective(PbsApplyAudit record, PbsApplyAuditExample example);

    /**
     * NT_PBS_APPLY_AUDIT updateByExample
     */
    int updateByExample(PbsApplyAudit record, PbsApplyAuditExample example);

    /**
     * NT_PBS_APPLY_AUDIT updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(PbsApplyAudit record);

    /**
     * NT_PBS_APPLY_AUDIT updateByPrimaryKey
     */
    int updateByPrimaryKey(PbsApplyAudit record);
    
    PbsApplyAudit selNewAuditInfo(String appId);
}