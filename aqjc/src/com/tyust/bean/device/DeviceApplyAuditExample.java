package com.tyust.bean.device;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeviceApplyAuditExample {
    /**
     * NT_DEVICE_APPLY_AUDIT
     */
    protected String orderByClause;

    /**
     * NT_DEVICE_APPLY_AUDIT
     */
    protected boolean distinct;

    /**
     * NT_DEVICE_APPLY_AUDIT
     */
    protected List<Criteria> oredCriteria;

    /**
     * NT_DEVICE_APPLY_AUDIT DeviceApplyAuditExample
     */
    public DeviceApplyAuditExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * NT_DEVICE_APPLY_AUDIT DeviceApplyAuditExample
     */
    protected DeviceApplyAuditExample(DeviceApplyAuditExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT setOrderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT getOrderByClause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT setDistinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT isDistinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT getOredCriteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT or
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * NT_DEVICE_APPLY_AUDIT or
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT createCriteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT createCriteriaInternal
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT clear
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * NT_DEVICE_APPLY_AUDIT
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

        public Criteria andAuditIdIsNull() {
            addCriterion("AUDIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andAuditIdIsNotNull() {
            addCriterion("AUDIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andAuditIdEqualTo(String value) {
            addCriterion("AUDIT_ID =", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotEqualTo(String value) {
            addCriterion("AUDIT_ID <>", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThan(String value) {
            addCriterion("AUDIT_ID >", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_ID >=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThan(String value) {
            addCriterion("AUDIT_ID <", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_ID <=", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdLike(String value) {
            addCriterion("AUDIT_ID like", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotLike(String value) {
            addCriterion("AUDIT_ID not like", value, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdIn(List<String> values) {
            addCriterion("AUDIT_ID in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotIn(List<String> values) {
            addCriterion("AUDIT_ID not in", values, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdBetween(String value1, String value2) {
            addCriterion("AUDIT_ID between", value1, value2, "auditId");
            return (Criteria) this;
        }

        public Criteria andAuditIdNotBetween(String value1, String value2) {
            addCriterion("AUDIT_ID not between", value1, value2, "auditId");
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

        public Criteria andAuditDateIsNull() {
            addCriterion("AUDIT_DATE is null");
            return (Criteria) this;
        }

        public Criteria andAuditDateIsNotNull() {
            addCriterion("AUDIT_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andAuditDateEqualTo(Date value) {
            addCriterion("AUDIT_DATE =", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotEqualTo(Date value) {
            addCriterion("AUDIT_DATE <>", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThan(Date value) {
            addCriterion("AUDIT_DATE >", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateGreaterThanOrEqualTo(Date value) {
            addCriterion("AUDIT_DATE >=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThan(Date value) {
            addCriterion("AUDIT_DATE <", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateLessThanOrEqualTo(Date value) {
            addCriterion("AUDIT_DATE <=", value, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateIn(List<Date> values) {
            addCriterion("AUDIT_DATE in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotIn(List<Date> values) {
            addCriterion("AUDIT_DATE not in", values, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateBetween(Date value1, Date value2) {
            addCriterion("AUDIT_DATE between", value1, value2, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditDateNotBetween(Date value1, Date value2) {
            addCriterion("AUDIT_DATE not between", value1, value2, "auditDate");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionIsNull() {
            addCriterion("AUDIT_OPPINION is null");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionIsNotNull() {
            addCriterion("AUDIT_OPPINION is not null");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionEqualTo(String value) {
            addCriterion("AUDIT_OPPINION =", value, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionNotEqualTo(String value) {
            addCriterion("AUDIT_OPPINION <>", value, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionGreaterThan(String value) {
            addCriterion("AUDIT_OPPINION >", value, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_OPPINION >=", value, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionLessThan(String value) {
            addCriterion("AUDIT_OPPINION <", value, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_OPPINION <=", value, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionLike(String value) {
            addCriterion("AUDIT_OPPINION like", value, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionNotLike(String value) {
            addCriterion("AUDIT_OPPINION not like", value, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionIn(List<String> values) {
            addCriterion("AUDIT_OPPINION in", values, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionNotIn(List<String> values) {
            addCriterion("AUDIT_OPPINION not in", values, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionBetween(String value1, String value2) {
            addCriterion("AUDIT_OPPINION between", value1, value2, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditOppinionNotBetween(String value1, String value2) {
            addCriterion("AUDIT_OPPINION not between", value1, value2, "auditOppinion");
            return (Criteria) this;
        }

        public Criteria andAuditResultIsNull() {
            addCriterion("AUDIT_RESULT is null");
            return (Criteria) this;
        }

        public Criteria andAuditResultIsNotNull() {
            addCriterion("AUDIT_RESULT is not null");
            return (Criteria) this;
        }

        public Criteria andAuditResultEqualTo(String value) {
            addCriterion("AUDIT_RESULT =", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultNotEqualTo(String value) {
            addCriterion("AUDIT_RESULT <>", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultGreaterThan(String value) {
            addCriterion("AUDIT_RESULT >", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_RESULT >=", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultLessThan(String value) {
            addCriterion("AUDIT_RESULT <", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_RESULT <=", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultLike(String value) {
            addCriterion("AUDIT_RESULT like", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultNotLike(String value) {
            addCriterion("AUDIT_RESULT not like", value, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultIn(List<String> values) {
            addCriterion("AUDIT_RESULT in", values, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultNotIn(List<String> values) {
            addCriterion("AUDIT_RESULT not in", values, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultBetween(String value1, String value2) {
            addCriterion("AUDIT_RESULT between", value1, value2, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditResultNotBetween(String value1, String value2) {
            addCriterion("AUDIT_RESULT not between", value1, value2, "auditResult");
            return (Criteria) this;
        }

        public Criteria andAuditUserIsNull() {
            addCriterion("AUDIT_USER is null");
            return (Criteria) this;
        }

        public Criteria andAuditUserIsNotNull() {
            addCriterion("AUDIT_USER is not null");
            return (Criteria) this;
        }

        public Criteria andAuditUserEqualTo(String value) {
            addCriterion("AUDIT_USER =", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotEqualTo(String value) {
            addCriterion("AUDIT_USER <>", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserGreaterThan(String value) {
            addCriterion("AUDIT_USER >", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_USER >=", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLessThan(String value) {
            addCriterion("AUDIT_USER <", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_USER <=", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserLike(String value) {
            addCriterion("AUDIT_USER like", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotLike(String value) {
            addCriterion("AUDIT_USER not like", value, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserIn(List<String> values) {
            addCriterion("AUDIT_USER in", values, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotIn(List<String> values) {
            addCriterion("AUDIT_USER not in", values, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserBetween(String value1, String value2) {
            addCriterion("AUDIT_USER between", value1, value2, "auditUser");
            return (Criteria) this;
        }

        public Criteria andAuditUserNotBetween(String value1, String value2) {
            addCriterion("AUDIT_USER not between", value1, value2, "auditUser");
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
     * NT_DEVICE_APPLY_AUDIT
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}