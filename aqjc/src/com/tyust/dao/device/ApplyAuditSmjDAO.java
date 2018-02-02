package com.tyust.dao.device;

import com.tyust.bean.device.ApplyAuditSmj;
import com.tyust.bean.device.ApplyAuditSmjExample;
import java.util.List;

public interface ApplyAuditSmjDAO {
    /**
     * NT_APPLY_AUDIT_SMJ countByExample
     */
    int countByExample(ApplyAuditSmjExample example);

    /**
     * NT_APPLY_AUDIT_SMJ deleteByExample
     */
    int deleteByExample(ApplyAuditSmjExample example);

    /**
     * NT_APPLY_AUDIT_SMJ deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String id);

    /**
     * NT_APPLY_AUDIT_SMJ insert
     */
    void insert(ApplyAuditSmj record);

    /**
     * NT_APPLY_AUDIT_SMJ insertSelective
     */
    void insertSelective(ApplyAuditSmj record);

    /**
     * NT_APPLY_AUDIT_SMJ selectByExample
     */
    List<ApplyAuditSmj> selectByExample(ApplyAuditSmjExample example);

    /**
     * NT_APPLY_AUDIT_SMJ selectByPrimaryKey
     */
    ApplyAuditSmj selectByPrimaryKey(String id);

    /**
     * NT_APPLY_AUDIT_SMJ updateByExampleSelective
     */
    int updateByExampleSelective(ApplyAuditSmj record, ApplyAuditSmjExample example);

    /**
     * NT_APPLY_AUDIT_SMJ updateByExample
     */
    int updateByExample(ApplyAuditSmj record, ApplyAuditSmjExample example);

    /**
     * NT_APPLY_AUDIT_SMJ updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(ApplyAuditSmj record);

    /**
     * NT_APPLY_AUDIT_SMJ updateByPrimaryKey
     */
    int updateByPrimaryKey(ApplyAuditSmj record);
}