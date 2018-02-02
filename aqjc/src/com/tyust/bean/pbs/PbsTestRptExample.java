package com.tyust.bean.pbs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PbsTestRptExample {
    /**
     * NT_PBS_TEST_RPT
     */
    protected String orderByClause;

    /**
     * NT_PBS_TEST_RPT
     */
    protected boolean distinct;

    /**
     * NT_PBS_TEST_RPT
     */
    protected List<Criteria> oredCriteria;

    /**
     * NT_PBS_TEST_RPT PbsTestRptExample
     */
    public PbsTestRptExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * NT_PBS_TEST_RPT PbsTestRptExample
     */
    protected PbsTestRptExample(PbsTestRptExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * NT_PBS_TEST_RPT setOrderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * NT_PBS_TEST_RPT getOrderByClause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * NT_PBS_TEST_RPT setDistinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * NT_PBS_TEST_RPT isDistinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * NT_PBS_TEST_RPT getOredCriteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * NT_PBS_TEST_RPT or
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * NT_PBS_TEST_RPT or
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * NT_PBS_TEST_RPT createCriteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * NT_PBS_TEST_RPT createCriteriaInternal
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * NT_PBS_TEST_RPT clear
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * NT_PBS_TEST_RPT
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

        public Criteria andTestRptIdIsNull() {
            addCriterion("TEST_RPT_ID is null");
            return (Criteria) this;
        }

        public Criteria andTestRptIdIsNotNull() {
            addCriterion("TEST_RPT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTestRptIdEqualTo(String value) {
            addCriterion("TEST_RPT_ID =", value, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdNotEqualTo(String value) {
            addCriterion("TEST_RPT_ID <>", value, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdGreaterThan(String value) {
            addCriterion("TEST_RPT_ID >", value, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_RPT_ID >=", value, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdLessThan(String value) {
            addCriterion("TEST_RPT_ID <", value, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdLessThanOrEqualTo(String value) {
            addCriterion("TEST_RPT_ID <=", value, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdLike(String value) {
            addCriterion("TEST_RPT_ID like", value, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdNotLike(String value) {
            addCriterion("TEST_RPT_ID not like", value, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdIn(List<String> values) {
            addCriterion("TEST_RPT_ID in", values, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdNotIn(List<String> values) {
            addCriterion("TEST_RPT_ID not in", values, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdBetween(String value1, String value2) {
            addCriterion("TEST_RPT_ID between", value1, value2, "testRptId");
            return (Criteria) this;
        }

        public Criteria andTestRptIdNotBetween(String value1, String value2) {
            addCriterion("TEST_RPT_ID not between", value1, value2, "testRptId");
            return (Criteria) this;
        }

        public Criteria andRptCodeIsNull() {
            addCriterion("RPT_CODE is null");
            return (Criteria) this;
        }

        public Criteria andRptCodeIsNotNull() {
            addCriterion("RPT_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andRptCodeEqualTo(String value) {
            addCriterion("RPT_CODE =", value, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeNotEqualTo(String value) {
            addCriterion("RPT_CODE <>", value, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeGreaterThan(String value) {
            addCriterion("RPT_CODE >", value, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeGreaterThanOrEqualTo(String value) {
            addCriterion("RPT_CODE >=", value, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeLessThan(String value) {
            addCriterion("RPT_CODE <", value, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeLessThanOrEqualTo(String value) {
            addCriterion("RPT_CODE <=", value, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeLike(String value) {
            addCriterion("RPT_CODE like", value, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeNotLike(String value) {
            addCriterion("RPT_CODE not like", value, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeIn(List<String> values) {
            addCriterion("RPT_CODE in", values, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeNotIn(List<String> values) {
            addCriterion("RPT_CODE not in", values, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeBetween(String value1, String value2) {
            addCriterion("RPT_CODE between", value1, value2, "rptCode");
            return (Criteria) this;
        }

        public Criteria andRptCodeNotBetween(String value1, String value2) {
            addCriterion("RPT_CODE not between", value1, value2, "rptCode");
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

        public Criteria andTestPersonIsNull() {
            addCriterion("TEST_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andTestPersonIsNotNull() {
            addCriterion("TEST_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andTestPersonEqualTo(String value) {
            addCriterion("TEST_PERSON =", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonNotEqualTo(String value) {
            addCriterion("TEST_PERSON <>", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonGreaterThan(String value) {
            addCriterion("TEST_PERSON >", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_PERSON >=", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonLessThan(String value) {
            addCriterion("TEST_PERSON <", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonLessThanOrEqualTo(String value) {
            addCriterion("TEST_PERSON <=", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonLike(String value) {
            addCriterion("TEST_PERSON like", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonNotLike(String value) {
            addCriterion("TEST_PERSON not like", value, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonIn(List<String> values) {
            addCriterion("TEST_PERSON in", values, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonNotIn(List<String> values) {
            addCriterion("TEST_PERSON not in", values, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonBetween(String value1, String value2) {
            addCriterion("TEST_PERSON between", value1, value2, "testPerson");
            return (Criteria) this;
        }

        public Criteria andTestPersonNotBetween(String value1, String value2) {
            addCriterion("TEST_PERSON not between", value1, value2, "testPerson");
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

        public Criteria andTestItemIsNull() {
            addCriterion("TEST_ITEM is null");
            return (Criteria) this;
        }

        public Criteria andTestItemIsNotNull() {
            addCriterion("TEST_ITEM is not null");
            return (Criteria) this;
        }

        public Criteria andTestItemEqualTo(String value) {
            addCriterion("TEST_ITEM =", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotEqualTo(String value) {
            addCriterion("TEST_ITEM <>", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemGreaterThan(String value) {
            addCriterion("TEST_ITEM >", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_ITEM >=", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLessThan(String value) {
            addCriterion("TEST_ITEM <", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLessThanOrEqualTo(String value) {
            addCriterion("TEST_ITEM <=", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemLike(String value) {
            addCriterion("TEST_ITEM like", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotLike(String value) {
            addCriterion("TEST_ITEM not like", value, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemIn(List<String> values) {
            addCriterion("TEST_ITEM in", values, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotIn(List<String> values) {
            addCriterion("TEST_ITEM not in", values, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemBetween(String value1, String value2) {
            addCriterion("TEST_ITEM between", value1, value2, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestItemNotBetween(String value1, String value2) {
            addCriterion("TEST_ITEM not between", value1, value2, "testItem");
            return (Criteria) this;
        }

        public Criteria andTestStandardsIsNull() {
            addCriterion("TEST_STANDARDS is null");
            return (Criteria) this;
        }

        public Criteria andTestStandardsIsNotNull() {
            addCriterion("TEST_STANDARDS is not null");
            return (Criteria) this;
        }

        public Criteria andTestStandardsEqualTo(String value) {
            addCriterion("TEST_STANDARDS =", value, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsNotEqualTo(String value) {
            addCriterion("TEST_STANDARDS <>", value, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsGreaterThan(String value) {
            addCriterion("TEST_STANDARDS >", value, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_STANDARDS >=", value, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsLessThan(String value) {
            addCriterion("TEST_STANDARDS <", value, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsLessThanOrEqualTo(String value) {
            addCriterion("TEST_STANDARDS <=", value, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsLike(String value) {
            addCriterion("TEST_STANDARDS like", value, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsNotLike(String value) {
            addCriterion("TEST_STANDARDS not like", value, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsIn(List<String> values) {
            addCriterion("TEST_STANDARDS in", values, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsNotIn(List<String> values) {
            addCriterion("TEST_STANDARDS not in", values, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsBetween(String value1, String value2) {
            addCriterion("TEST_STANDARDS between", value1, value2, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestStandardsNotBetween(String value1, String value2) {
            addCriterion("TEST_STANDARDS not between", value1, value2, "testStandards");
            return (Criteria) this;
        }

        public Criteria andTestPosIsNull() {
            addCriterion("TEST_POS is null");
            return (Criteria) this;
        }

        public Criteria andTestPosIsNotNull() {
            addCriterion("TEST_POS is not null");
            return (Criteria) this;
        }

        public Criteria andTestPosEqualTo(String value) {
            addCriterion("TEST_POS =", value, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosNotEqualTo(String value) {
            addCriterion("TEST_POS <>", value, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosGreaterThan(String value) {
            addCriterion("TEST_POS >", value, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_POS >=", value, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosLessThan(String value) {
            addCriterion("TEST_POS <", value, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosLessThanOrEqualTo(String value) {
            addCriterion("TEST_POS <=", value, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosLike(String value) {
            addCriterion("TEST_POS like", value, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosNotLike(String value) {
            addCriterion("TEST_POS not like", value, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosIn(List<String> values) {
            addCriterion("TEST_POS in", values, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosNotIn(List<String> values) {
            addCriterion("TEST_POS not in", values, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosBetween(String value1, String value2) {
            addCriterion("TEST_POS between", value1, value2, "testPos");
            return (Criteria) this;
        }

        public Criteria andTestPosNotBetween(String value1, String value2) {
            addCriterion("TEST_POS not between", value1, value2, "testPos");
            return (Criteria) this;
        }

        public Criteria andXnpjIsNull() {
            addCriterion("XNPJ is null");
            return (Criteria) this;
        }

        public Criteria andXnpjIsNotNull() {
            addCriterion("XNPJ is not null");
            return (Criteria) this;
        }

        public Criteria andXnpjEqualTo(String value) {
            addCriterion("XNPJ =", value, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjNotEqualTo(String value) {
            addCriterion("XNPJ <>", value, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjGreaterThan(String value) {
            addCriterion("XNPJ >", value, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjGreaterThanOrEqualTo(String value) {
            addCriterion("XNPJ >=", value, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjLessThan(String value) {
            addCriterion("XNPJ <", value, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjLessThanOrEqualTo(String value) {
            addCriterion("XNPJ <=", value, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjLike(String value) {
            addCriterion("XNPJ like", value, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjNotLike(String value) {
            addCriterion("XNPJ not like", value, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjIn(List<String> values) {
            addCriterion("XNPJ in", values, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjNotIn(List<String> values) {
            addCriterion("XNPJ not in", values, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjBetween(String value1, String value2) {
            addCriterion("XNPJ between", value1, value2, "xnpj");
            return (Criteria) this;
        }

        public Criteria andXnpjNotBetween(String value1, String value2) {
            addCriterion("XNPJ not between", value1, value2, "xnpj");
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

        public Criteria andRptStateIsNull() {
            addCriterion("RPT_STATE is null");
            return (Criteria) this;
        }

        public Criteria andRptStateIsNotNull() {
            addCriterion("RPT_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andRptStateEqualTo(String value) {
            addCriterion("RPT_STATE =", value, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateNotEqualTo(String value) {
            addCriterion("RPT_STATE <>", value, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateGreaterThan(String value) {
            addCriterion("RPT_STATE >", value, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateGreaterThanOrEqualTo(String value) {
            addCriterion("RPT_STATE >=", value, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateLessThan(String value) {
            addCriterion("RPT_STATE <", value, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateLessThanOrEqualTo(String value) {
            addCriterion("RPT_STATE <=", value, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateLike(String value) {
            addCriterion("RPT_STATE like", value, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateNotLike(String value) {
            addCriterion("RPT_STATE not like", value, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateIn(List<String> values) {
            addCriterion("RPT_STATE in", values, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateNotIn(List<String> values) {
            addCriterion("RPT_STATE not in", values, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateBetween(String value1, String value2) {
            addCriterion("RPT_STATE between", value1, value2, "rptState");
            return (Criteria) this;
        }

        public Criteria andRptStateNotBetween(String value1, String value2) {
            addCriterion("RPT_STATE not between", value1, value2, "rptState");
            return (Criteria) this;
        }

        public Criteria andPbsStateIsNull() {
            addCriterion("PBS_STATE is null");
            return (Criteria) this;
        }

        public Criteria andPbsStateIsNotNull() {
            addCriterion("PBS_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andPbsStateEqualTo(String value) {
            addCriterion("PBS_STATE =", value, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateNotEqualTo(String value) {
            addCriterion("PBS_STATE <>", value, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateGreaterThan(String value) {
            addCriterion("PBS_STATE >", value, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateGreaterThanOrEqualTo(String value) {
            addCriterion("PBS_STATE >=", value, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateLessThan(String value) {
            addCriterion("PBS_STATE <", value, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateLessThanOrEqualTo(String value) {
            addCriterion("PBS_STATE <=", value, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateLike(String value) {
            addCriterion("PBS_STATE like", value, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateNotLike(String value) {
            addCriterion("PBS_STATE not like", value, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateIn(List<String> values) {
            addCriterion("PBS_STATE in", values, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateNotIn(List<String> values) {
            addCriterion("PBS_STATE not in", values, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateBetween(String value1, String value2) {
            addCriterion("PBS_STATE between", value1, value2, "pbsState");
            return (Criteria) this;
        }

        public Criteria andPbsStateNotBetween(String value1, String value2) {
            addCriterion("PBS_STATE not between", value1, value2, "pbsState");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitIsNull() {
            addCriterion("DELEGATE_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitIsNotNull() {
            addCriterion("DELEGATE_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitEqualTo(String value) {
            addCriterion("DELEGATE_UNIT =", value, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitNotEqualTo(String value) {
            addCriterion("DELEGATE_UNIT <>", value, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitGreaterThan(String value) {
            addCriterion("DELEGATE_UNIT >", value, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitGreaterThanOrEqualTo(String value) {
            addCriterion("DELEGATE_UNIT >=", value, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitLessThan(String value) {
            addCriterion("DELEGATE_UNIT <", value, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitLessThanOrEqualTo(String value) {
            addCriterion("DELEGATE_UNIT <=", value, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitLike(String value) {
            addCriterion("DELEGATE_UNIT like", value, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitNotLike(String value) {
            addCriterion("DELEGATE_UNIT not like", value, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitIn(List<String> values) {
            addCriterion("DELEGATE_UNIT in", values, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitNotIn(List<String> values) {
            addCriterion("DELEGATE_UNIT not in", values, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitBetween(String value1, String value2) {
            addCriterion("DELEGATE_UNIT between", value1, value2, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andDelegateUnitNotBetween(String value1, String value2) {
            addCriterion("DELEGATE_UNIT not between", value1, value2, "delegateUnit");
            return (Criteria) this;
        }

        public Criteria andShPersonIsNull() {
            addCriterion("SH_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andShPersonIsNotNull() {
            addCriterion("SH_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andShPersonEqualTo(String value) {
            addCriterion("SH_PERSON =", value, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonNotEqualTo(String value) {
            addCriterion("SH_PERSON <>", value, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonGreaterThan(String value) {
            addCriterion("SH_PERSON >", value, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonGreaterThanOrEqualTo(String value) {
            addCriterion("SH_PERSON >=", value, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonLessThan(String value) {
            addCriterion("SH_PERSON <", value, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonLessThanOrEqualTo(String value) {
            addCriterion("SH_PERSON <=", value, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonLike(String value) {
            addCriterion("SH_PERSON like", value, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonNotLike(String value) {
            addCriterion("SH_PERSON not like", value, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonIn(List<String> values) {
            addCriterion("SH_PERSON in", values, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonNotIn(List<String> values) {
            addCriterion("SH_PERSON not in", values, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonBetween(String value1, String value2) {
            addCriterion("SH_PERSON between", value1, value2, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShPersonNotBetween(String value1, String value2) {
            addCriterion("SH_PERSON not between", value1, value2, "shPerson");
            return (Criteria) this;
        }

        public Criteria andShDateIsNull() {
            addCriterion("SH_DATE is null");
            return (Criteria) this;
        }

        public Criteria andShDateIsNotNull() {
            addCriterion("SH_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andShDateEqualTo(Date value) {
            addCriterion("SH_DATE =", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateNotEqualTo(Date value) {
            addCriterion("SH_DATE <>", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateGreaterThan(Date value) {
            addCriterion("SH_DATE >", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateGreaterThanOrEqualTo(Date value) {
            addCriterion("SH_DATE >=", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateLessThan(Date value) {
            addCriterion("SH_DATE <", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateLessThanOrEqualTo(Date value) {
            addCriterion("SH_DATE <=", value, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateIn(List<Date> values) {
            addCriterion("SH_DATE in", values, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateNotIn(List<Date> values) {
            addCriterion("SH_DATE not in", values, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateBetween(Date value1, Date value2) {
            addCriterion("SH_DATE between", value1, value2, "shDate");
            return (Criteria) this;
        }

        public Criteria andShDateNotBetween(Date value1, Date value2) {
            addCriterion("SH_DATE not between", value1, value2, "shDate");
            return (Criteria) this;
        }

        public Criteria andPzPersonIsNull() {
            addCriterion("PZ_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andPzPersonIsNotNull() {
            addCriterion("PZ_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andPzPersonEqualTo(String value) {
            addCriterion("PZ_PERSON =", value, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonNotEqualTo(String value) {
            addCriterion("PZ_PERSON <>", value, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonGreaterThan(String value) {
            addCriterion("PZ_PERSON >", value, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonGreaterThanOrEqualTo(String value) {
            addCriterion("PZ_PERSON >=", value, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonLessThan(String value) {
            addCriterion("PZ_PERSON <", value, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonLessThanOrEqualTo(String value) {
            addCriterion("PZ_PERSON <=", value, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonLike(String value) {
            addCriterion("PZ_PERSON like", value, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonNotLike(String value) {
            addCriterion("PZ_PERSON not like", value, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonIn(List<String> values) {
            addCriterion("PZ_PERSON in", values, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonNotIn(List<String> values) {
            addCriterion("PZ_PERSON not in", values, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonBetween(String value1, String value2) {
            addCriterion("PZ_PERSON between", value1, value2, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzPersonNotBetween(String value1, String value2) {
            addCriterion("PZ_PERSON not between", value1, value2, "pzPerson");
            return (Criteria) this;
        }

        public Criteria andPzDateIsNull() {
            addCriterion("PZ_DATE is null");
            return (Criteria) this;
        }

        public Criteria andPzDateIsNotNull() {
            addCriterion("PZ_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andPzDateEqualTo(Date value) {
            addCriterion("PZ_DATE =", value, "pzDate");
            return (Criteria) this;
        }

        public Criteria andPzDateNotEqualTo(Date value) {
            addCriterion("PZ_DATE <>", value, "pzDate");
            return (Criteria) this;
        }

        public Criteria andPzDateGreaterThan(Date value) {
            addCriterion("PZ_DATE >", value, "pzDate");
            return (Criteria) this;
        }

        public Criteria andPzDateGreaterThanOrEqualTo(Date value) {
            addCriterion("PZ_DATE >=", value, "pzDate");
            return (Criteria) this;
        }

        public Criteria andPzDateLessThan(Date value) {
            addCriterion("PZ_DATE <", value, "pzDate");
            return (Criteria) this;
        }

        public Criteria andPzDateLessThanOrEqualTo(Date value) {
            addCriterion("PZ_DATE <=", value, "pzDate");
            return (Criteria) this;
        }

        public Criteria andPzDateIn(List<Date> values) {
            addCriterion("PZ_DATE in", values, "pzDate");
            return (Criteria) this;
        }

        public Criteria andPzDateNotIn(List<Date> values) {
            addCriterion("PZ_DATE not in", values, "pzDate");
            return (Criteria) this;
        }

        public Criteria andPzDateBetween(Date value1, Date value2) {
            addCriterion("PZ_DATE between", value1, value2, "pzDate");
            return (Criteria) this;
        }

        public Criteria andPzDateNotBetween(Date value1, Date value2) {
            addCriterion("PZ_DATE not between", value1, value2, "pzDate");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNull() {
            addCriterion("REMARK is null");
            return (Criteria) this;
        }

        public Criteria andRemarkIsNotNull() {
            addCriterion("REMARK is not null");
            return (Criteria) this;
        }

        public Criteria andRemarkEqualTo(String value) {
            addCriterion("REMARK =", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotEqualTo(String value) {
            addCriterion("REMARK <>", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThan(String value) {
            addCriterion("REMARK >", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkGreaterThanOrEqualTo(String value) {
            addCriterion("REMARK >=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThan(String value) {
            addCriterion("REMARK <", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLessThanOrEqualTo(String value) {
            addCriterion("REMARK <=", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkLike(String value) {
            addCriterion("REMARK like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotLike(String value) {
            addCriterion("REMARK not like", value, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkIn(List<String> values) {
            addCriterion("REMARK in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotIn(List<String> values) {
            addCriterion("REMARK not in", values, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkBetween(String value1, String value2) {
            addCriterion("REMARK between", value1, value2, "remark");
            return (Criteria) this;
        }

        public Criteria andRemarkNotBetween(String value1, String value2) {
            addCriterion("REMARK not between", value1, value2, "remark");
            return (Criteria) this;
        }
    }

    /**
     * NT_PBS_TEST_RPT
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}