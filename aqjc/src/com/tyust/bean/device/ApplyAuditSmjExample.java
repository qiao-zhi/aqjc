package com.tyust.bean.device;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ApplyAuditSmjExample {
    /**
     * NT_APPLY_AUDIT_SMJ
     */
    protected String orderByClause;

    /**
     * NT_APPLY_AUDIT_SMJ
     */
    protected boolean distinct;

    /**
     * NT_APPLY_AUDIT_SMJ
     */
    protected List<Criteria> oredCriteria;

    /**
     * NT_APPLY_AUDIT_SMJ ApplyAuditSmjExample
     */
    public ApplyAuditSmjExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * NT_APPLY_AUDIT_SMJ ApplyAuditSmjExample
     */
    protected ApplyAuditSmjExample(ApplyAuditSmjExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * NT_APPLY_AUDIT_SMJ setOrderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * NT_APPLY_AUDIT_SMJ getOrderByClause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * NT_APPLY_AUDIT_SMJ setDistinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * NT_APPLY_AUDIT_SMJ isDistinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * NT_APPLY_AUDIT_SMJ getOredCriteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * NT_APPLY_AUDIT_SMJ or
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * NT_APPLY_AUDIT_SMJ or
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * NT_APPLY_AUDIT_SMJ createCriteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * NT_APPLY_AUDIT_SMJ createCriteriaInternal
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * NT_APPLY_AUDIT_SMJ clear
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * NT_APPLY_AUDIT_SMJ
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(String value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(String value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(String value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(String value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(String value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(String value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLike(String value) {
            addCriterion("ID like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotLike(String value) {
            addCriterion("ID not like", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<String> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<String> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(String value1, String value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(String value1, String value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
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

        public Criteria andSmjNameIsNull() {
            addCriterion("SMJ_NAME is null");
            return (Criteria) this;
        }

        public Criteria andSmjNameIsNotNull() {
            addCriterion("SMJ_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andSmjNameEqualTo(String value) {
            addCriterion("SMJ_NAME =", value, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameNotEqualTo(String value) {
            addCriterion("SMJ_NAME <>", value, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameGreaterThan(String value) {
            addCriterion("SMJ_NAME >", value, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameGreaterThanOrEqualTo(String value) {
            addCriterion("SMJ_NAME >=", value, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameLessThan(String value) {
            addCriterion("SMJ_NAME <", value, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameLessThanOrEqualTo(String value) {
            addCriterion("SMJ_NAME <=", value, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameLike(String value) {
            addCriterion("SMJ_NAME like", value, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameNotLike(String value) {
            addCriterion("SMJ_NAME not like", value, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameIn(List<String> values) {
            addCriterion("SMJ_NAME in", values, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameNotIn(List<String> values) {
            addCriterion("SMJ_NAME not in", values, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameBetween(String value1, String value2) {
            addCriterion("SMJ_NAME between", value1, value2, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjNameNotBetween(String value1, String value2) {
            addCriterion("SMJ_NAME not between", value1, value2, "smjName");
            return (Criteria) this;
        }

        public Criteria andSmjUrlIsNull() {
            addCriterion("SMJ_URL is null");
            return (Criteria) this;
        }

        public Criteria andSmjUrlIsNotNull() {
            addCriterion("SMJ_URL is not null");
            return (Criteria) this;
        }

        public Criteria andSmjUrlEqualTo(String value) {
            addCriterion("SMJ_URL =", value, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlNotEqualTo(String value) {
            addCriterion("SMJ_URL <>", value, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlGreaterThan(String value) {
            addCriterion("SMJ_URL >", value, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlGreaterThanOrEqualTo(String value) {
            addCriterion("SMJ_URL >=", value, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlLessThan(String value) {
            addCriterion("SMJ_URL <", value, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlLessThanOrEqualTo(String value) {
            addCriterion("SMJ_URL <=", value, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlLike(String value) {
            addCriterion("SMJ_URL like", value, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlNotLike(String value) {
            addCriterion("SMJ_URL not like", value, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlIn(List<String> values) {
            addCriterion("SMJ_URL in", values, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlNotIn(List<String> values) {
            addCriterion("SMJ_URL not in", values, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlBetween(String value1, String value2) {
            addCriterion("SMJ_URL between", value1, value2, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andSmjUrlNotBetween(String value1, String value2) {
            addCriterion("SMJ_URL not between", value1, value2, "smjUrl");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNull() {
            addCriterion("UPLOAD_DATE is null");
            return (Criteria) this;
        }

        public Criteria andUploadDateIsNotNull() {
            addCriterion("UPLOAD_DATE is not null");
            return (Criteria) this;
        }

        public Criteria andUploadDateEqualTo(Date value) {
            addCriterion("UPLOAD_DATE =", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotEqualTo(Date value) {
            addCriterion("UPLOAD_DATE <>", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThan(Date value) {
            addCriterion("UPLOAD_DATE >", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateGreaterThanOrEqualTo(Date value) {
            addCriterion("UPLOAD_DATE >=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThan(Date value) {
            addCriterion("UPLOAD_DATE <", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateLessThanOrEqualTo(Date value) {
            addCriterion("UPLOAD_DATE <=", value, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateIn(List<Date> values) {
            addCriterion("UPLOAD_DATE in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotIn(List<Date> values) {
            addCriterion("UPLOAD_DATE not in", values, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateBetween(Date value1, Date value2) {
            addCriterion("UPLOAD_DATE between", value1, value2, "uploadDate");
            return (Criteria) this;
        }

        public Criteria andUploadDateNotBetween(Date value1, Date value2) {
            addCriterion("UPLOAD_DATE not between", value1, value2, "uploadDate");
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
     * NT_APPLY_AUDIT_SMJ
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}