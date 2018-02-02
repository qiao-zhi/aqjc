package com.tyust.dao.en;

import com.tyust.bean.en.EnAttach;
import com.tyust.bean.en.EnAttachExample;
import java.util.List;

public interface EnAttachDAO {
    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    int countByExample(EnAttachExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    int deleteByExample(EnAttachExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    int deleteByPrimaryKey(String environmentAttachId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    void insert(EnAttach record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    void insertSelective(EnAttach record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    List<EnAttach> selectByExample(EnAttachExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    EnAttach selectByPrimaryKey(String environmentAttachId);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    int updateByExampleSelective(EnAttach record, EnAttachExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    int updateByExample(EnAttach record, EnAttachExample example);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKeySelective(EnAttach record);

    /**
     * This method was generated by Apache iBATIS ibator.
     * This method corresponds to the database table ENVIRONMENT_ATTACH
     *
     * @ibatorgenerated
     */
    int updateByPrimaryKey(EnAttach record);
}