package com.tyust.bean.pbs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.tyust.common.IbatorGenExamplePageHelper;

public class PbsDeviceExample extends IbatorGenExamplePageHelper{
    /**
     * NT_PBS_DEVICE
     */
    protected String orderByClause;

    /**
     * NT_PBS_DEVICE
     */
    protected boolean distinct;

    /**
     * NT_PBS_DEVICE
     */
    protected List<Criteria> oredCriteria;

    /**
     * NT_PBS_DEVICE PbsDeviceExample
     */
    public PbsDeviceExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    /**
     * NT_PBS_DEVICE PbsDeviceExample
     */
    protected PbsDeviceExample(PbsDeviceExample example) {
        this.orderByClause = example.orderByClause;
        this.oredCriteria = example.oredCriteria;
        this.distinct = example.distinct;
    }

    /**
     * NT_PBS_DEVICE setOrderByClause
     */
    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    /**
     * NT_PBS_DEVICE getOrderByClause
     */
    public String getOrderByClause() {
        return orderByClause;
    }

    /**
     * NT_PBS_DEVICE setDistinct
     */
    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    /**
     * NT_PBS_DEVICE isDistinct
     */
    public boolean isDistinct() {
        return distinct;
    }

    /**
     * NT_PBS_DEVICE getOredCriteria
     */
    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    /**
     * NT_PBS_DEVICE or
     */
    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    /**
     * NT_PBS_DEVICE or
     */
    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    /**
     * NT_PBS_DEVICE createCriteria
     */
    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    /**
     * NT_PBS_DEVICE createCriteriaInternal
     */
    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    /**
     * NT_PBS_DEVICE clear
     */
    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    /**
     * NT_PBS_DEVICE
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

        public Criteria andDevFactoryIsNull() {
            addCriterion("DEV_FACTORY is null");
            return (Criteria) this;
        }

        public Criteria andDevFactoryIsNotNull() {
            addCriterion("DEV_FACTORY is not null");
            return (Criteria) this;
        }

        public Criteria andDevFactoryEqualTo(String value) {
            addCriterion("DEV_FACTORY =", value, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryNotEqualTo(String value) {
            addCriterion("DEV_FACTORY <>", value, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryGreaterThan(String value) {
            addCriterion("DEV_FACTORY >", value, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_FACTORY >=", value, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryLessThan(String value) {
            addCriterion("DEV_FACTORY <", value, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryLessThanOrEqualTo(String value) {
            addCriterion("DEV_FACTORY <=", value, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryLike(String value) {
            addCriterion("DEV_FACTORY like", value, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryNotLike(String value) {
            addCriterion("DEV_FACTORY not like", value, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryIn(List<String> values) {
            addCriterion("DEV_FACTORY in", values, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryNotIn(List<String> values) {
            addCriterion("DEV_FACTORY not in", values, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryBetween(String value1, String value2) {
            addCriterion("DEV_FACTORY between", value1, value2, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevFactoryNotBetween(String value1, String value2) {
            addCriterion("DEV_FACTORY not between", value1, value2, "devFactory");
            return (Criteria) this;
        }

        public Criteria andDevModelIsNull() {
            addCriterion("DEV_MODEL is null");
            return (Criteria) this;
        }

        public Criteria andDevModelIsNotNull() {
            addCriterion("DEV_MODEL is not null");
            return (Criteria) this;
        }

        public Criteria andDevModelEqualTo(String value) {
            addCriterion("DEV_MODEL =", value, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelNotEqualTo(String value) {
            addCriterion("DEV_MODEL <>", value, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelGreaterThan(String value) {
            addCriterion("DEV_MODEL >", value, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_MODEL >=", value, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelLessThan(String value) {
            addCriterion("DEV_MODEL <", value, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelLessThanOrEqualTo(String value) {
            addCriterion("DEV_MODEL <=", value, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelLike(String value) {
            addCriterion("DEV_MODEL like", value, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelNotLike(String value) {
            addCriterion("DEV_MODEL not like", value, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelIn(List<String> values) {
            addCriterion("DEV_MODEL in", values, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelNotIn(List<String> values) {
            addCriterion("DEV_MODEL not in", values, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelBetween(String value1, String value2) {
            addCriterion("DEV_MODEL between", value1, value2, "devModel");
            return (Criteria) this;
        }

        public Criteria andDevModelNotBetween(String value1, String value2) {
            addCriterion("DEV_MODEL not between", value1, value2, "devModel");
            return (Criteria) this;
        }

        public Criteria andBandIsNull() {
            addCriterion("BAND is null");
            return (Criteria) this;
        }

        public Criteria andBandIsNotNull() {
            addCriterion("BAND is not null");
            return (Criteria) this;
        }

        public Criteria andBandEqualTo(String value) {
            addCriterion("BAND =", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandNotEqualTo(String value) {
            addCriterion("BAND <>", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandGreaterThan(String value) {
            addCriterion("BAND >", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandGreaterThanOrEqualTo(String value) {
            addCriterion("BAND >=", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandLessThan(String value) {
            addCriterion("BAND <", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandLessThanOrEqualTo(String value) {
            addCriterion("BAND <=", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandLike(String value) {
            addCriterion("BAND like", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandNotLike(String value) {
            addCriterion("BAND not like", value, "band");
            return (Criteria) this;
        }

        public Criteria andBandIn(List<String> values) {
            addCriterion("BAND in", values, "band");
            return (Criteria) this;
        }

        public Criteria andBandNotIn(List<String> values) {
            addCriterion("BAND not in", values, "band");
            return (Criteria) this;
        }

        public Criteria andBandBetween(String value1, String value2) {
            addCriterion("BAND between", value1, value2, "band");
            return (Criteria) this;
        }

        public Criteria andBandNotBetween(String value1, String value2) {
            addCriterion("BAND not between", value1, value2, "band");
            return (Criteria) this;
        }

        public Criteria andInsertionLossIsNull() {
            addCriterion("INSERTION_LOSS is null");
            return (Criteria) this;
        }

        public Criteria andInsertionLossIsNotNull() {
            addCriterion("INSERTION_LOSS is not null");
            return (Criteria) this;
        }

        public Criteria andInsertionLossEqualTo(String value) {
            addCriterion("INSERTION_LOSS =", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossNotEqualTo(String value) {
            addCriterion("INSERTION_LOSS <>", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossGreaterThan(String value) {
            addCriterion("INSERTION_LOSS >", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossGreaterThanOrEqualTo(String value) {
            addCriterion("INSERTION_LOSS >=", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossLessThan(String value) {
            addCriterion("INSERTION_LOSS <", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossLessThanOrEqualTo(String value) {
            addCriterion("INSERTION_LOSS <=", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossLike(String value) {
            addCriterion("INSERTION_LOSS like", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossNotLike(String value) {
            addCriterion("INSERTION_LOSS not like", value, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossIn(List<String> values) {
            addCriterion("INSERTION_LOSS in", values, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossNotIn(List<String> values) {
            addCriterion("INSERTION_LOSS not in", values, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossBetween(String value1, String value2) {
            addCriterion("INSERTION_LOSS between", value1, value2, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andInsertionLossNotBetween(String value1, String value2) {
            addCriterion("INSERTION_LOSS not between", value1, value2, "insertionLoss");
            return (Criteria) this;
        }

        public Criteria andDevTypeIsNull() {
            addCriterion("DEV_TYPE is null");
            return (Criteria) this;
        }

        public Criteria andDevTypeIsNotNull() {
            addCriterion("DEV_TYPE is not null");
            return (Criteria) this;
        }

        public Criteria andDevTypeEqualTo(String value) {
            addCriterion("DEV_TYPE =", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotEqualTo(String value) {
            addCriterion("DEV_TYPE <>", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeGreaterThan(String value) {
            addCriterion("DEV_TYPE >", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeGreaterThanOrEqualTo(String value) {
            addCriterion("DEV_TYPE >=", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeLessThan(String value) {
            addCriterion("DEV_TYPE <", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeLessThanOrEqualTo(String value) {
            addCriterion("DEV_TYPE <=", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeLike(String value) {
            addCriterion("DEV_TYPE like", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotLike(String value) {
            addCriterion("DEV_TYPE not like", value, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeIn(List<String> values) {
            addCriterion("DEV_TYPE in", values, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotIn(List<String> values) {
            addCriterion("DEV_TYPE not in", values, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeBetween(String value1, String value2) {
            addCriterion("DEV_TYPE between", value1, value2, "devType");
            return (Criteria) this;
        }

        public Criteria andDevTypeNotBetween(String value1, String value2) {
            addCriterion("DEV_TYPE not between", value1, value2, "devType");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyIsNull() {
            addCriterion("PB_EFFICIENCY is null");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyIsNotNull() {
            addCriterion("PB_EFFICIENCY is not null");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyEqualTo(String value) {
            addCriterion("PB_EFFICIENCY =", value, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyNotEqualTo(String value) {
            addCriterion("PB_EFFICIENCY <>", value, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyGreaterThan(String value) {
            addCriterion("PB_EFFICIENCY >", value, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyGreaterThanOrEqualTo(String value) {
            addCriterion("PB_EFFICIENCY >=", value, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyLessThan(String value) {
            addCriterion("PB_EFFICIENCY <", value, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyLessThanOrEqualTo(String value) {
            addCriterion("PB_EFFICIENCY <=", value, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyLike(String value) {
            addCriterion("PB_EFFICIENCY like", value, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyNotLike(String value) {
            addCriterion("PB_EFFICIENCY not like", value, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyIn(List<String> values) {
            addCriterion("PB_EFFICIENCY in", values, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyNotIn(List<String> values) {
            addCriterion("PB_EFFICIENCY not in", values, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyBetween(String value1, String value2) {
            addCriterion("PB_EFFICIENCY between", value1, value2, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andPbEfficiencyNotBetween(String value1, String value2) {
            addCriterion("PB_EFFICIENCY not between", value1, value2, "pbEfficiency");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareIsNull() {
            addCriterion("HAS_METAL_FIRMWARE is null");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareIsNotNull() {
            addCriterion("HAS_METAL_FIRMWARE is not null");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareEqualTo(String value) {
            addCriterion("HAS_METAL_FIRMWARE =", value, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareNotEqualTo(String value) {
            addCriterion("HAS_METAL_FIRMWARE <>", value, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareGreaterThan(String value) {
            addCriterion("HAS_METAL_FIRMWARE >", value, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareGreaterThanOrEqualTo(String value) {
            addCriterion("HAS_METAL_FIRMWARE >=", value, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareLessThan(String value) {
            addCriterion("HAS_METAL_FIRMWARE <", value, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareLessThanOrEqualTo(String value) {
            addCriterion("HAS_METAL_FIRMWARE <=", value, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareLike(String value) {
            addCriterion("HAS_METAL_FIRMWARE like", value, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareNotLike(String value) {
            addCriterion("HAS_METAL_FIRMWARE not like", value, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareIn(List<String> values) {
            addCriterion("HAS_METAL_FIRMWARE in", values, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareNotIn(List<String> values) {
            addCriterion("HAS_METAL_FIRMWARE not in", values, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareBetween(String value1, String value2) {
            addCriterion("HAS_METAL_FIRMWARE between", value1, value2, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andHasMetalFirmwareNotBetween(String value1, String value2) {
            addCriterion("HAS_METAL_FIRMWARE not between", value1, value2, "hasMetalFirmware");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumIsNull() {
            addCriterion("KTBDG_NUM is null");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumIsNotNull() {
            addCriterion("KTBDG_NUM is not null");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumEqualTo(Integer value) {
            addCriterion("KTBDG_NUM =", value, "ktbdgNum");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumNotEqualTo(Integer value) {
            addCriterion("KTBDG_NUM <>", value, "ktbdgNum");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumGreaterThan(Integer value) {
            addCriterion("KTBDG_NUM >", value, "ktbdgNum");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("KTBDG_NUM >=", value, "ktbdgNum");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumLessThan(Integer value) {
            addCriterion("KTBDG_NUM <", value, "ktbdgNum");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumLessThanOrEqualTo(Integer value) {
            addCriterion("KTBDG_NUM <=", value, "ktbdgNum");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumIn(List<Integer> values) {
            addCriterion("KTBDG_NUM in", values, "ktbdgNum");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumNotIn(List<Integer> values) {
            addCriterion("KTBDG_NUM not in", values, "ktbdgNum");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumBetween(Integer value1, Integer value2) {
            addCriterion("KTBDG_NUM between", value1, value2, "ktbdgNum");
            return (Criteria) this;
        }

        public Criteria andKtbdgNumNotBetween(Integer value1, Integer value2) {
            addCriterion("KTBDG_NUM not between", value1, value2, "ktbdgNum");
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

        public Criteria andDveNameIsNull() {
            addCriterion("DVE_NAME is null");
            return (Criteria) this;
        }

        public Criteria andDveNameIsNotNull() {
            addCriterion("DVE_NAME is not null");
            return (Criteria) this;
        }

        public Criteria andDveNameEqualTo(String value) {
            addCriterion("DVE_NAME =", value, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameNotEqualTo(String value) {
            addCriterion("DVE_NAME <>", value, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameGreaterThan(String value) {
            addCriterion("DVE_NAME >", value, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameGreaterThanOrEqualTo(String value) {
            addCriterion("DVE_NAME >=", value, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameLessThan(String value) {
            addCriterion("DVE_NAME <", value, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameLessThanOrEqualTo(String value) {
            addCriterion("DVE_NAME <=", value, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameLike(String value) {
            addCriterion("DVE_NAME like", value, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameNotLike(String value) {
            addCriterion("DVE_NAME not like", value, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameIn(List<String> values) {
            addCriterion("DVE_NAME in", values, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameNotIn(List<String> values) {
            addCriterion("DVE_NAME not in", values, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameBetween(String value1, String value2) {
            addCriterion("DVE_NAME between", value1, value2, "dveName");
            return (Criteria) this;
        }

        public Criteria andDveNameNotBetween(String value1, String value2) {
            addCriterion("DVE_NAME not between", value1, value2, "dveName");
            return (Criteria) this;
        }
    }

    /**
     * NT_PBS_DEVICE
     */
    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }
}