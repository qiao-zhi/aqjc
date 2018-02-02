package com.tyust.bean.pbs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tyust.common.IbatorGenExamplePageHelper;

public class PbsTestApplyExample extends IbatorGenExamplePageHelper{
    /**
     * NT_PBS_TEST_APPLY
     */
    protected String orderByClause;

    /**
     * NT_PBS_TEST_APPLY
     */
    protected boolean distinct;

    /**
     * NT_PBS_TEST_APPLY
     */
    protected List<Criteria> oredCriteria;

    /**
     * NT_PBS_TEST_APPLY PbsTestApplyExample
     */
    public PbsTestApplyExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * NT_PBS_TEST_APPLY PbsTestApplyExample
     */
    protected PbsTestApplyExample(PbsTestApplyExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * NT_PBS_TEST_APPLY setOrderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * NT_PBS_TEST_APPLY getOrderByClause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * NT_PBS_TEST_APPLY setDistinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * NT_PBS_TEST_APPLY isDistinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * NT_PBS_TEST_APPLY getOredCriteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * NT_PBS_TEST_APPLY or
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * NT_PBS_TEST_APPLY or
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * NT_PBS_TEST_APPLY createCriteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * NT_PBS_TEST_APPLY createCriteriaInternal
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * NT_PBS_TEST_APPLY clear
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * NT_PBS_TEST_APPLY
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

        public Criteria andTestApplyIdIsNull() {
            addCriterion("TEST_APPLY_ID is null");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdIsNotNull() {
            addCriterion("TEST_APPLY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdEqualTo(String value) {
            addCriterion("TEST_APPLY_ID =", value, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdNotEqualTo(String value) {
            addCriterion("TEST_APPLY_ID <>", value, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdGreaterThan(String value) {
            addCriterion("TEST_APPLY_ID >", value, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("TEST_APPLY_ID >=", value, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdLessThan(String value) {
            addCriterion("TEST_APPLY_ID <", value, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdLessThanOrEqualTo(String value) {
            addCriterion("TEST_APPLY_ID <=", value, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdLike(String value) {
            addCriterion("TEST_APPLY_ID like", value, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdNotLike(String value) {
            addCriterion("TEST_APPLY_ID not like", value, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdIn(List<String> values) {
            addCriterion("TEST_APPLY_ID in", values, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdNotIn(List<String> values) {
            addCriterion("TEST_APPLY_ID not in", values, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdBetween(String value1, String value2) {
            addCriterion("TEST_APPLY_ID between", value1, value2, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andTestApplyIdNotBetween(String value1, String value2) {
            addCriterion("TEST_APPLY_ID not between", value1, value2, "testApplyId");
            return (Criteria) this;
        }

        public Criteria andApplyUnitIsNull() {
            addCriterion("APPLY_UNIT is null");
            return (Criteria) this;
        }

        public Criteria andApplyUnitIsNotNull() {
            addCriterion("APPLY_UNIT is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUnitEqualTo(String value) {
            addCriterion("APPLY_UNIT =", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitNotEqualTo(String value) {
            addCriterion("APPLY_UNIT <>", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitGreaterThan(String value) {
            addCriterion("APPLY_UNIT >", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_UNIT >=", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitLessThan(String value) {
            addCriterion("APPLY_UNIT <", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitLessThanOrEqualTo(String value) {
            addCriterion("APPLY_UNIT <=", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitLike(String value) {
            addCriterion("APPLY_UNIT like", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitNotLike(String value) {
            addCriterion("APPLY_UNIT not like", value, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitIn(List<String> values) {
            addCriterion("APPLY_UNIT in", values, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitNotIn(List<String> values) {
            addCriterion("APPLY_UNIT not in", values, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitBetween(String value1, String value2) {
            addCriterion("APPLY_UNIT between", value1, value2, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andApplyUnitNotBetween(String value1, String value2) {
            addCriterion("APPLY_UNIT not between", value1, value2, "applyUnit");
            return (Criteria) this;
        }

        public Criteria andPbsIdIsNull() {
            addCriterion("PBS_ID is null");
            return (Criteria) this;
        }

        public Criteria andPbsIdIsNotNull() {
            addCriterion("PBS_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPbsIdEqualTo(String value) {
            addCriterion("PBS_ID =", value, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdNotEqualTo(String value) {
            addCriterion("PBS_ID <>", value, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdGreaterThan(String value) {
            addCriterion("PBS_ID >", value, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdGreaterThanOrEqualTo(String value) {
            addCriterion("PBS_ID >=", value, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdLessThan(String value) {
            addCriterion("PBS_ID <", value, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdLessThanOrEqualTo(String value) {
            addCriterion("PBS_ID <=", value, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdLike(String value) {
            addCriterion("PBS_ID like", value, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdNotLike(String value) {
            addCriterion("PBS_ID not like", value, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdIn(List<String> values) {
            addCriterion("PBS_ID in", values, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdNotIn(List<String> values) {
            addCriterion("PBS_ID not in", values, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdBetween(String value1, String value2) {
            addCriterion("PBS_ID between", value1, value2, "pbsId");
            return (Criteria) this;
        }

        public Criteria andPbsIdNotBetween(String value1, String value2) {
            addCriterion("PBS_ID not between", value1, value2, "pbsId");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNull() {
            addCriterion("APPLY_DATE is null");
            return (Criteria) this;
        }

        public Criteria andApplyDateIsNotNull() {
            addCriterion("APPLY_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyDateEqualTo(Date value) {
            addCriterion("APPLY_DATE =", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotEqualTo(Date value) {
            addCriterion("APPLY_DATE <>", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThan(Date value) {
            addCriterion("APPLY_DATE >", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateGreaterThanOrEqualTo(Date value) {
            addCriterion("APPLY_DATE >=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThan(Date value) {
            addCriterion("APPLY_DATE <", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateLessThanOrEqualTo(Date value) {
            addCriterion("APPLY_DATE <=", value, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateIn(List<Date> values) {
            addCriterion("APPLY_DATE in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotIn(List<Date> values) {
            addCriterion("APPLY_DATE not in", values, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateBetween(Date value1, Date value2) {
            addCriterion("APPLY_DATE between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andApplyDateNotBetween(Date value1, Date value2) {
            addCriterion("APPLY_DATE not between", value1, value2, "applyDate");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdIsNull() {
            addCriterion("PBS_BUILDER_ID is null");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdIsNotNull() {
            addCriterion("PBS_BUILDER_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdEqualTo(String value) {
            addCriterion("PBS_BUILDER_ID =", value, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdNotEqualTo(String value) {
            addCriterion("PBS_BUILDER_ID <>", value, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdGreaterThan(String value) {
            addCriterion("PBS_BUILDER_ID >", value, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdGreaterThanOrEqualTo(String value) {
            addCriterion("PBS_BUILDER_ID >=", value, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdLessThan(String value) {
            addCriterion("PBS_BUILDER_ID <", value, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdLessThanOrEqualTo(String value) {
            addCriterion("PBS_BUILDER_ID <=", value, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdLike(String value) {
            addCriterion("PBS_BUILDER_ID like", value, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdNotLike(String value) {
            addCriterion("PBS_BUILDER_ID not like", value, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdIn(List<String> values) {
            addCriterion("PBS_BUILDER_ID in", values, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdNotIn(List<String> values) {
            addCriterion("PBS_BUILDER_ID not in", values, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdBetween(String value1, String value2) {
            addCriterion("PBS_BUILDER_ID between", value1, value2, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andPbsBuilderIdNotBetween(String value1, String value2) {
            addCriterion("PBS_BUILDER_ID not between", value1, value2, "pbsBuilderId");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeIsNull() {
            addCriterion("APPLY_TEST_GRADE is null");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeIsNotNull() {
            addCriterion("APPLY_TEST_GRADE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeEqualTo(String value) {
            addCriterion("APPLY_TEST_GRADE =", value, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeNotEqualTo(String value) {
            addCriterion("APPLY_TEST_GRADE <>", value, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeGreaterThan(String value) {
            addCriterion("APPLY_TEST_GRADE >", value, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_TEST_GRADE >=", value, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeLessThan(String value) {
            addCriterion("APPLY_TEST_GRADE <", value, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeLessThanOrEqualTo(String value) {
            addCriterion("APPLY_TEST_GRADE <=", value, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeLike(String value) {
            addCriterion("APPLY_TEST_GRADE like", value, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeNotLike(String value) {
            addCriterion("APPLY_TEST_GRADE not like", value, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeIn(List<String> values) {
            addCriterion("APPLY_TEST_GRADE in", values, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeNotIn(List<String> values) {
            addCriterion("APPLY_TEST_GRADE not in", values, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeBetween(String value1, String value2) {
            addCriterion("APPLY_TEST_GRADE between", value1, value2, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestGradeNotBetween(String value1, String value2) {
            addCriterion("APPLY_TEST_GRADE not between", value1, value2, "applyTestGrade");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeIsNull() {
            addCriterion("APPLY_TEST_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeIsNotNull() {
            addCriterion("APPLY_TEST_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeEqualTo(String value) {
            addCriterion("APPLY_TEST_TYPE =", value, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeNotEqualTo(String value) {
            addCriterion("APPLY_TEST_TYPE <>", value, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeGreaterThan(String value) {
            addCriterion("APPLY_TEST_TYPE >", value, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_TEST_TYPE >=", value, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeLessThan(String value) {
            addCriterion("APPLY_TEST_TYPE <", value, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeLessThanOrEqualTo(String value) {
            addCriterion("APPLY_TEST_TYPE <=", value, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeLike(String value) {
            addCriterion("APPLY_TEST_TYPE like", value, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeNotLike(String value) {
            addCriterion("APPLY_TEST_TYPE not like", value, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeIn(List<String> values) {
            addCriterion("APPLY_TEST_TYPE in", values, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeNotIn(List<String> values) {
            addCriterion("APPLY_TEST_TYPE not in", values, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeBetween(String value1, String value2) {
            addCriterion("APPLY_TEST_TYPE between", value1, value2, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyTestTypeNotBetween(String value1, String value2) {
            addCriterion("APPLY_TEST_TYPE not between", value1, value2, "applyTestType");
            return (Criteria) this;
        }

        public Criteria andApplyStateIsNull() {
            addCriterion("APPLY_STATE is null");
            return (Criteria) this;
        }

        public Criteria andApplyStateIsNotNull() {
            addCriterion("APPLY_STATE is not null");
            return (Criteria) this;
        }

        public Criteria andApplyStateEqualTo(String value) {
            addCriterion("APPLY_STATE =", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotEqualTo(String value) {
            addCriterion("APPLY_STATE <>", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThan(String value) {
            addCriterion("APPLY_STATE >", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_STATE >=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThan(String value) {
            addCriterion("APPLY_STATE <", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLessThanOrEqualTo(String value) {
            addCriterion("APPLY_STATE <=", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateLike(String value) {
            addCriterion("APPLY_STATE like", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotLike(String value) {
            addCriterion("APPLY_STATE not like", value, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateIn(List<String> values) {
            addCriterion("APPLY_STATE in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotIn(List<String> values) {
            addCriterion("APPLY_STATE not in", values, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateBetween(String value1, String value2) {
            addCriterion("APPLY_STATE between", value1, value2, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyStateNotBetween(String value1, String value2) {
            addCriterion("APPLY_STATE not between", value1, value2, "applyState");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNull() {
            addCriterion("APPLY_USER is null");
            return (Criteria) this;
        }

        public Criteria andApplyUserIsNotNull() {
            addCriterion("APPLY_USER is not null");
            return (Criteria) this;
        }

        public Criteria andApplyUserEqualTo(String value) {
            addCriterion("APPLY_USER =", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotEqualTo(String value) {
            addCriterion("APPLY_USER <>", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThan(String value) {
            addCriterion("APPLY_USER >", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserGreaterThanOrEqualTo(String value) {
            addCriterion("APPLY_USER >=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThan(String value) {
            addCriterion("APPLY_USER <", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLessThanOrEqualTo(String value) {
            addCriterion("APPLY_USER <=", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserLike(String value) {
            addCriterion("APPLY_USER like", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotLike(String value) {
            addCriterion("APPLY_USER not like", value, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserIn(List<String> values) {
            addCriterion("APPLY_USER in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotIn(List<String> values) {
            addCriterion("APPLY_USER not in", values, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserBetween(String value1, String value2) {
            addCriterion("APPLY_USER between", value1, value2, "applyUser");
            return (Criteria) this;
        }

        public Criteria andApplyUserNotBetween(String value1, String value2) {
            addCriterion("APPLY_USER not between", value1, value2, "applyUser");
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
     * NT_PBS_TEST_APPLY
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}