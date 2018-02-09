package com.tyust.bean.pbs;

 /*      
  * 项目名称：aqjc   
  * 类名称：PbsTestDatas   
  * 类描述：   新增的屏蔽室检测报告检测数据实体类
  * 创建人：LL   
  * 创建时间：2018年2月8日 下午3:49:27     
  * @version    
  *    
  */
public class PbsTestDatas {
    private String datasId;

    private String pbsTestReportId;

    private String pbsTestShield;

    private String datas14kHz;

    private String datas100kHz;

    private String datas450kHz;

    private String datas950kHz;

    private String datas6gHz;

    public String getDatasId() {
        return datasId;
    }

    public void setDatasId(String datasId) {
        this.datasId = datasId == null ? null : datasId.trim();
    }

    public String getPbsTestReportId() {
        return pbsTestReportId;
    }

    public void setPbsTestReportId(String pbsTestReportId) {
        this.pbsTestReportId = pbsTestReportId == null ? null : pbsTestReportId.trim();
    }

    public String getPbsTestShield() {
        return pbsTestShield;
    }

    public void setPbsTestShield(String pbsTestShield) {
        this.pbsTestShield = pbsTestShield == null ? null : pbsTestShield.trim();
    }

    public String getDatas14kHz() {
        return datas14kHz;
    }

    public void setDatas14kHz(String datas14kHz) {
        this.datas14kHz = datas14kHz == null ? null : datas14kHz.trim();
    }

    public String getDatas100kHz() {
        return datas100kHz;
    }

    public void setDatas100kHz(String datas100kHz) {
        this.datas100kHz = datas100kHz == null ? null : datas100kHz.trim();
    }

    public String getDatas450kHz() {
        return datas450kHz;
    }

    public void setDatas450kHz(String datas450kHz) {
        this.datas450kHz = datas450kHz == null ? null : datas450kHz.trim();
    }

    public String getDatas950kHz() {
        return datas950kHz;
    }

    public void setDatas950kHz(String datas950kHz) {
        this.datas950kHz = datas950kHz == null ? null : datas950kHz.trim();
    }

    public String getDatas6gHz() {
        return datas6gHz;
    }

    public void setDatas6gHz(String datas6gHz) {
        this.datas6gHz = datas6gHz == null ? null : datas6gHz.trim();
    }
}