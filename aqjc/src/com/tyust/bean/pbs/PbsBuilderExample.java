package com.tyust.bean.pbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PbsBuilderExample {
    /**
     * NT_PBS_BUILDER
     */
    protected String orderByClause;

    /**
     * NT_PBS_BUILDER
     */
    protected boolean distinct;

    /**
     * NT_PBS_BUILDER
     */
    protected List<Criteria> oredCriteria;

    /**
     * NT_PBS_BUILDER PbsBuilderExample
     */
    public PbsBuilderExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * NT_PBS_BUILDER PbsBuilderExample
     */
    protected PbsBuilderExample(PbsBuilderExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * NT_PBS_BUILDER setOrderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * NT_PBS_BUILDER getOrderByClause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * NT_PBS_BUILDER setDistinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * NT_PBS_BUILDER isDistinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * NT_PBS_BUILDER getOredCriteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * NT_PBS_BUILDER or
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * NT_PBS_BUILDER or
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * NT_PBS_BUILDER createCriteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * NT_PBS_BUILDER createCriteriaInternal
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * NT_PBS_BUILDER clear
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * NT_PBS_BUILDER
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

        public Criteria andUnitNameIsNull() {
            addCriterion("UNIT_NAME is null");
            return (Criteria) this;
        }

        public Criteria andUnitNameIsNotNull() {
            addCriterion("UNIT_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andUnitNameEqualTo(String value) {
            addCriterion("UNIT_NAME =", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotEqualTo(String value) {
            addCriterion("UNIT_NAME <>", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThan(String value) {
            addCriterion("UNIT_NAME >", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_NAME >=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThan(String value) {
            addCriterion("UNIT_NAME <", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLessThanOrEqualTo(String value) {
            addCriterion("UNIT_NAME <=", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameLike(String value) {
            addCriterion("UNIT_NAME like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotLike(String value) {
            addCriterion("UNIT_NAME not like", value, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameIn(List<String> values) {
            addCriterion("UNIT_NAME in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotIn(List<String> values) {
            addCriterion("UNIT_NAME not in", values, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameBetween(String value1, String value2) {
            addCriterion("UNIT_NAME between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitNameNotBetween(String value1, String value2) {
            addCriterion("UNIT_NAME not between", value1, value2, "unitName");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNull() {
            addCriterion("UNIT_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIsNotNull() {
            addCriterion("UNIT_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTypeEqualTo(String value) {
            addCriterion("UNIT_TYPE =", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotEqualTo(String value) {
            addCriterion("UNIT_TYPE <>", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThan(String value) {
            addCriterion("UNIT_TYPE >", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_TYPE >=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThan(String value) {
            addCriterion("UNIT_TYPE <", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLessThanOrEqualTo(String value) {
            addCriterion("UNIT_TYPE <=", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeLike(String value) {
            addCriterion("UNIT_TYPE like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotLike(String value) {
            addCriterion("UNIT_TYPE not like", value, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeIn(List<String> values) {
            addCriterion("UNIT_TYPE in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotIn(List<String> values) {
            addCriterion("UNIT_TYPE not in", values, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeBetween(String value1, String value2) {
            addCriterion("UNIT_TYPE between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andUnitTypeNotBetween(String value1, String value2) {
            addCriterion("UNIT_TYPE not between", value1, value2, "unitType");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNull() {
            addCriterion("BUSINESS_SCOPE is null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIsNotNull() {
            addCriterion("BUSINESS_SCOPE is not null");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE =", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <>", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThan(String value) {
            addCriterion("BUSINESS_SCOPE >", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeGreaterThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE >=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThan(String value) {
            addCriterion("BUSINESS_SCOPE <", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLessThanOrEqualTo(String value) {
            addCriterion("BUSINESS_SCOPE <=", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeLike(String value) {
            addCriterion("BUSINESS_SCOPE like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotLike(String value) {
            addCriterion("BUSINESS_SCOPE not like", value, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotIn(List<String> values) {
            addCriterion("BUSINESS_SCOPE not in", values, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andBusinessScopeNotBetween(String value1, String value2) {
            addCriterion("BUSINESS_SCOPE not between", value1, value2, "businessScope");
            return (Criteria) this;
        }

        public Criteria andUnitAddressIsNull() {
            addCriterion("UNIT_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andUnitAddressIsNotNull() {
            addCriterion("UNIT_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andUnitAddressEqualTo(String value) {
            addCriterion("UNIT_ADDRESS =", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressNotEqualTo(String value) {
            addCriterion("UNIT_ADDRESS <>", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressGreaterThan(String value) {
            addCriterion("UNIT_ADDRESS >", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_ADDRESS >=", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressLessThan(String value) {
            addCriterion("UNIT_ADDRESS <", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressLessThanOrEqualTo(String value) {
            addCriterion("UNIT_ADDRESS <=", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressLike(String value) {
            addCriterion("UNIT_ADDRESS like", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressNotLike(String value) {
            addCriterion("UNIT_ADDRESS not like", value, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressIn(List<String> values) {
            addCriterion("UNIT_ADDRESS in", values, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressNotIn(List<String> values) {
            addCriterion("UNIT_ADDRESS not in", values, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressBetween(String value1, String value2) {
            addCriterion("UNIT_ADDRESS between", value1, value2, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andUnitAddressNotBetween(String value1, String value2) {
            addCriterion("UNIT_ADDRESS not between", value1, value2, "unitAddress");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNull() {
            addCriterion("POST_CODE is null");
            return (Criteria) this;
        }

        public Criteria andPostCodeIsNotNull() {
            addCriterion("POST_CODE is not null");
            return (Criteria) this;
        }

        public Criteria andPostCodeEqualTo(String value) {
            addCriterion("POST_CODE =", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotEqualTo(String value) {
            addCriterion("POST_CODE <>", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThan(String value) {
            addCriterion("POST_CODE >", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeGreaterThanOrEqualTo(String value) {
            addCriterion("POST_CODE >=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThan(String value) {
            addCriterion("POST_CODE <", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLessThanOrEqualTo(String value) {
            addCriterion("POST_CODE <=", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeLike(String value) {
            addCriterion("POST_CODE like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotLike(String value) {
            addCriterion("POST_CODE not like", value, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeIn(List<String> values) {
            addCriterion("POST_CODE in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotIn(List<String> values) {
            addCriterion("POST_CODE not in", values, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeBetween(String value1, String value2) {
            addCriterion("POST_CODE between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andPostCodeNotBetween(String value1, String value2) {
            addCriterion("POST_CODE not between", value1, value2, "postCode");
            return (Criteria) this;
        }

        public Criteria andUnitTelIsNull() {
            addCriterion("UNIT_TEL is null");
            return (Criteria) this;
        }

        public Criteria andUnitTelIsNotNull() {
            addCriterion("UNIT_TEL is not null");
            return (Criteria) this;
        }

        public Criteria andUnitTelEqualTo(String value) {
            addCriterion("UNIT_TEL =", value, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelNotEqualTo(String value) {
            addCriterion("UNIT_TEL <>", value, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelGreaterThan(String value) {
            addCriterion("UNIT_TEL >", value, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_TEL >=", value, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelLessThan(String value) {
            addCriterion("UNIT_TEL <", value, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelLessThanOrEqualTo(String value) {
            addCriterion("UNIT_TEL <=", value, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelLike(String value) {
            addCriterion("UNIT_TEL like", value, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelNotLike(String value) {
            addCriterion("UNIT_TEL not like", value, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelIn(List<String> values) {
            addCriterion("UNIT_TEL in", values, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelNotIn(List<String> values) {
            addCriterion("UNIT_TEL not in", values, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelBetween(String value1, String value2) {
            addCriterion("UNIT_TEL between", value1, value2, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitTelNotBetween(String value1, String value2) {
            addCriterion("UNIT_TEL not between", value1, value2, "unitTel");
            return (Criteria) this;
        }

        public Criteria andUnitEmailIsNull() {
            addCriterion("UNIT_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andUnitEmailIsNotNull() {
            addCriterion("UNIT_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andUnitEmailEqualTo(String value) {
            addCriterion("UNIT_EMAIL =", value, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailNotEqualTo(String value) {
            addCriterion("UNIT_EMAIL <>", value, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailGreaterThan(String value) {
            addCriterion("UNIT_EMAIL >", value, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailGreaterThanOrEqualTo(String value) {
            addCriterion("UNIT_EMAIL >=", value, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailLessThan(String value) {
            addCriterion("UNIT_EMAIL <", value, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailLessThanOrEqualTo(String value) {
            addCriterion("UNIT_EMAIL <=", value, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailLike(String value) {
            addCriterion("UNIT_EMAIL like", value, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailNotLike(String value) {
            addCriterion("UNIT_EMAIL not like", value, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailIn(List<String> values) {
            addCriterion("UNIT_EMAIL in", values, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailNotIn(List<String> values) {
            addCriterion("UNIT_EMAIL not in", values, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailBetween(String value1, String value2) {
            addCriterion("UNIT_EMAIL between", value1, value2, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andUnitEmailNotBetween(String value1, String value2) {
            addCriterion("UNIT_EMAIL not between", value1, value2, "unitEmail");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNull() {
            addCriterion("LEGAL_PERSON is null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIsNotNull() {
            addCriterion("LEGAL_PERSON is not null");
            return (Criteria) this;
        }

        public Criteria andLegalPersonEqualTo(String value) {
            addCriterion("LEGAL_PERSON =", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotEqualTo(String value) {
            addCriterion("LEGAL_PERSON <>", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThan(String value) {
            addCriterion("LEGAL_PERSON >", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonGreaterThanOrEqualTo(String value) {
            addCriterion("LEGAL_PERSON >=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThan(String value) {
            addCriterion("LEGAL_PERSON <", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLessThanOrEqualTo(String value) {
            addCriterion("LEGAL_PERSON <=", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonLike(String value) {
            addCriterion("LEGAL_PERSON like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotLike(String value) {
            addCriterion("LEGAL_PERSON not like", value, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonIn(List<String> values) {
            addCriterion("LEGAL_PERSON in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotIn(List<String> values) {
            addCriterion("LEGAL_PERSON not in", values, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonBetween(String value1, String value2) {
            addCriterion("LEGAL_PERSON between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLegalPersonNotBetween(String value1, String value2) {
            addCriterion("LEGAL_PERSON not between", value1, value2, "legalPerson");
            return (Criteria) this;
        }

        public Criteria andLpPositionIsNull() {
            addCriterion("LP_POSITION is null");
            return (Criteria) this;
        }

        public Criteria andLpPositionIsNotNull() {
            addCriterion("LP_POSITION is not null");
            return (Criteria) this;
        }

        public Criteria andLpPositionEqualTo(String value) {
            addCriterion("LP_POSITION =", value, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionNotEqualTo(String value) {
            addCriterion("LP_POSITION <>", value, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionGreaterThan(String value) {
            addCriterion("LP_POSITION >", value, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionGreaterThanOrEqualTo(String value) {
            addCriterion("LP_POSITION >=", value, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionLessThan(String value) {
            addCriterion("LP_POSITION <", value, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionLessThanOrEqualTo(String value) {
            addCriterion("LP_POSITION <=", value, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionLike(String value) {
            addCriterion("LP_POSITION like", value, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionNotLike(String value) {
            addCriterion("LP_POSITION not like", value, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionIn(List<String> values) {
            addCriterion("LP_POSITION in", values, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionNotIn(List<String> values) {
            addCriterion("LP_POSITION not in", values, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionBetween(String value1, String value2) {
            addCriterion("LP_POSITION between", value1, value2, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpPositionNotBetween(String value1, String value2) {
            addCriterion("LP_POSITION not between", value1, value2, "lpPosition");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneIsNull() {
            addCriterion("LP_TELPHONE is null");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneIsNotNull() {
            addCriterion("LP_TELPHONE is not null");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneEqualTo(String value) {
            addCriterion("LP_TELPHONE =", value, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneNotEqualTo(String value) {
            addCriterion("LP_TELPHONE <>", value, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneGreaterThan(String value) {
            addCriterion("LP_TELPHONE >", value, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneGreaterThanOrEqualTo(String value) {
            addCriterion("LP_TELPHONE >=", value, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneLessThan(String value) {
            addCriterion("LP_TELPHONE <", value, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneLessThanOrEqualTo(String value) {
            addCriterion("LP_TELPHONE <=", value, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneLike(String value) {
            addCriterion("LP_TELPHONE like", value, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneNotLike(String value) {
            addCriterion("LP_TELPHONE not like", value, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneIn(List<String> values) {
            addCriterion("LP_TELPHONE in", values, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneNotIn(List<String> values) {
            addCriterion("LP_TELPHONE not in", values, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneBetween(String value1, String value2) {
            addCriterion("LP_TELPHONE between", value1, value2, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTelphoneNotBetween(String value1, String value2) {
            addCriterion("LP_TELPHONE not between", value1, value2, "lpTelphone");
            return (Criteria) this;
        }

        public Criteria andLpTaxIsNull() {
            addCriterion("LP_TAX is null");
            return (Criteria) this;
        }

        public Criteria andLpTaxIsNotNull() {
            addCriterion("LP_TAX is not null");
            return (Criteria) this;
        }

        public Criteria andLpTaxEqualTo(String value) {
            addCriterion("LP_TAX =", value, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxNotEqualTo(String value) {
            addCriterion("LP_TAX <>", value, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxGreaterThan(String value) {
            addCriterion("LP_TAX >", value, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxGreaterThanOrEqualTo(String value) {
            addCriterion("LP_TAX >=", value, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxLessThan(String value) {
            addCriterion("LP_TAX <", value, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxLessThanOrEqualTo(String value) {
            addCriterion("LP_TAX <=", value, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxLike(String value) {
            addCriterion("LP_TAX like", value, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxNotLike(String value) {
            addCriterion("LP_TAX not like", value, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxIn(List<String> values) {
            addCriterion("LP_TAX in", values, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxNotIn(List<String> values) {
            addCriterion("LP_TAX not in", values, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxBetween(String value1, String value2) {
            addCriterion("LP_TAX between", value1, value2, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpTaxNotBetween(String value1, String value2) {
            addCriterion("LP_TAX not between", value1, value2, "lpTax");
            return (Criteria) this;
        }

        public Criteria andLpEmailIsNull() {
            addCriterion("LP_EMAIL is null");
            return (Criteria) this;
        }

        public Criteria andLpEmailIsNotNull() {
            addCriterion("LP_EMAIL is not null");
            return (Criteria) this;
        }

        public Criteria andLpEmailEqualTo(String value) {
            addCriterion("LP_EMAIL =", value, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailNotEqualTo(String value) {
            addCriterion("LP_EMAIL <>", value, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailGreaterThan(String value) {
            addCriterion("LP_EMAIL >", value, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailGreaterThanOrEqualTo(String value) {
            addCriterion("LP_EMAIL >=", value, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailLessThan(String value) {
            addCriterion("LP_EMAIL <", value, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailLessThanOrEqualTo(String value) {
            addCriterion("LP_EMAIL <=", value, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailLike(String value) {
            addCriterion("LP_EMAIL like", value, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailNotLike(String value) {
            addCriterion("LP_EMAIL not like", value, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailIn(List<String> values) {
            addCriterion("LP_EMAIL in", values, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailNotIn(List<String> values) {
            addCriterion("LP_EMAIL not in", values, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailBetween(String value1, String value2) {
            addCriterion("LP_EMAIL between", value1, value2, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andLpEmailNotBetween(String value1, String value2) {
            addCriterion("LP_EMAIL not between", value1, value2, "lpEmail");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlIsNull() {
            addCriterion("ZZZS_URL is null");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlIsNotNull() {
            addCriterion("ZZZS_URL is not null");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlEqualTo(String value) {
            addCriterion("ZZZS_URL =", value, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlNotEqualTo(String value) {
            addCriterion("ZZZS_URL <>", value, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlGreaterThan(String value) {
            addCriterion("ZZZS_URL >", value, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlGreaterThanOrEqualTo(String value) {
            addCriterion("ZZZS_URL >=", value, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlLessThan(String value) {
            addCriterion("ZZZS_URL <", value, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlLessThanOrEqualTo(String value) {
            addCriterion("ZZZS_URL <=", value, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlLike(String value) {
            addCriterion("ZZZS_URL like", value, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlNotLike(String value) {
            addCriterion("ZZZS_URL not like", value, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlIn(List<String> values) {
            addCriterion("ZZZS_URL in", values, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlNotIn(List<String> values) {
            addCriterion("ZZZS_URL not in", values, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlBetween(String value1, String value2) {
            addCriterion("ZZZS_URL between", value1, value2, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andZzzsUrlNotBetween(String value1, String value2) {
            addCriterion("ZZZS_URL not between", value1, value2, "zzzsUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlIsNull() {
            addCriterion("YYZZ_URL is null");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlIsNotNull() {
            addCriterion("YYZZ_URL is not null");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlEqualTo(String value) {
            addCriterion("YYZZ_URL =", value, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlNotEqualTo(String value) {
            addCriterion("YYZZ_URL <>", value, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlGreaterThan(String value) {
            addCriterion("YYZZ_URL >", value, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlGreaterThanOrEqualTo(String value) {
            addCriterion("YYZZ_URL >=", value, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlLessThan(String value) {
            addCriterion("YYZZ_URL <", value, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlLessThanOrEqualTo(String value) {
            addCriterion("YYZZ_URL <=", value, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlLike(String value) {
            addCriterion("YYZZ_URL like", value, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlNotLike(String value) {
            addCriterion("YYZZ_URL not like", value, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlIn(List<String> values) {
            addCriterion("YYZZ_URL in", values, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlNotIn(List<String> values) {
            addCriterion("YYZZ_URL not in", values, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlBetween(String value1, String value2) {
            addCriterion("YYZZ_URL between", value1, value2, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andYyzzUrlNotBetween(String value1, String value2) {
            addCriterion("YYZZ_URL not between", value1, value2, "yyzzUrl");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroIsNull() {
            addCriterion("BUILDER_INTRO is null");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroIsNotNull() {
            addCriterion("BUILDER_INTRO is not null");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroEqualTo(String value) {
            addCriterion("BUILDER_INTRO =", value, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroNotEqualTo(String value) {
            addCriterion("BUILDER_INTRO <>", value, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroGreaterThan(String value) {
            addCriterion("BUILDER_INTRO >", value, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDER_INTRO >=", value, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroLessThan(String value) {
            addCriterion("BUILDER_INTRO <", value, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroLessThanOrEqualTo(String value) {
            addCriterion("BUILDER_INTRO <=", value, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroLike(String value) {
            addCriterion("BUILDER_INTRO like", value, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroNotLike(String value) {
            addCriterion("BUILDER_INTRO not like", value, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroIn(List<String> values) {
            addCriterion("BUILDER_INTRO in", values, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroNotIn(List<String> values) {
            addCriterion("BUILDER_INTRO not in", values, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroBetween(String value1, String value2) {
            addCriterion("BUILDER_INTRO between", value1, value2, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andBuilderIntroNotBetween(String value1, String value2) {
            addCriterion("BUILDER_INTRO not between", value1, value2, "builderIntro");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityIsNull() {
            addCriterion("RESEARCH_ABILITY is null");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityIsNotNull() {
            addCriterion("RESEARCH_ABILITY is not null");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityEqualTo(String value) {
            addCriterion("RESEARCH_ABILITY =", value, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityNotEqualTo(String value) {
            addCriterion("RESEARCH_ABILITY <>", value, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityGreaterThan(String value) {
            addCriterion("RESEARCH_ABILITY >", value, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityGreaterThanOrEqualTo(String value) {
            addCriterion("RESEARCH_ABILITY >=", value, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityLessThan(String value) {
            addCriterion("RESEARCH_ABILITY <", value, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityLessThanOrEqualTo(String value) {
            addCriterion("RESEARCH_ABILITY <=", value, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityLike(String value) {
            addCriterion("RESEARCH_ABILITY like", value, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityNotLike(String value) {
            addCriterion("RESEARCH_ABILITY not like", value, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityIn(List<String> values) {
            addCriterion("RESEARCH_ABILITY in", values, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityNotIn(List<String> values) {
            addCriterion("RESEARCH_ABILITY not in", values, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityBetween(String value1, String value2) {
            addCriterion("RESEARCH_ABILITY between", value1, value2, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andResearchAbilityNotBetween(String value1, String value2) {
            addCriterion("RESEARCH_ABILITY not between", value1, value2, "researchAbility");
            return (Criteria) this;
        }

        public Criteria andQualityManageIsNull() {
            addCriterion("QUALITY_MANAGE is null");
            return (Criteria) this;
        }

        public Criteria andQualityManageIsNotNull() {
            addCriterion("QUALITY_MANAGE is not null");
            return (Criteria) this;
        }

        public Criteria andQualityManageEqualTo(String value) {
            addCriterion("QUALITY_MANAGE =", value, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageNotEqualTo(String value) {
            addCriterion("QUALITY_MANAGE <>", value, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageGreaterThan(String value) {
            addCriterion("QUALITY_MANAGE >", value, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageGreaterThanOrEqualTo(String value) {
            addCriterion("QUALITY_MANAGE >=", value, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageLessThan(String value) {
            addCriterion("QUALITY_MANAGE <", value, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageLessThanOrEqualTo(String value) {
            addCriterion("QUALITY_MANAGE <=", value, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageLike(String value) {
            addCriterion("QUALITY_MANAGE like", value, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageNotLike(String value) {
            addCriterion("QUALITY_MANAGE not like", value, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageIn(List<String> values) {
            addCriterion("QUALITY_MANAGE in", values, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageNotIn(List<String> values) {
            addCriterion("QUALITY_MANAGE not in", values, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageBetween(String value1, String value2) {
            addCriterion("QUALITY_MANAGE between", value1, value2, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andQualityManageNotBetween(String value1, String value2) {
            addCriterion("QUALITY_MANAGE not between", value1, value2, "qualityManage");
            return (Criteria) this;
        }

        public Criteria andAfterServiceIsNull() {
            addCriterion("AFTER_SERVICE is null");
            return (Criteria) this;
        }

        public Criteria andAfterServiceIsNotNull() {
            addCriterion("AFTER_SERVICE is not null");
            return (Criteria) this;
        }

        public Criteria andAfterServiceEqualTo(String value) {
            addCriterion("AFTER_SERVICE =", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceNotEqualTo(String value) {
            addCriterion("AFTER_SERVICE <>", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceGreaterThan(String value) {
            addCriterion("AFTER_SERVICE >", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceGreaterThanOrEqualTo(String value) {
            addCriterion("AFTER_SERVICE >=", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceLessThan(String value) {
            addCriterion("AFTER_SERVICE <", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceLessThanOrEqualTo(String value) {
            addCriterion("AFTER_SERVICE <=", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceLike(String value) {
            addCriterion("AFTER_SERVICE like", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceNotLike(String value) {
            addCriterion("AFTER_SERVICE not like", value, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceIn(List<String> values) {
            addCriterion("AFTER_SERVICE in", values, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceNotIn(List<String> values) {
            addCriterion("AFTER_SERVICE not in", values, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceBetween(String value1, String value2) {
            addCriterion("AFTER_SERVICE between", value1, value2, "afterService");
            return (Criteria) this;
        }

        public Criteria andAfterServiceNotBetween(String value1, String value2) {
            addCriterion("AFTER_SERVICE not between", value1, value2, "afterService");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageIsNull() {
            addCriterion("EMPLOYEE_MANAGE is null");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageIsNotNull() {
            addCriterion("EMPLOYEE_MANAGE is not null");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageEqualTo(String value) {
            addCriterion("EMPLOYEE_MANAGE =", value, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageNotEqualTo(String value) {
            addCriterion("EMPLOYEE_MANAGE <>", value, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageGreaterThan(String value) {
            addCriterion("EMPLOYEE_MANAGE >", value, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageGreaterThanOrEqualTo(String value) {
            addCriterion("EMPLOYEE_MANAGE >=", value, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageLessThan(String value) {
            addCriterion("EMPLOYEE_MANAGE <", value, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageLessThanOrEqualTo(String value) {
            addCriterion("EMPLOYEE_MANAGE <=", value, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageLike(String value) {
            addCriterion("EMPLOYEE_MANAGE like", value, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageNotLike(String value) {
            addCriterion("EMPLOYEE_MANAGE not like", value, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageIn(List<String> values) {
            addCriterion("EMPLOYEE_MANAGE in", values, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageNotIn(List<String> values) {
            addCriterion("EMPLOYEE_MANAGE not in", values, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageBetween(String value1, String value2) {
            addCriterion("EMPLOYEE_MANAGE between", value1, value2, "employeeManage");
            return (Criteria) this;
        }

        public Criteria andEmployeeManageNotBetween(String value1, String value2) {
            addCriterion("EMPLOYEE_MANAGE not between", value1, value2, "employeeManage");
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
     * NT_PBS_BUILDER
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}