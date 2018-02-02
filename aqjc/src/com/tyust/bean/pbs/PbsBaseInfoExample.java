package com.tyust.bean.pbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PbsBaseInfoExample {
    /**
     * NT_PBS_BASE_INFO
     */
    protected String orderByClause;

    /**
     * NT_PBS_BASE_INFO
     */
    protected boolean distinct;

    /**
     * NT_PBS_BASE_INFO
     */
    protected List<Criteria> oredCriteria;

    /**
     * NT_PBS_BASE_INFO PbsBaseInfoExample
     */
    public PbsBaseInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * NT_PBS_BASE_INFO PbsBaseInfoExample
     */
    protected PbsBaseInfoExample(PbsBaseInfoExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * NT_PBS_BASE_INFO setOrderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * NT_PBS_BASE_INFO getOrderByClause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * NT_PBS_BASE_INFO setDistinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * NT_PBS_BASE_INFO isDistinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * NT_PBS_BASE_INFO getOredCriteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * NT_PBS_BASE_INFO or
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * NT_PBS_BASE_INFO or
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * NT_PBS_BASE_INFO createCriteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * NT_PBS_BASE_INFO createCriteriaInternal
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * NT_PBS_BASE_INFO clear
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * NT_PBS_BASE_INFO
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

        public Criteria andPbsNameIsNull() {
            addCriterion("PBS_NAME is null");
            return (Criteria) this;
        }

        public Criteria andPbsNameIsNotNull() {
            addCriterion("PBS_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andPbsNameEqualTo(String value) {
            addCriterion("PBS_NAME =", value, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameNotEqualTo(String value) {
            addCriterion("PBS_NAME <>", value, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameGreaterThan(String value) {
            addCriterion("PBS_NAME >", value, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameGreaterThanOrEqualTo(String value) {
            addCriterion("PBS_NAME >=", value, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameLessThan(String value) {
            addCriterion("PBS_NAME <", value, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameLessThanOrEqualTo(String value) {
            addCriterion("PBS_NAME <=", value, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameLike(String value) {
            addCriterion("PBS_NAME like", value, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameNotLike(String value) {
            addCriterion("PBS_NAME not like", value, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameIn(List<String> values) {
            addCriterion("PBS_NAME in", values, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameNotIn(List<String> values) {
            addCriterion("PBS_NAME not in", values, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameBetween(String value1, String value2) {
            addCriterion("PBS_NAME between", value1, value2, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsNameNotBetween(String value1, String value2) {
            addCriterion("PBS_NAME not between", value1, value2, "pbsName");
            return (Criteria) this;
        }

        public Criteria andPbsAddressIsNull() {
            addCriterion("PBS_ADDRESS is null");
            return (Criteria) this;
        }

        public Criteria andPbsAddressIsNotNull() {
            addCriterion("PBS_ADDRESS is not null");
            return (Criteria) this;
        }

        public Criteria andPbsAddressEqualTo(String value) {
            addCriterion("PBS_ADDRESS =", value, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressNotEqualTo(String value) {
            addCriterion("PBS_ADDRESS <>", value, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressGreaterThan(String value) {
            addCriterion("PBS_ADDRESS >", value, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressGreaterThanOrEqualTo(String value) {
            addCriterion("PBS_ADDRESS >=", value, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressLessThan(String value) {
            addCriterion("PBS_ADDRESS <", value, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressLessThanOrEqualTo(String value) {
            addCriterion("PBS_ADDRESS <=", value, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressLike(String value) {
            addCriterion("PBS_ADDRESS like", value, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressNotLike(String value) {
            addCriterion("PBS_ADDRESS not like", value, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressIn(List<String> values) {
            addCriterion("PBS_ADDRESS in", values, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressNotIn(List<String> values) {
            addCriterion("PBS_ADDRESS not in", values, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressBetween(String value1, String value2) {
            addCriterion("PBS_ADDRESS between", value1, value2, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andPbsAddressNotBetween(String value1, String value2) {
            addCriterion("PBS_ADDRESS not between", value1, value2, "pbsAddress");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoIsNull() {
            addCriterion("COMPLETION_INFO is null");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoIsNotNull() {
            addCriterion("COMPLETION_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoEqualTo(String value) {
            addCriterion("COMPLETION_INFO =", value, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoNotEqualTo(String value) {
            addCriterion("COMPLETION_INFO <>", value, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoGreaterThan(String value) {
            addCriterion("COMPLETION_INFO >", value, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoGreaterThanOrEqualTo(String value) {
            addCriterion("COMPLETION_INFO >=", value, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoLessThan(String value) {
            addCriterion("COMPLETION_INFO <", value, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoLessThanOrEqualTo(String value) {
            addCriterion("COMPLETION_INFO <=", value, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoLike(String value) {
            addCriterion("COMPLETION_INFO like", value, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoNotLike(String value) {
            addCriterion("COMPLETION_INFO not like", value, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoIn(List<String> values) {
            addCriterion("COMPLETION_INFO in", values, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoNotIn(List<String> values) {
            addCriterion("COMPLETION_INFO not in", values, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoBetween(String value1, String value2) {
            addCriterion("COMPLETION_INFO between", value1, value2, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andCompletionInfoNotBetween(String value1, String value2) {
            addCriterion("COMPLETION_INFO not between", value1, value2, "completionInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoIsNull() {
            addCriterion("MAINTENANCE_INFO is null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoIsNotNull() {
            addCriterion("MAINTENANCE_INFO is not null");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoEqualTo(String value) {
            addCriterion("MAINTENANCE_INFO =", value, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoNotEqualTo(String value) {
            addCriterion("MAINTENANCE_INFO <>", value, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoGreaterThan(String value) {
            addCriterion("MAINTENANCE_INFO >", value, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoGreaterThanOrEqualTo(String value) {
            addCriterion("MAINTENANCE_INFO >=", value, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoLessThan(String value) {
            addCriterion("MAINTENANCE_INFO <", value, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoLessThanOrEqualTo(String value) {
            addCriterion("MAINTENANCE_INFO <=", value, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoLike(String value) {
            addCriterion("MAINTENANCE_INFO like", value, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoNotLike(String value) {
            addCriterion("MAINTENANCE_INFO not like", value, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoIn(List<String> values) {
            addCriterion("MAINTENANCE_INFO in", values, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoNotIn(List<String> values) {
            addCriterion("MAINTENANCE_INFO not in", values, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoBetween(String value1, String value2) {
            addCriterion("MAINTENANCE_INFO between", value1, value2, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andMaintenanceInfoNotBetween(String value1, String value2) {
            addCriterion("MAINTENANCE_INFO not between", value1, value2, "maintenanceInfo");
            return (Criteria) this;
        }

        public Criteria andUsageIsNull() {
            addCriterion("USAGE is null");
            return (Criteria) this;
        }

        public Criteria andUsageIsNotNull() {
            addCriterion("USAGE is not null");
            return (Criteria) this;
        }

        public Criteria andUsageEqualTo(String value) {
            addCriterion("USAGE =", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageNotEqualTo(String value) {
            addCriterion("USAGE <>", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageGreaterThan(String value) {
            addCriterion("USAGE >", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageGreaterThanOrEqualTo(String value) {
            addCriterion("USAGE >=", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageLessThan(String value) {
            addCriterion("USAGE <", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageLessThanOrEqualTo(String value) {
            addCriterion("USAGE <=", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageLike(String value) {
            addCriterion("USAGE like", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageNotLike(String value) {
            addCriterion("USAGE not like", value, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageIn(List<String> values) {
            addCriterion("USAGE in", values, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageNotIn(List<String> values) {
            addCriterion("USAGE not in", values, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageBetween(String value1, String value2) {
            addCriterion("USAGE between", value1, value2, "usage");
            return (Criteria) this;
        }

        public Criteria andUsageNotBetween(String value1, String value2) {
            addCriterion("USAGE not between", value1, value2, "usage");
            return (Criteria) this;
        }

        public Criteria andModelIsNull() {
            addCriterion("MODEL is null");
            return (Criteria) this;
        }

        public Criteria andModelIsNotNull() {
            addCriterion("MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andModelEqualTo(String value) {
            addCriterion("MODEL =", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotEqualTo(String value) {
            addCriterion("MODEL <>", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThan(String value) {
            addCriterion("MODEL >", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelGreaterThanOrEqualTo(String value) {
            addCriterion("MODEL >=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThan(String value) {
            addCriterion("MODEL <", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLessThanOrEqualTo(String value) {
            addCriterion("MODEL <=", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelLike(String value) {
            addCriterion("MODEL like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotLike(String value) {
            addCriterion("MODEL not like", value, "model");
            return (Criteria) this;
        }

        public Criteria andModelIn(List<String> values) {
            addCriterion("MODEL in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotIn(List<String> values) {
            addCriterion("MODEL not in", values, "model");
            return (Criteria) this;
        }

        public Criteria andModelBetween(String value1, String value2) {
            addCriterion("MODEL between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andModelNotBetween(String value1, String value2) {
            addCriterion("MODEL not between", value1, value2, "model");
            return (Criteria) this;
        }

        public Criteria andDoorNumsIsNull() {
            addCriterion("DOOR_NUMS is null");
            return (Criteria) this;
        }

        public Criteria andDoorNumsIsNotNull() {
            addCriterion("DOOR_NUMS is not null");
            return (Criteria) this;
        }

        public Criteria andDoorNumsEqualTo(Integer value) {
            addCriterion("DOOR_NUMS =", value, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorNumsNotEqualTo(Integer value) {
            addCriterion("DOOR_NUMS <>", value, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorNumsGreaterThan(Integer value) {
            addCriterion("DOOR_NUMS >", value, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorNumsGreaterThanOrEqualTo(Integer value) {
            addCriterion("DOOR_NUMS >=", value, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorNumsLessThan(Integer value) {
            addCriterion("DOOR_NUMS <", value, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorNumsLessThanOrEqualTo(Integer value) {
            addCriterion("DOOR_NUMS <=", value, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorNumsIn(List<Integer> values) {
            addCriterion("DOOR_NUMS in", values, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorNumsNotIn(List<Integer> values) {
            addCriterion("DOOR_NUMS not in", values, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorNumsBetween(Integer value1, Integer value2) {
            addCriterion("DOOR_NUMS between", value1, value2, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorNumsNotBetween(Integer value1, Integer value2) {
            addCriterion("DOOR_NUMS not between", value1, value2, "doorNums");
            return (Criteria) this;
        }

        public Criteria andDoorModelIsNull() {
            addCriterion("DOOR_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andDoorModelIsNotNull() {
            addCriterion("DOOR_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andDoorModelEqualTo(String value) {
            addCriterion("DOOR_MODEL =", value, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelNotEqualTo(String value) {
            addCriterion("DOOR_MODEL <>", value, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelGreaterThan(String value) {
            addCriterion("DOOR_MODEL >", value, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelGreaterThanOrEqualTo(String value) {
            addCriterion("DOOR_MODEL >=", value, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelLessThan(String value) {
            addCriterion("DOOR_MODEL <", value, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelLessThanOrEqualTo(String value) {
            addCriterion("DOOR_MODEL <=", value, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelLike(String value) {
            addCriterion("DOOR_MODEL like", value, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelNotLike(String value) {
            addCriterion("DOOR_MODEL not like", value, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelIn(List<String> values) {
            addCriterion("DOOR_MODEL in", values, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelNotIn(List<String> values) {
            addCriterion("DOOR_MODEL not in", values, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelBetween(String value1, String value2) {
            addCriterion("DOOR_MODEL between", value1, value2, "doorModel");
            return (Criteria) this;
        }

        public Criteria andDoorModelNotBetween(String value1, String value2) {
            addCriterion("DOOR_MODEL not between", value1, value2, "doorModel");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceIsNull() {
            addCriterion("GROUND_RESISTANCE is null");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceIsNotNull() {
            addCriterion("GROUND_RESISTANCE is not null");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceEqualTo(Integer value) {
            addCriterion("GROUND_RESISTANCE =", value, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceNotEqualTo(Integer value) {
            addCriterion("GROUND_RESISTANCE <>", value, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceGreaterThan(Integer value) {
            addCriterion("GROUND_RESISTANCE >", value, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("GROUND_RESISTANCE >=", value, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceLessThan(Integer value) {
            addCriterion("GROUND_RESISTANCE <", value, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceLessThanOrEqualTo(Integer value) {
            addCriterion("GROUND_RESISTANCE <=", value, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceIn(List<Integer> values) {
            addCriterion("GROUND_RESISTANCE in", values, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceNotIn(List<Integer> values) {
            addCriterion("GROUND_RESISTANCE not in", values, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceBetween(Integer value1, Integer value2) {
            addCriterion("GROUND_RESISTANCE between", value1, value2, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andGroundResistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("GROUND_RESISTANCE not between", value1, value2, "groundResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceIsNull() {
            addCriterion("INSULATION_RESISTANCE is null");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceIsNotNull() {
            addCriterion("INSULATION_RESISTANCE is not null");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceEqualTo(Integer value) {
            addCriterion("INSULATION_RESISTANCE =", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceNotEqualTo(Integer value) {
            addCriterion("INSULATION_RESISTANCE <>", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceGreaterThan(Integer value) {
            addCriterion("INSULATION_RESISTANCE >", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceGreaterThanOrEqualTo(Integer value) {
            addCriterion("INSULATION_RESISTANCE >=", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceLessThan(Integer value) {
            addCriterion("INSULATION_RESISTANCE <", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceLessThanOrEqualTo(Integer value) {
            addCriterion("INSULATION_RESISTANCE <=", value, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceIn(List<Integer> values) {
            addCriterion("INSULATION_RESISTANCE in", values, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceNotIn(List<Integer> values) {
            addCriterion("INSULATION_RESISTANCE not in", values, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceBetween(Integer value1, Integer value2) {
            addCriterion("INSULATION_RESISTANCE between", value1, value2, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andInsulationResistanceNotBetween(Integer value1, Integer value2) {
            addCriterion("INSULATION_RESISTANCE not between", value1, value2, "insulationResistance");
            return (Criteria) this;
        }

        public Criteria andGrAnnexIsNull() {
            addCriterion("GR_ANNEX is null");
            return (Criteria) this;
        }

        public Criteria andGrAnnexIsNotNull() {
            addCriterion("GR_ANNEX is not null");
            return (Criteria) this;
        }

        public Criteria andGrAnnexEqualTo(String value) {
            addCriterion("GR_ANNEX =", value, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexNotEqualTo(String value) {
            addCriterion("GR_ANNEX <>", value, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexGreaterThan(String value) {
            addCriterion("GR_ANNEX >", value, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexGreaterThanOrEqualTo(String value) {
            addCriterion("GR_ANNEX >=", value, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexLessThan(String value) {
            addCriterion("GR_ANNEX <", value, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexLessThanOrEqualTo(String value) {
            addCriterion("GR_ANNEX <=", value, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexLike(String value) {
            addCriterion("GR_ANNEX like", value, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexNotLike(String value) {
            addCriterion("GR_ANNEX not like", value, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexIn(List<String> values) {
            addCriterion("GR_ANNEX in", values, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexNotIn(List<String> values) {
            addCriterion("GR_ANNEX not in", values, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexBetween(String value1, String value2) {
            addCriterion("GR_ANNEX between", value1, value2, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andGrAnnexNotBetween(String value1, String value2) {
            addCriterion("GR_ANNEX not between", value1, value2, "grAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexIsNull() {
            addCriterion("IR_ANNEX is null");
            return (Criteria) this;
        }

        public Criteria andIrAnnexIsNotNull() {
            addCriterion("IR_ANNEX is not null");
            return (Criteria) this;
        }

        public Criteria andIrAnnexEqualTo(String value) {
            addCriterion("IR_ANNEX =", value, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexNotEqualTo(String value) {
            addCriterion("IR_ANNEX <>", value, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexGreaterThan(String value) {
            addCriterion("IR_ANNEX >", value, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexGreaterThanOrEqualTo(String value) {
            addCriterion("IR_ANNEX >=", value, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexLessThan(String value) {
            addCriterion("IR_ANNEX <", value, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexLessThanOrEqualTo(String value) {
            addCriterion("IR_ANNEX <=", value, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexLike(String value) {
            addCriterion("IR_ANNEX like", value, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexNotLike(String value) {
            addCriterion("IR_ANNEX not like", value, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexIn(List<String> values) {
            addCriterion("IR_ANNEX in", values, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexNotIn(List<String> values) {
            addCriterion("IR_ANNEX not in", values, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexBetween(String value1, String value2) {
            addCriterion("IR_ANNEX between", value1, value2, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andIrAnnexNotBetween(String value1, String value2) {
            addCriterion("IR_ANNEX not between", value1, value2, "irAnnex");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallIsNull() {
            addCriterion("TELCOM_CABLE_CROSS_WALL is null");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallIsNotNull() {
            addCriterion("TELCOM_CABLE_CROSS_WALL is not null");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallEqualTo(String value) {
            addCriterion("TELCOM_CABLE_CROSS_WALL =", value, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallNotEqualTo(String value) {
            addCriterion("TELCOM_CABLE_CROSS_WALL <>", value, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallGreaterThan(String value) {
            addCriterion("TELCOM_CABLE_CROSS_WALL >", value, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallGreaterThanOrEqualTo(String value) {
            addCriterion("TELCOM_CABLE_CROSS_WALL >=", value, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallLessThan(String value) {
            addCriterion("TELCOM_CABLE_CROSS_WALL <", value, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallLessThanOrEqualTo(String value) {
            addCriterion("TELCOM_CABLE_CROSS_WALL <=", value, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallLike(String value) {
            addCriterion("TELCOM_CABLE_CROSS_WALL like", value, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallNotLike(String value) {
            addCriterion("TELCOM_CABLE_CROSS_WALL not like", value, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallIn(List<String> values) {
            addCriterion("TELCOM_CABLE_CROSS_WALL in", values, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallNotIn(List<String> values) {
            addCriterion("TELCOM_CABLE_CROSS_WALL not in", values, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallBetween(String value1, String value2) {
            addCriterion("TELCOM_CABLE_CROSS_WALL between", value1, value2, "telcomCableCrossWall");
            return (Criteria) this;
        }

        public Criteria andTelcomCableCrossWallNotBetween(String value1, String value2) {
            addCriterion("TELCOM_CABLE_CROSS_WALL not between", value1, value2, "telcomCableCrossWall");
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

        public Criteria andPbsUnitIdIsNull() {
            addCriterion("PBS_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdIsNotNull() {
            addCriterion("PBS_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdEqualTo(String value) {
            addCriterion("PBS_UNIT_ID =", value, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdNotEqualTo(String value) {
            addCriterion("PBS_UNIT_ID <>", value, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdGreaterThan(String value) {
            addCriterion("PBS_UNIT_ID >", value, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("PBS_UNIT_ID >=", value, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdLessThan(String value) {
            addCriterion("PBS_UNIT_ID <", value, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdLessThanOrEqualTo(String value) {
            addCriterion("PBS_UNIT_ID <=", value, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdLike(String value) {
            addCriterion("PBS_UNIT_ID like", value, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdNotLike(String value) {
            addCriterion("PBS_UNIT_ID not like", value, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdIn(List<String> values) {
            addCriterion("PBS_UNIT_ID in", values, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdNotIn(List<String> values) {
            addCriterion("PBS_UNIT_ID not in", values, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdBetween(String value1, String value2) {
            addCriterion("PBS_UNIT_ID between", value1, value2, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andPbsUnitIdNotBetween(String value1, String value2) {
            addCriterion("PBS_UNIT_ID not between", value1, value2, "pbsUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdIsNull() {
            addCriterion("BUILDER_UNIT_ID is null");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdIsNotNull() {
            addCriterion("BUILDER_UNIT_ID is not null");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdEqualTo(String value) {
            addCriterion("BUILDER_UNIT_ID =", value, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdNotEqualTo(String value) {
            addCriterion("BUILDER_UNIT_ID <>", value, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdGreaterThan(String value) {
            addCriterion("BUILDER_UNIT_ID >", value, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdGreaterThanOrEqualTo(String value) {
            addCriterion("BUILDER_UNIT_ID >=", value, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdLessThan(String value) {
            addCriterion("BUILDER_UNIT_ID <", value, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdLessThanOrEqualTo(String value) {
            addCriterion("BUILDER_UNIT_ID <=", value, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdLike(String value) {
            addCriterion("BUILDER_UNIT_ID like", value, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdNotLike(String value) {
            addCriterion("BUILDER_UNIT_ID not like", value, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdIn(List<String> values) {
            addCriterion("BUILDER_UNIT_ID in", values, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdNotIn(List<String> values) {
            addCriterion("BUILDER_UNIT_ID not in", values, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdBetween(String value1, String value2) {
            addCriterion("BUILDER_UNIT_ID between", value1, value2, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andBuilderUnitIdNotBetween(String value1, String value2) {
            addCriterion("BUILDER_UNIT_ID not between", value1, value2, "builderUnitId");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIsNull() {
            addCriterion("DEVICE_NUM is null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIsNotNull() {
            addCriterion("DEVICE_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceNumEqualTo(Integer value) {
            addCriterion("DEVICE_NUM =", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotEqualTo(Integer value) {
            addCriterion("DEVICE_NUM <>", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumGreaterThan(Integer value) {
            addCriterion("DEVICE_NUM >", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("DEVICE_NUM >=", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLessThan(Integer value) {
            addCriterion("DEVICE_NUM <", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumLessThanOrEqualTo(Integer value) {
            addCriterion("DEVICE_NUM <=", value, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumIn(List<Integer> values) {
            addCriterion("DEVICE_NUM in", values, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotIn(List<Integer> values) {
            addCriterion("DEVICE_NUM not in", values, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumBetween(Integer value1, Integer value2) {
            addCriterion("DEVICE_NUM between", value1, value2, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andDeviceNumNotBetween(Integer value1, Integer value2) {
            addCriterion("DEVICE_NUM not between", value1, value2, "deviceNum");
            return (Criteria) this;
        }

        public Criteria andPbsSizeIsNull() {
            addCriterion("PBS_SIZE is null");
            return (Criteria) this;
        }

        public Criteria andPbsSizeIsNotNull() {
            addCriterion("PBS_SIZE is not null");
            return (Criteria) this;
        }

        public Criteria andPbsSizeEqualTo(String value) {
            addCriterion("PBS_SIZE =", value, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeNotEqualTo(String value) {
            addCriterion("PBS_SIZE <>", value, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeGreaterThan(String value) {
            addCriterion("PBS_SIZE >", value, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeGreaterThanOrEqualTo(String value) {
            addCriterion("PBS_SIZE >=", value, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeLessThan(String value) {
            addCriterion("PBS_SIZE <", value, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeLessThanOrEqualTo(String value) {
            addCriterion("PBS_SIZE <=", value, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeLike(String value) {
            addCriterion("PBS_SIZE like", value, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeNotLike(String value) {
            addCriterion("PBS_SIZE not like", value, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeIn(List<String> values) {
            addCriterion("PBS_SIZE in", values, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeNotIn(List<String> values) {
            addCriterion("PBS_SIZE not in", values, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeBetween(String value1, String value2) {
            addCriterion("PBS_SIZE between", value1, value2, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPbsSizeNotBetween(String value1, String value2) {
            addCriterion("PBS_SIZE not between", value1, value2, "pbsSize");
            return (Criteria) this;
        }

        public Criteria andPmPicIsNull() {
            addCriterion("PM_PIC is null");
            return (Criteria) this;
        }

        public Criteria andPmPicIsNotNull() {
            addCriterion("PM_PIC is not null");
            return (Criteria) this;
        }

        public Criteria andPmPicEqualTo(String value) {
            addCriterion("PM_PIC =", value, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicNotEqualTo(String value) {
            addCriterion("PM_PIC <>", value, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicGreaterThan(String value) {
            addCriterion("PM_PIC >", value, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicGreaterThanOrEqualTo(String value) {
            addCriterion("PM_PIC >=", value, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicLessThan(String value) {
            addCriterion("PM_PIC <", value, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicLessThanOrEqualTo(String value) {
            addCriterion("PM_PIC <=", value, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicLike(String value) {
            addCriterion("PM_PIC like", value, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicNotLike(String value) {
            addCriterion("PM_PIC not like", value, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicIn(List<String> values) {
            addCriterion("PM_PIC in", values, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicNotIn(List<String> values) {
            addCriterion("PM_PIC not in", values, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicBetween(String value1, String value2) {
            addCriterion("PM_PIC between", value1, value2, "pmPic");
            return (Criteria) this;
        }

        public Criteria andPmPicNotBetween(String value1, String value2) {
            addCriterion("PM_PIC not between", value1, value2, "pmPic");
            return (Criteria) this;
        }
    }

    /**
     * NT_PBS_BASE_INFO
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}