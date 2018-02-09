package com.tyust.bean.pbs;

 /*      
  * 项目名称：aqjc   
  * 类名称：PbsTestInstrument   
  * 类描述：   新增的屏蔽室检测仪器实体类
  * 创建人：LL   
  * 创建时间：2018年2月8日 下午3:50:13     
  * @version    
  *    
  */
public class PbsTestInstrument {
    private String ptiId;

    private String pbsTestReportId;

    private String instrumentId;

    public String getPtiId() {
        return ptiId;
    }

    public void setPtiId(String ptiId) {
        this.ptiId = ptiId == null ? null : ptiId.trim();
    }

    public String getPbsTestReportId() {
        return pbsTestReportId;
    }

    public void setPbsTestReportId(String pbsTestReportId) {
        this.pbsTestReportId = pbsTestReportId == null ? null : pbsTestReportId.trim();
    }

    public String getInstrumentId() {
        return instrumentId;
    }

    public void setInstrumentId(String instrumentId) {
        this.instrumentId = instrumentId == null ? null : instrumentId.trim();
    }
}