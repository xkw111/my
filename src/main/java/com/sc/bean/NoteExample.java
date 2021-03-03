package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class NoteExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NoteExample() {
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

        public Criteria andNidIsNull() {
            addCriterion("NID is null");
            return (Criteria) this;
        }

        public Criteria andNidIsNotNull() {
            addCriterion("NID is not null");
            return (Criteria) this;
        }

        public Criteria andNidEqualTo(Long value) {
            addCriterion("NID =", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotEqualTo(Long value) {
            addCriterion("NID <>", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThan(Long value) {
            addCriterion("NID >", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidGreaterThanOrEqualTo(Long value) {
            addCriterion("NID >=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThan(Long value) {
            addCriterion("NID <", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidLessThanOrEqualTo(Long value) {
            addCriterion("NID <=", value, "nid");
            return (Criteria) this;
        }

        public Criteria andNidIn(List<Long> values) {
            addCriterion("NID in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotIn(List<Long> values) {
            addCriterion("NID not in", values, "nid");
            return (Criteria) this;
        }

        public Criteria andNidBetween(Long value1, Long value2) {
            addCriterion("NID between", value1, value2, "nid");
            return (Criteria) this;
        }

        public Criteria andNidNotBetween(Long value1, Long value2) {
            addCriterion("NID not between", value1, value2, "nid");
            return (Criteria) this;
        }

        public Criteria andNcidIsNull() {
            addCriterion("NCID is null");
            return (Criteria) this;
        }

        public Criteria andNcidIsNotNull() {
            addCriterion("NCID is not null");
            return (Criteria) this;
        }

        public Criteria andNcidEqualTo(Long value) {
            addCriterion("NCID =", value, "ncid");
            return (Criteria) this;
        }

        public Criteria andNcidNotEqualTo(Long value) {
            addCriterion("NCID <>", value, "ncid");
            return (Criteria) this;
        }

        public Criteria andNcidGreaterThan(Long value) {
            addCriterion("NCID >", value, "ncid");
            return (Criteria) this;
        }

        public Criteria andNcidGreaterThanOrEqualTo(Long value) {
            addCriterion("NCID >=", value, "ncid");
            return (Criteria) this;
        }

        public Criteria andNcidLessThan(Long value) {
            addCriterion("NCID <", value, "ncid");
            return (Criteria) this;
        }

        public Criteria andNcidLessThanOrEqualTo(Long value) {
            addCriterion("NCID <=", value, "ncid");
            return (Criteria) this;
        }

        public Criteria andNcidIn(List<Long> values) {
            addCriterion("NCID in", values, "ncid");
            return (Criteria) this;
        }

        public Criteria andNcidNotIn(List<Long> values) {
            addCriterion("NCID not in", values, "ncid");
            return (Criteria) this;
        }

        public Criteria andNcidBetween(Long value1, Long value2) {
            addCriterion("NCID between", value1, value2, "ncid");
            return (Criteria) this;
        }

        public Criteria andNcidNotBetween(Long value1, Long value2) {
            addCriterion("NCID not between", value1, value2, "ncid");
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

        public Criteria andTitleIsNull() {
            addCriterion("TITLE is null");
            return (Criteria) this;
        }

        public Criteria andTitleIsNotNull() {
            addCriterion("TITLE is not null");
            return (Criteria) this;
        }

        public Criteria andTitleEqualTo(String value) {
            addCriterion("TITLE =", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotEqualTo(String value) {
            addCriterion("TITLE <>", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThan(String value) {
            addCriterion("TITLE >", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleGreaterThanOrEqualTo(String value) {
            addCriterion("TITLE >=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThan(String value) {
            addCriterion("TITLE <", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLessThanOrEqualTo(String value) {
            addCriterion("TITLE <=", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleLike(String value) {
            addCriterion("TITLE like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotLike(String value) {
            addCriterion("TITLE not like", value, "title");
            return (Criteria) this;
        }

        public Criteria andTitleIn(List<String> values) {
            addCriterion("TITLE in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotIn(List<String> values) {
            addCriterion("TITLE not in", values, "title");
            return (Criteria) this;
        }

        public Criteria andTitleBetween(String value1, String value2) {
            addCriterion("TITLE between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTitleNotBetween(String value1, String value2) {
            addCriterion("TITLE not between", value1, value2, "title");
            return (Criteria) this;
        }

        public Criteria andTextIsNull() {
            addCriterion("TEXT is null");
            return (Criteria) this;
        }

        public Criteria andTextIsNotNull() {
            addCriterion("TEXT is not null");
            return (Criteria) this;
        }

        public Criteria andTextEqualTo(String value) {
            addCriterion("TEXT =", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotEqualTo(String value) {
            addCriterion("TEXT <>", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThan(String value) {
            addCriterion("TEXT >", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextGreaterThanOrEqualTo(String value) {
            addCriterion("TEXT >=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThan(String value) {
            addCriterion("TEXT <", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLessThanOrEqualTo(String value) {
            addCriterion("TEXT <=", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextLike(String value) {
            addCriterion("TEXT like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotLike(String value) {
            addCriterion("TEXT not like", value, "text");
            return (Criteria) this;
        }

        public Criteria andTextIn(List<String> values) {
            addCriterion("TEXT in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotIn(List<String> values) {
            addCriterion("TEXT not in", values, "text");
            return (Criteria) this;
        }

        public Criteria andTextBetween(String value1, String value2) {
            addCriterion("TEXT between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andTextNotBetween(String value1, String value2) {
            addCriterion("TEXT not between", value1, value2, "text");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNull() {
            addCriterion("RELEASETIME is null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIsNotNull() {
            addCriterion("RELEASETIME is not null");
            return (Criteria) this;
        }

        public Criteria andReleasetimeEqualTo(Date value) {
            addCriterion("RELEASETIME =", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotEqualTo(Date value) {
            addCriterion("RELEASETIME <>", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThan(Date value) {
            addCriterion("RELEASETIME >", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeGreaterThanOrEqualTo(Date value) {
            addCriterion("RELEASETIME >=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThan(Date value) {
            addCriterion("RELEASETIME <", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeLessThanOrEqualTo(Date value) {
            addCriterion("RELEASETIME <=", value, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeIn(List<Date> values) {
            addCriterion("RELEASETIME in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotIn(List<Date> values) {
            addCriterion("RELEASETIME not in", values, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeBetween(Date value1, Date value2) {
            addCriterion("RELEASETIME between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andReleasetimeNotBetween(Date value1, Date value2) {
            addCriterion("RELEASETIME not between", value1, value2, "releasetime");
            return (Criteria) this;
        }

        public Criteria andSharesIsNull() {
            addCriterion("SHARES is null");
            return (Criteria) this;
        }

        public Criteria andSharesIsNotNull() {
            addCriterion("SHARES is not null");
            return (Criteria) this;
        }

        public Criteria andSharesEqualTo(String value) {
            addCriterion("SHARES =", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesNotEqualTo(String value) {
            addCriterion("SHARES <>", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesGreaterThan(String value) {
            addCriterion("SHARES >", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesGreaterThanOrEqualTo(String value) {
            addCriterion("SHARES >=", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesLessThan(String value) {
            addCriterion("SHARES <", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesLessThanOrEqualTo(String value) {
            addCriterion("SHARES <=", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesLike(String value) {
            addCriterion("SHARES like", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesNotLike(String value) {
            addCriterion("SHARES not like", value, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesIn(List<String> values) {
            addCriterion("SHARES in", values, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesNotIn(List<String> values) {
            addCriterion("SHARES not in", values, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesBetween(String value1, String value2) {
            addCriterion("SHARES between", value1, value2, "shares");
            return (Criteria) this;
        }

        public Criteria andSharesNotBetween(String value1, String value2) {
            addCriterion("SHARES not between", value1, value2, "shares");
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