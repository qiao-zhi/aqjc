package com.tyust.bean.pbs;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PbsApplyAuditExample {
    /**
     * NT_PBS_APPLY_AUDIT
     */
    protected String orderByClause;

    /**
     * NT_PBS_APPLY_AUDIT
     */
    protected boolean distinct;

    /**
     * NT_PBS_APPLY_AUDIT
     */
    protected List<Criteria> oredCriteria;

    /**
     * NT_PBS_APPLY_AUDIT PbsApplyAuditExample
     */
    public PbsApplyAuditExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * NT_PBS_APPLY_AUDIT PbsApplyAuditExample
     */
    protected PbsApplyAuditExample(PbsApplyAuditExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * NT_PBS_APPLY_AUDIT setOrderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * NT_PBS_APPLY_AUDIT getOrderByClause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * NT_PBS_APPLY_AUDIT setDistinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * NT_PBS_APPLY_AUDIT isDistinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * NT_PBS_APPLY_AUDIT getOredCriteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * NT_PBS_APPLY_AUDIT or
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * NT_PBS_APPLY_AUDIT or
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * NT_PBS_APPLY_AUDIT createCriteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * NT_PBS_APPLY_AUDIT createCriteriaInternal
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * NT_PBS_APPLY_AUDIT clear
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * NT_PBS_APPLY_AUDIT
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

        public Criteria andPbsApplyIdIsNull() {
            addCriterion("PBS_APPLY_ID is null");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdIsNotNull() {
            addCriterion("PBS_APPLY_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdEqualTo(String value) {
            addCriterion("PBS_APPLY_ID =", value, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdNotEqualTo(String value) {
            addCriterion("PBS_APPLY_ID <>", value, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdGreaterThan(String value) {
            addCriterion("PBS_APPLY_ID >", value, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdGreaterThanOrEqualTo(String value) {
            addCriterion("PBS_APPLY_ID >=", value, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdLessThan(String value) {
            addCriterion("PBS_APPLY_ID <", value, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdLessThanOrEqualTo(String value) {
            addCriterion("PBS_APPLY_ID <=", value, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdLike(String value) {
            addCriterion("PBS_APPLY_ID like", value, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdNotLike(String value) {
            addCriterion("PBS_APPLY_ID not like", value, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdIn(List<String> values) {
            addCriterion("PBS_APPLY_ID in", values, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdNotIn(List<String> values) {
            addCriterion("PBS_APPLY_ID not in", values, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdBetween(String value1, String value2) {
            addCriterion("PBS_APPLY_ID between", value1, value2, "pbsApplyId");
            return (Criteria) this;
        }

        public Criteria andPbsApplyIdNotBetween(String value1, String value2) {
            addCriterion("PBS_APPLY_ID not between", value1, value2, "pbsApplyId");
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

        public Criteria andAuditOppinonIsNull() {
            addCriterion("AUDIT_OPPINON is null");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonIsNotNull() {
            addCriterion("AUDIT_OPPINON is not null");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonEqualTo(String value) {
            addCriterion("AUDIT_OPPINON =", value, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonNotEqualTo(String value) {
            addCriterion("AUDIT_OPPINON <>", value, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonGreaterThan(String value) {
            addCriterion("AUDIT_OPPINON >", value, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonGreaterThanOrEqualTo(String value) {
            addCriterion("AUDIT_OPPINON >=", value, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonLessThan(String value) {
            addCriterion("AUDIT_OPPINON <", value, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonLessThanOrEqualTo(String value) {
            addCriterion("AUDIT_OPPINON <=", value, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonLike(String value) {
            addCriterion("AUDIT_OPPINON like", value, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonNotLike(String value) {
            addCriterion("AUDIT_OPPINON not like", value, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonIn(List<String> values) {
            addCriterion("AUDIT_OPPINON in", values, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonNotIn(List<String> values) {
            addCriterion("AUDIT_OPPINON not in", values, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonBetween(String value1, String value2) {
            addCriterion("AUDIT_OPPINON between", value1, value2, "auditOppinon");
            return (Criteria) this;
        }

        public Criteria andAuditOppinonNotBetween(String value1, String value2) {
            addCriterion("AUDIT_OPPINON not between", value1, value2, "auditOppinon");
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
     * NT_PBS_APPLY_AUDIT
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}