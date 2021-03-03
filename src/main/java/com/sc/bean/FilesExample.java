package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class FilesExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FilesExample() {
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

        public Criteria andFidIsNull() {
            addCriterion("FID is null");
            return (Criteria) this;
        }

        public Criteria andFidIsNotNull() {
            addCriterion("FID is not null");
            return (Criteria) this;
        }

        public Criteria andFidEqualTo(Long value) {
            addCriterion("FID =", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotEqualTo(Long value) {
            addCriterion("FID <>", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThan(Long value) {
            addCriterion("FID >", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidGreaterThanOrEqualTo(Long value) {
            addCriterion("FID >=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThan(Long value) {
            addCriterion("FID <", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidLessThanOrEqualTo(Long value) {
            addCriterion("FID <=", value, "fid");
            return (Criteria) this;
        }

        public Criteria andFidIn(List<Long> values) {
            addCriterion("FID in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotIn(List<Long> values) {
            addCriterion("FID not in", values, "fid");
            return (Criteria) this;
        }

        public Criteria andFidBetween(Long value1, Long value2) {
            addCriterion("FID between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andFidNotBetween(Long value1, Long value2) {
            addCriterion("FID not between", value1, value2, "fid");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNull() {
            addCriterion("ADMINID is null");
            return (Criteria) this;
        }

        public Criteria andAdminidIsNotNull() {
            addCriterion("ADMINID is not null");
            return (Criteria) this;
        }

        public Criteria andAdminidEqualTo(Long value) {
            addCriterion("ADMINID =", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotEqualTo(Long value) {
            addCriterion("ADMINID <>", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThan(Long value) {
            addCriterion("ADMINID >", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidGreaterThanOrEqualTo(Long value) {
            addCriterion("ADMINID >=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThan(Long value) {
            addCriterion("ADMINID <", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidLessThanOrEqualTo(Long value) {
            addCriterion("ADMINID <=", value, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidIn(List<Long> values) {
            addCriterion("ADMINID in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotIn(List<Long> values) {
            addCriterion("ADMINID not in", values, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidBetween(Long value1, Long value2) {
            addCriterion("ADMINID between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andAdminidNotBetween(Long value1, Long value2) {
            addCriterion("ADMINID not between", value1, value2, "adminid");
            return (Criteria) this;
        }

        public Criteria andFnameIsNull() {
            addCriterion("FNAME is null");
            return (Criteria) this;
        }

        public Criteria andFnameIsNotNull() {
            addCriterion("FNAME is not null");
            return (Criteria) this;
        }

        public Criteria andFnameEqualTo(String value) {
            addCriterion("FNAME =", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotEqualTo(String value) {
            addCriterion("FNAME <>", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThan(String value) {
            addCriterion("FNAME >", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameGreaterThanOrEqualTo(String value) {
            addCriterion("FNAME >=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThan(String value) {
            addCriterion("FNAME <", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLessThanOrEqualTo(String value) {
            addCriterion("FNAME <=", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameLike(String value) {
            addCriterion("FNAME like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotLike(String value) {
            addCriterion("FNAME not like", value, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameIn(List<String> values) {
            addCriterion("FNAME in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotIn(List<String> values) {
            addCriterion("FNAME not in", values, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameBetween(String value1, String value2) {
            addCriterion("FNAME between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFnameNotBetween(String value1, String value2) {
            addCriterion("FNAME not between", value1, value2, "fname");
            return (Criteria) this;
        }

        public Criteria andFurlIsNull() {
            addCriterion("FURL is null");
            return (Criteria) this;
        }

        public Criteria andFurlIsNotNull() {
            addCriterion("FURL is not null");
            return (Criteria) this;
        }

        public Criteria andFurlEqualTo(String value) {
            addCriterion("FURL =", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotEqualTo(String value) {
            addCriterion("FURL <>", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlGreaterThan(String value) {
            addCriterion("FURL >", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlGreaterThanOrEqualTo(String value) {
            addCriterion("FURL >=", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlLessThan(String value) {
            addCriterion("FURL <", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlLessThanOrEqualTo(String value) {
            addCriterion("FURL <=", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlLike(String value) {
            addCriterion("FURL like", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotLike(String value) {
            addCriterion("FURL not like", value, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlIn(List<String> values) {
            addCriterion("FURL in", values, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotIn(List<String> values) {
            addCriterion("FURL not in", values, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlBetween(String value1, String value2) {
            addCriterion("FURL between", value1, value2, "furl");
            return (Criteria) this;
        }

        public Criteria andFurlNotBetween(String value1, String value2) {
            addCriterion("FURL not between", value1, value2, "furl");
            return (Criteria) this;
        }

        public Criteria andFsharesIsNull() {
            addCriterion("FSHARES is null");
            return (Criteria) this;
        }

        public Criteria andFsharesIsNotNull() {
            addCriterion("FSHARES is not null");
            return (Criteria) this;
        }

        public Criteria andFsharesEqualTo(String value) {
            addCriterion("FSHARES =", value, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesNotEqualTo(String value) {
            addCriterion("FSHARES <>", value, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesGreaterThan(String value) {
            addCriterion("FSHARES >", value, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesGreaterThanOrEqualTo(String value) {
            addCriterion("FSHARES >=", value, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesLessThan(String value) {
            addCriterion("FSHARES <", value, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesLessThanOrEqualTo(String value) {
            addCriterion("FSHARES <=", value, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesLike(String value) {
            addCriterion("FSHARES like", value, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesNotLike(String value) {
            addCriterion("FSHARES not like", value, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesIn(List<String> values) {
            addCriterion("FSHARES in", values, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesNotIn(List<String> values) {
            addCriterion("FSHARES not in", values, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesBetween(String value1, String value2) {
            addCriterion("FSHARES between", value1, value2, "fshares");
            return (Criteria) this;
        }

        public Criteria andFsharesNotBetween(String value1, String value2) {
            addCriterion("FSHARES not between", value1, value2, "fshares");
            return (Criteria) this;
        }

        public Criteria andFtimeIsNull() {
            addCriterion("FTIME is null");
            return (Criteria) this;
        }

        public Criteria andFtimeIsNotNull() {
            addCriterion("FTIME is not null");
            return (Criteria) this;
        }

        public Criteria andFtimeEqualTo(Date value) {
            addCriterion("FTIME =", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeNotEqualTo(Date value) {
            addCriterion("FTIME <>", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeGreaterThan(Date value) {
            addCriterion("FTIME >", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("FTIME >=", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeLessThan(Date value) {
            addCriterion("FTIME <", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeLessThanOrEqualTo(Date value) {
            addCriterion("FTIME <=", value, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeIn(List<Date> values) {
            addCriterion("FTIME in", values, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeNotIn(List<Date> values) {
            addCriterion("FTIME not in", values, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeBetween(Date value1, Date value2) {
            addCriterion("FTIME between", value1, value2, "ftime");
            return (Criteria) this;
        }

        public Criteria andFtimeNotBetween(Date value1, Date value2) {
            addCriterion("FTIME not between", value1, value2, "ftime");
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