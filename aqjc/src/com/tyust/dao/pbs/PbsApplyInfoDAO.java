package com.tyust.dao.pbs;

import com.tyust.bean.pbs.PbsApplyInfo;
import com.tyust.bean.pbs.PbsApplyInfoExample;
import java.util.List;

public interface PbsApplyInfoDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    int countByExample(PbsApplyInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    int deleteByExample(PbsApplyInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    int deleteByPrimaryKey(String pbsApplyId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    void insert(PbsApplyInfo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    void insertSelective(PbsApplyInfo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    List<PbsApplyInfo> selectByExample(PbsApplyInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    PbsApplyInfo selectByPrimaryKey(String pbsApplyId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    int updateByExampleSelective(PbsApplyInfo record, PbsApplyInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    int updateByExample(PbsApplyInfo record, PbsApplyInfoExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKeySelective(PbsApplyInfo record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table PBS_APPLY_INFO
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKey(PbsApplyInfo record);
    
}