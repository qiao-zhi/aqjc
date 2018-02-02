package com.tyust.dao.app;

import com.tyust.bean.app.TestReportPic;
import com.tyust.bean.app.TestReportPicExample;
import java.util.List;

public interface TestReportPicDAO {
    /**
     * NT_TEST_REPORT_PIC countByExample
     */
    int countByExample(TestReportPicExample example);

    /**
     * NT_TEST_REPORT_PIC deleteByExample
     */
    int deleteByExample(TestReportPicExample example);

    /**
     * NT_TEST_REPORT_PIC deleteByPrimaryKey
     */
    int deleteByPrimaryKey(String picId);

    /**
     * NT_TEST_REPORT_PIC insert
     */
    void insert(TestReportPic record);

    /**
     * NT_TEST_REPORT_PIC insertSelective
     */
    void insertSelective(TestReportPic record);

    /**
     * NT_TEST_REPORT_PIC selectByExample
     */
    List<TestReportPic> selectByExample(TestReportPicExample example);

    /**
     * NT_TEST_REPORT_PIC selectByPrimaryKey
     */
    TestReportPic selectByPrimaryKey(String picId);

    /**
     * NT_TEST_REPORT_PIC updateByExampleSelective
     */
    int updateByExampleSelective(TestReportPic record, TestReportPicExample example);

    /**
     * NT_TEST_REPORT_PIC updateByExample
     */
    int updateByExample(TestReportPic record, TestReportPicExample example);

    /**
     * NT_TEST_REPORT_PIC updateByPrimaryKeySelective
     */
    int updateByPrimaryKeySelective(TestReportPic record);

    /**
     * NT_TEST_REPORT_PIC updateByPrimaryKey
     */
    int updateByPrimaryKey(TestReportPic record);
}