package com.boot.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class DeviceAlarmInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public DeviceAlarmInfoExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andPkidIsNull() {
            addCriterion("pkId is null");
            return (Criteria) this;
        }

        public Criteria andPkidIsNotNull() {
            addCriterion("pkId is not null");
            return (Criteria) this;
        }

        public Criteria andPkidEqualTo(Long value) {
            addCriterion("pkId =", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotEqualTo(Long value) {
            addCriterion("pkId <>", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidGreaterThan(Long value) {
            addCriterion("pkId >", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidGreaterThanOrEqualTo(Long value) {
            addCriterion("pkId >=", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidLessThan(Long value) {
            addCriterion("pkId <", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidLessThanOrEqualTo(Long value) {
            addCriterion("pkId <=", value, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidIn(List<Long> values) {
            addCriterion("pkId in", values, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotIn(List<Long> values) {
            addCriterion("pkId not in", values, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidBetween(Long value1, Long value2) {
            addCriterion("pkId between", value1, value2, "pkid");
            return (Criteria) this;
        }

        public Criteria andPkidNotBetween(Long value1, Long value2) {
            addCriterion("pkId not between", value1, value2, "pkid");
            return (Criteria) this;
        }

        public Criteria andTreekeyIsNull() {
            addCriterion("treeKey is null");
            return (Criteria) this;
        }

        public Criteria andTreekeyIsNotNull() {
            addCriterion("treeKey is not null");
            return (Criteria) this;
        }

        public Criteria andTreekeyEqualTo(String value) {
            addCriterion("treeKey =", value, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyNotEqualTo(String value) {
            addCriterion("treeKey <>", value, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyGreaterThan(String value) {
            addCriterion("treeKey >", value, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyGreaterThanOrEqualTo(String value) {
            addCriterion("treeKey >=", value, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyLessThan(String value) {
            addCriterion("treeKey <", value, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyLessThanOrEqualTo(String value) {
            addCriterion("treeKey <=", value, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyLike(String value) {
            addCriterion("treeKey like", value, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyNotLike(String value) {
            addCriterion("treeKey not like", value, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyIn(List<String> values) {
            addCriterion("treeKey in", values, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyNotIn(List<String> values) {
            addCriterion("treeKey not in", values, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyBetween(String value1, String value2) {
            addCriterion("treeKey between", value1, value2, "treekey");
            return (Criteria) this;
        }

        public Criteria andTreekeyNotBetween(String value1, String value2) {
            addCriterion("treeKey not between", value1, value2, "treekey");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNull() {
            addCriterion("deviceId is null");
            return (Criteria) this;
        }

        public Criteria andDeviceidIsNotNull() {
            addCriterion("deviceId is not null");
            return (Criteria) this;
        }

        public Criteria andDeviceidEqualTo(Long value) {
            addCriterion("deviceId =", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotEqualTo(Long value) {
            addCriterion("deviceId <>", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThan(Long value) {
            addCriterion("deviceId >", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidGreaterThanOrEqualTo(Long value) {
            addCriterion("deviceId >=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThan(Long value) {
            addCriterion("deviceId <", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidLessThanOrEqualTo(Long value) {
            addCriterion("deviceId <=", value, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidIn(List<Long> values) {
            addCriterion("deviceId in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotIn(List<Long> values) {
            addCriterion("deviceId not in", values, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidBetween(Long value1, Long value2) {
            addCriterion("deviceId between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andDeviceidNotBetween(Long value1, Long value2) {
            addCriterion("deviceId not between", value1, value2, "deviceid");
            return (Criteria) this;
        }

        public Criteria andRuleidIsNull() {
            addCriterion("ruleId is null");
            return (Criteria) this;
        }

        public Criteria andRuleidIsNotNull() {
            addCriterion("ruleId is not null");
            return (Criteria) this;
        }

        public Criteria andRuleidEqualTo(String value) {
            addCriterion("ruleId =", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotEqualTo(String value) {
            addCriterion("ruleId <>", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidGreaterThan(String value) {
            addCriterion("ruleId >", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidGreaterThanOrEqualTo(String value) {
            addCriterion("ruleId >=", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidLessThan(String value) {
            addCriterion("ruleId <", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidLessThanOrEqualTo(String value) {
            addCriterion("ruleId <=", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidLike(String value) {
            addCriterion("ruleId like", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotLike(String value) {
            addCriterion("ruleId not like", value, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidIn(List<String> values) {
            addCriterion("ruleId in", values, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotIn(List<String> values) {
            addCriterion("ruleId not in", values, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidBetween(String value1, String value2) {
            addCriterion("ruleId between", value1, value2, "ruleid");
            return (Criteria) this;
        }

        public Criteria andRuleidNotBetween(String value1, String value2) {
            addCriterion("ruleId not between", value1, value2, "ruleid");
            return (Criteria) this;
        }

        public Criteria andTypeIsNull() {
            addCriterion("type is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("type is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(String value) {
            addCriterion("type =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(String value) {
            addCriterion("type <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(String value) {
            addCriterion("type >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(String value) {
            addCriterion("type >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(String value) {
            addCriterion("type <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(String value) {
            addCriterion("type <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLike(String value) {
            addCriterion("type like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotLike(String value) {
            addCriterion("type not like", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<String> values) {
            addCriterion("type in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<String> values) {
            addCriterion("type not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(String value1, String value2) {
            addCriterion("type between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(String value1, String value2) {
            addCriterion("type not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andModeIsNull() {
            addCriterion("mode is null");
            return (Criteria) this;
        }

        public Criteria andModeIsNotNull() {
            addCriterion("mode is not null");
            return (Criteria) this;
        }

        public Criteria andModeEqualTo(String value) {
            addCriterion("mode =", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotEqualTo(String value) {
            addCriterion("mode <>", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThan(String value) {
            addCriterion("mode >", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeGreaterThanOrEqualTo(String value) {
            addCriterion("mode >=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThan(String value) {
            addCriterion("mode <", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLessThanOrEqualTo(String value) {
            addCriterion("mode <=", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeLike(String value) {
            addCriterion("mode like", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotLike(String value) {
            addCriterion("mode not like", value, "mode");
            return (Criteria) this;
        }

        public Criteria andModeIn(List<String> values) {
            addCriterion("mode in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotIn(List<String> values) {
            addCriterion("mode not in", values, "mode");
            return (Criteria) this;
        }

        public Criteria andModeBetween(String value1, String value2) {
            addCriterion("mode between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andModeNotBetween(String value1, String value2) {
            addCriterion("mode not between", value1, value2, "mode");
            return (Criteria) this;
        }

        public Criteria andNameIsNull() {
            addCriterion("name is null");
            return (Criteria) this;
        }

        public Criteria andNameIsNotNull() {
            addCriterion("name is not null");
            return (Criteria) this;
        }

        public Criteria andNameEqualTo(String value) {
            addCriterion("name =", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotEqualTo(String value) {
            addCriterion("name <>", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThan(String value) {
            addCriterion("name >", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameGreaterThanOrEqualTo(String value) {
            addCriterion("name >=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThan(String value) {
            addCriterion("name <", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLessThanOrEqualTo(String value) {
            addCriterion("name <=", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameLike(String value) {
            addCriterion("name like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotLike(String value) {
            addCriterion("name not like", value, "name");
            return (Criteria) this;
        }

        public Criteria andNameIn(List<String> values) {
            addCriterion("name in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotIn(List<String> values) {
            addCriterion("name not in", values, "name");
            return (Criteria) this;
        }

        public Criteria andNameBetween(String value1, String value2) {
            addCriterion("name between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andNameNotBetween(String value1, String value2) {
            addCriterion("name not between", value1, value2, "name");
            return (Criteria) this;
        }

        public Criteria andHtimeIsNull() {
            addCriterion("hTime is null");
            return (Criteria) this;
        }

        public Criteria andHtimeIsNotNull() {
            addCriterion("hTime is not null");
            return (Criteria) this;
        }

        public Criteria andHtimeEqualTo(Integer value) {
            addCriterion("hTime =", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeNotEqualTo(Integer value) {
            addCriterion("hTime <>", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeGreaterThan(Integer value) {
            addCriterion("hTime >", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeGreaterThanOrEqualTo(Integer value) {
            addCriterion("hTime >=", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeLessThan(Integer value) {
            addCriterion("hTime <", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeLessThanOrEqualTo(Integer value) {
            addCriterion("hTime <=", value, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeIn(List<Integer> values) {
            addCriterion("hTime in", values, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeNotIn(List<Integer> values) {
            addCriterion("hTime not in", values, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeBetween(Integer value1, Integer value2) {
            addCriterion("hTime between", value1, value2, "htime");
            return (Criteria) this;
        }

        public Criteria andHtimeNotBetween(Integer value1, Integer value2) {
            addCriterion("hTime not between", value1, value2, "htime");
            return (Criteria) this;
        }

        public Criteria andCrtPsnIsNull() {
            addCriterion("Crt_Psn is null");
            return (Criteria) this;
        }

        public Criteria andCrtPsnIsNotNull() {
            addCriterion("Crt_Psn is not null");
            return (Criteria) this;
        }

        public Criteria andCrtPsnEqualTo(String value) {
            addCriterion("Crt_Psn =", value, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnNotEqualTo(String value) {
            addCriterion("Crt_Psn <>", value, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnGreaterThan(String value) {
            addCriterion("Crt_Psn >", value, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnGreaterThanOrEqualTo(String value) {
            addCriterion("Crt_Psn >=", value, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnLessThan(String value) {
            addCriterion("Crt_Psn <", value, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnLessThanOrEqualTo(String value) {
            addCriterion("Crt_Psn <=", value, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnLike(String value) {
            addCriterion("Crt_Psn like", value, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnNotLike(String value) {
            addCriterion("Crt_Psn not like", value, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnIn(List<String> values) {
            addCriterion("Crt_Psn in", values, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnNotIn(List<String> values) {
            addCriterion("Crt_Psn not in", values, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnBetween(String value1, String value2) {
            addCriterion("Crt_Psn between", value1, value2, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtPsnNotBetween(String value1, String value2) {
            addCriterion("Crt_Psn not between", value1, value2, "crtPsn");
            return (Criteria) this;
        }

        public Criteria andCrtTmIsNull() {
            addCriterion("Crt_Tm is null");
            return (Criteria) this;
        }

        public Criteria andCrtTmIsNotNull() {
            addCriterion("Crt_Tm is not null");
            return (Criteria) this;
        }

        public Criteria andCrtTmEqualTo(Date value) {
            addCriterion("Crt_Tm =", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmNotEqualTo(Date value) {
            addCriterion("Crt_Tm <>", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmGreaterThan(Date value) {
            addCriterion("Crt_Tm >", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmGreaterThanOrEqualTo(Date value) {
            addCriterion("Crt_Tm >=", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmLessThan(Date value) {
            addCriterion("Crt_Tm <", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmLessThanOrEqualTo(Date value) {
            addCriterion("Crt_Tm <=", value, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmIn(List<Date> values) {
            addCriterion("Crt_Tm in", values, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmNotIn(List<Date> values) {
            addCriterion("Crt_Tm not in", values, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmBetween(Date value1, Date value2) {
            addCriterion("Crt_Tm between", value1, value2, "crtTm");
            return (Criteria) this;
        }

        public Criteria andCrtTmNotBetween(Date value1, Date value2) {
            addCriterion("Crt_Tm not between", value1, value2, "crtTm");
            return (Criteria) this;
        }

        public Criteria andUdtPsnIsNull() {
            addCriterion("Udt_Psn is null");
            return (Criteria) this;
        }

        public Criteria andUdtPsnIsNotNull() {
            addCriterion("Udt_Psn is not null");
            return (Criteria) this;
        }

        public Criteria andUdtPsnEqualTo(String value) {
            addCriterion("Udt_Psn =", value, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnNotEqualTo(String value) {
            addCriterion("Udt_Psn <>", value, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnGreaterThan(String value) {
            addCriterion("Udt_Psn >", value, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnGreaterThanOrEqualTo(String value) {
            addCriterion("Udt_Psn >=", value, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnLessThan(String value) {
            addCriterion("Udt_Psn <", value, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnLessThanOrEqualTo(String value) {
            addCriterion("Udt_Psn <=", value, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnLike(String value) {
            addCriterion("Udt_Psn like", value, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnNotLike(String value) {
            addCriterion("Udt_Psn not like", value, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnIn(List<String> values) {
            addCriterion("Udt_Psn in", values, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnNotIn(List<String> values) {
            addCriterion("Udt_Psn not in", values, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnBetween(String value1, String value2) {
            addCriterion("Udt_Psn between", value1, value2, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtPsnNotBetween(String value1, String value2) {
            addCriterion("Udt_Psn not between", value1, value2, "udtPsn");
            return (Criteria) this;
        }

        public Criteria andUdtTmIsNull() {
            addCriterion("Udt_Tm is null");
            return (Criteria) this;
        }

        public Criteria andUdtTmIsNotNull() {
            addCriterion("Udt_Tm is not null");
            return (Criteria) this;
        }

        public Criteria andUdtTmEqualTo(Date value) {
            addCriterion("Udt_Tm =", value, "udtTm");
            return (Criteria) this;
        }

        public Criteria andUdtTmNotEqualTo(Date value) {
            addCriterion("Udt_Tm <>", value, "udtTm");
            return (Criteria) this;
        }

        public Criteria andUdtTmGreaterThan(Date value) {
            addCriterion("Udt_Tm >", value, "udtTm");
            return (Criteria) this;
        }

        public Criteria andUdtTmGreaterThanOrEqualTo(Date value) {
            addCriterion("Udt_Tm >=", value, "udtTm");
            return (Criteria) this;
        }

        public Criteria andUdtTmLessThan(Date value) {
            addCriterion("Udt_Tm <", value, "udtTm");
            return (Criteria) this;
        }

        public Criteria andUdtTmLessThanOrEqualTo(Date value) {
            addCriterion("Udt_Tm <=", value, "udtTm");
            return (Criteria) this;
        }

        public Criteria andUdtTmIn(List<Date> values) {
            addCriterion("Udt_Tm in", values, "udtTm");
            return (Criteria) this;
        }

        public Criteria andUdtTmNotIn(List<Date> values) {
            addCriterion("Udt_Tm not in", values, "udtTm");
            return (Criteria) this;
        }

        public Criteria andUdtTmBetween(Date value1, Date value2) {
            addCriterion("Udt_Tm between", value1, value2, "udtTm");
            return (Criteria) this;
        }

        public Criteria andUdtTmNotBetween(Date value1, Date value2) {
            addCriterion("Udt_Tm not between", value1, value2, "udtTm");
            return (Criteria) this;
        }

        public Criteria andDelIdrIsNull() {
            addCriterion("Del_Idr is null");
            return (Criteria) this;
        }

        public Criteria andDelIdrIsNotNull() {
            addCriterion("Del_Idr is not null");
            return (Criteria) this;
        }

        public Criteria andDelIdrEqualTo(String value) {
            addCriterion("Del_Idr =", value, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrNotEqualTo(String value) {
            addCriterion("Del_Idr <>", value, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrGreaterThan(String value) {
            addCriterion("Del_Idr >", value, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrGreaterThanOrEqualTo(String value) {
            addCriterion("Del_Idr >=", value, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrLessThan(String value) {
            addCriterion("Del_Idr <", value, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrLessThanOrEqualTo(String value) {
            addCriterion("Del_Idr <=", value, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrLike(String value) {
            addCriterion("Del_Idr like", value, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrNotLike(String value) {
            addCriterion("Del_Idr not like", value, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrIn(List<String> values) {
            addCriterion("Del_Idr in", values, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrNotIn(List<String> values) {
            addCriterion("Del_Idr not in", values, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrBetween(String value1, String value2) {
            addCriterion("Del_Idr between", value1, value2, "delIdr");
            return (Criteria) this;
        }

        public Criteria andDelIdrNotBetween(String value1, String value2) {
            addCriterion("Del_Idr not between", value1, value2, "delIdr");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}