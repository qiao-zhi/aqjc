package com.tyust.bean.device;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tyust.common.IbatorGenExamplePageHelper;

public class DeviceTestReportExample extends IbatorGenExamplePageHelper{
    /**
     * NT_DEVICE_TEST_REPORT
     */
    protected String orderByClause;

    /**
     * NT_DEVICE_TEST_REPORT
     */
    protected boolean distinct;

    /**
     * NT_DEVICE_TEST_REPORT
     */
    protected List<Criteria> oredCriteria;

    /**
     * NT_DEVICE_TEST_REPORT DeviceTestReportExample
     */
    public DeviceTestReportExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * NT_DEVICE_TEST_REPORT DeviceTestReportExample
     */
    protected DeviceTestReportExample(DeviceTestReportExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * NT_DEVICE_TEST_REPORT setOrderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * NT_DEVICE_TEST_REPORT getOrderByClause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * NT_DEVICE_TEST_REPORT setDistinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * NT_DEVICE_TEST_REPORT isDistinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * NT_DEVICE_TEST_REPORT getOredCriteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * NT_DEVICE_TEST_REPORT or
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * NT_DEVICE_TEST_REPORT or
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * NT_DEVICE_TEST_REPORT createCriteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * NT_DEVICE_TEST_REPORT createCriteriaInternal
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * NT_DEVICE_TEST_REPORT clear
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * NT_DEVICE_TEST_REPORT
     */
    protected abstract static class GeneratedCriteria {
        protected List<String> criteriaWithoutValue;

        protected List<Map<String, Object>> criteriaWithSingleValue;

        protected List<Map<String, Object>> criteriaWithListValue;

        protected List<Map<String, Object>> criteriaWithBetweenValue;

        protected GeneratedCriteria() {
            super();
            criteriaWithoutValue = new ArrayList<String>();
            criteriaWithSingleValue = new ArrayList<Map<String, Object>>();
            criteriaWithListValue = new ArrayList<Map<String, Object>>();
            criteriaWithBetweenValue = new ArrayList<Map<String, Object>>();
        }

        public boolean isValid() {
            return criteriaWithoutValue.size() > 0
                || criteriaWithSingleValue.size() > 0
                || criteriaWithListValue.size() > 0
                || criteriaWithBetweenValue.size() > 0;
        }

        public List<String> getCriteriaWithoutValue() {
            return criteriaWithoutValue;
        }

        public List<Map<String, Object>> getCriteriaWithSingleValue() {
            return criteriaWithSingleValue;
        }

        public List<Map<String, Object>> getCriteriaWithListValue() {
            return criteriaWithListValue;
        }

        public List<Map<String, Object>> getCriteriaWithBetweenValue() {
            return criteriaWithBetweenValue;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteriaWithoutValue.add(condition);
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("value", value);
            criteriaWithSingleValue.add(map);
        }

        protected void addCriterion(String condition, List<? extends Object> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", values);
            criteriaWithListValue.add(map);
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            List<Object> list = new ArrayList<Object>();
            list.add(value1);
            list.add(value2);
            Map<String, Object> map = new HashMap<String, Object>();
            map.put("condition", condition);
            map.put("values", list);
            criteriaWithBetweenValue.add(map);
        }

        public Criteria andReportIdIsNull() {
            addCriterion("REPORT_ID is null");
            return (Criteria) this;
        }

        public Criteria andReportIdIsNotNull() {
            addCriterion("REPORT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andReportIdEqualTo(String value) {
            addCriterion("REPORT_ID =", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotEqualTo(String value) {
            addCriterion("REPORT_ID <>", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThan(String value) {
            addCriterion("REPORT_ID >", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdGreaterThanOrEqualTo(String value) {
            addCriterion("REPORT_ID >=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThan(String value) {
            addCriterion("REPORT_ID <", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLessThanOrEqualTo(String value) {
            addCriterion("REPORT_ID <=", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdLike(String value) {
            addCriterion("REPORT_ID like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotLike(String value) {
            addCriterion("REPORT_ID not like", value, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdIn(List<String> values) {
            addCriterion("REPORT_ID in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotIn(List<String> values) {
            addCriterion("REPORT_ID not in", values, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdBetween(String value1, String value2) {
            addCriterion("REPORT_ID between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andReportIdNotBetween(String value1, String value2) {
            addCriterion("REPORT_ID not between", value1, value2, "reportId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNull() {
            addCriterion("APPLY_ID is null");
            return (Criteria) this;
        }

        public Criteria andApplyIdIsNotNull() {
            addCriterion("APPLY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andApplyIdEqualTo(String value) {
            addCriterion("APPLY_ID =", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotEqualTo(String value) {
            addCriterion("APPLY_ID <>", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThan(String value) {
            addCriterion("APPLY_ID >", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_ID >=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThan(String value) {
            addCriterion("APPLY_ID <", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLessThanOrEqualTo(String value) {
            addCriterion("APPLY_ID <=", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdLike(String value) {
            addCriterion("APPLY_ID like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotLike(String value) {
            addCriterion("APPLY_ID not like", value, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdIn(List<String> values) {
            addCriterion("APPLY_ID in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotIn(List<String> values) {
            addCriterion("APPLY_ID not in", values, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdBetween(String value1, String value2) {
            addCriterion("APPLY_ID between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andApplyIdNotBetween(String value1, String value2) {
            addCriterion("APPLY_ID not between", value1, value2, "applyId");
            return (Criteria) this;
        }

        public Criteria andTestUserIsNull() {
            addCriterion("TEST_USER is null");
            return (Criteria) this;
        }

        public Criteria andTestUserIsNotNull() {
            addCriterion("TEST_USER is not null");
            return (Criteria) this;
        }

        public Criteria andTestUserEqualTo(String value) {
            addCriterion("TEST_USER =", value, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserNotEqualTo(String value) {
            addCriterion("TEST_USER <>", value, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserGreaterThan(String value) {
            addCriterion("TEST_USER >", value, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_USER >=", value, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserLessThan(String value) {
            addCriterion("TEST_USER <", value, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserLessThanOrEqualTo(String value) {
            addCriterion("TEST_USER <=", value, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserLike(String value) {
            addCriterion("TEST_USER like", value, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserNotLike(String value) {
            addCriterion("TEST_USER not like", value, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserIn(List<String> values) {
            addCriterion("TEST_USER in", values, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserNotIn(List<String> values) {
            addCriterion("TEST_USER not in", values, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserBetween(String value1, String value2) {
            addCriterion("TEST_USER between", value1, value2, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestUserNotBetween(String value1, String value2) {
            addCriterion("TEST_USER not between", value1, value2, "testUser");
            return (Criteria) this;
        }

        public Criteria andTestCodeIsNull() {
            addCriterion("TEST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andTestCodeIsNotNull() {
            addCriterion("TEST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andTestCodeEqualTo(String value) {
            addCriterion("TEST_CODE =", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeNotEqualTo(String value) {
            addCriterion("TEST_CODE <>", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeGreaterThan(String value) {
            addCriterion("TEST_CODE >", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_CODE >=", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeLessThan(String value) {
            addCriterion("TEST_CODE <", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeLessThanOrEqualTo(String value) {
            addCriterion("TEST_CODE <=", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeLike(String value) {
            addCriterion("TEST_CODE like", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeNotLike(String value) {
            addCriterion("TEST_CODE not like", value, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeIn(List<String> values) {
            addCriterion("TEST_CODE in", values, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeNotIn(List<String> values) {
            addCriterion("TEST_CODE not in", values, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeBetween(String value1, String value2) {
            addCriterion("TEST_CODE between", value1, value2, "testCode");
            return (Criteria) this;
        }

        public Criteria andTestCodeNotBetween(String value1, String value2) {
            addCriterion("TEST_CODE not between", value1, value2, "testCode");
            return (Criteria) this;
        }

        public Criteria andSampleNameIsNull() {
            addCriterion("SAMPLE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSampleNameIsNotNull() {
            addCriterion("SAMPLE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSampleNameEqualTo(String value) {
            addCriterion("SAMPLE_NAME =", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameNotEqualTo(String value) {
            addCriterion("SAMPLE_NAME <>", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameGreaterThan(String value) {
            addCriterion("SAMPLE_NAME >", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameGreaterThanOrEqualTo(String value) {
            addCriterion("SAMPLE_NAME >=", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameLessThan(String value) {
            addCriterion("SAMPLE_NAME <", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameLessThanOrEqualTo(String value) {
            addCriterion("SAMPLE_NAME <=", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameLike(String value) {
            addCriterion("SAMPLE_NAME like", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameNotLike(String value) {
            addCriterion("SAMPLE_NAME not like", value, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameIn(List<String> values) {
            addCriterion("SAMPLE_NAME in", values, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameNotIn(List<String> values) {
            addCriterion("SAMPLE_NAME not in", values, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameBetween(String value1, String value2) {
            addCriterion("SAMPLE_NAME between", value1, value2, "sampleName");
            return (Criteria) this;
        }

        public Criteria andSampleNameNotBetween(String value1, String value2) {
            addCriterion("SAMPLE_NAME not between", value1, value2, "sampleName");
            return (Criteria) this;
        }

        public Criteria andTestDateIsNull() {
            addCriterion("TEST_DATE is null");
            return (Criteria) this;
        }

        public Criteria andTestDateIsNotNull() {
            addCriterion("TEST_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andTestDateEqualTo(Date value) {
            addCriterion("TEST_DATE =", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateNotEqualTo(Date value) {
            addCriterion("TEST_DATE <>", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateGreaterThan(Date value) {
            addCriterion("TEST_DATE >", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateGreaterThanOrEqualTo(Date value) {
            addCriterion("TEST_DATE >=", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateLessThan(Date value) {
            addCriterion("TEST_DATE <", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateLessThanOrEqualTo(Date value) {
            addCriterion("TEST_DATE <=", value, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateIn(List<Date> values) {
            addCriterion("TEST_DATE in", values, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateNotIn(List<Date> values) {
            addCriterion("TEST_DATE not in", values, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateBetween(Date value1, Date value2) {
            addCriterion("TEST_DATE between", value1, value2, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestDateNotBetween(Date value1, Date value2) {
            addCriterion("TEST_DATE not between", value1, value2, "testDate");
            return (Criteria) this;
        }

        public Criteria andTestResultIsNull() {
            addCriterion("TEST_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andTestResultIsNotNull() {
            addCriterion("TEST_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andTestResultEqualTo(String value) {
            addCriterion("TEST_RESULT =", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotEqualTo(String value) {
            addCriterion("TEST_RESULT <>", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultGreaterThan(String value) {
            addCriterion("TEST_RESULT >", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_RESULT >=", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLessThan(String value) {
            addCriterion("TEST_RESULT <", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLessThanOrEqualTo(String value) {
            addCriterion("TEST_RESULT <=", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultLike(String value) {
            addCriterion("TEST_RESULT like", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotLike(String value) {
            addCriterion("TEST_RESULT not like", value, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultIn(List<String> values) {
            addCriterion("TEST_RESULT in", values, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotIn(List<String> values) {
            addCriterion("TEST_RESULT not in", values, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultBetween(String value1, String value2) {
            addCriterion("TEST_RESULT between", value1, value2, "testResult");
            return (Criteria) this;
        }

        public Criteria andTestResultNotBetween(String value1, String value2) {
            addCriterion("TEST_RESULT not between", value1, value2, "testResult");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(String value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(String value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(String value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(String value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(String value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(String value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLike(String value) {
            addCriterion("STATE like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotLike(String value) {
            addCriterion("STATE not like", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<String> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<String> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(String value1, String value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(String value1, String value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNull() {
            addCriterion("REMARK1 is null");
            return (Criteria) this;
        }

        public Criteria andRemark1IsNotNull() {
            addCriterion("REMARK1 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark1EqualTo(String value) {
            addCriterion("REMARK1 =", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotEqualTo(String value) {
            addCriterion("REMARK1 <>", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThan(String value) {
            addCriterion("REMARK1 >", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK1 >=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThan(String value) {
            addCriterion("REMARK1 <", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1LessThanOrEqualTo(String value) {
            addCriterion("REMARK1 <=", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Like(String value) {
            addCriterion("REMARK1 like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotLike(String value) {
            addCriterion("REMARK1 not like", value, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1In(List<String> values) {
            addCriterion("REMARK1 in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotIn(List<String> values) {
            addCriterion("REMARK1 not in", values, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1Between(String value1, String value2) {
            addCriterion("REMARK1 between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark1NotBetween(String value1, String value2) {
            addCriterion("REMARK1 not between", value1, value2, "remark1");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNull() {
            addCriterion("REMARK2 is null");
            return (Criteria) this;
        }

        public Criteria andRemark2IsNotNull() {
            addCriterion("REMARK2 is not null");
            return (Criteria) this;
        }

        public Criteria andRemark2EqualTo(String value) {
            addCriterion("REMARK2 =", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotEqualTo(String value) {
            addCriterion("REMARK2 <>", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThan(String value) {
            addCriterion("REMARK2 >", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2GreaterThanOrEqualTo(String value) {
            addCriterion("REMARK2 >=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThan(String value) {
            addCriterion("REMARK2 <", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2LessThanOrEqualTo(String value) {
            addCriterion("REMARK2 <=", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Like(String value) {
            addCriterion("REMARK2 like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotLike(String value) {
            addCriterion("REMARK2 not like", value, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2In(List<String> values) {
            addCriterion("REMARK2 in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotIn(List<String> values) {
            addCriterion("REMARK2 not in", values, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2Between(String value1, String value2) {
            addCriterion("REMARK2 between", value1, value2, "remark2");
            return (Criteria) this;
        }

        public Criteria andRemark2NotBetween(String value1, String value2) {
            addCriterion("REMARK2 not between", value1, value2, "remark2");
            return (Criteria) this;
        }
    }

    /**
     * NT_DEVICE_TEST_REPORT
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}