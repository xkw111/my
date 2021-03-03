package com.sc.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EmailExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public EmailExample() {
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

        public Criteria andIdIsNull() {
            addCriterion("ID is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("ID is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Short value) {
            addCriterion("ID =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Short value) {
            addCriterion("ID <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Short value) {
            addCriterion("ID >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Short value) {
            addCriterion("ID >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Short value) {
            addCriterion("ID <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Short value) {
            addCriterion("ID <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Short> values) {
            addCriterion("ID in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Short> values) {
            addCriterion("ID not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Short value1, Short value2) {
            addCriterion("ID between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Short value1, Short value2) {
            addCriterion("ID not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andSendIsNull() {
            addCriterion("SEND is null");
            return (Criteria) this;
        }

        public Criteria andSendIsNotNull() {
            addCriterion("SEND is not null");
            return (Criteria) this;
        }

        public Criteria andSendEqualTo(String value) {
            addCriterion("SEND =", value, "send");
            return (Criteria) this;
        }

        public Criteria andSendNotEqualTo(String value) {
            addCriterion("SEND <>", value, "send");
            return (Criteria) this;
        }

        public Criteria andSendGreaterThan(String value) {
            addCriterion("SEND >", value, "send");
            return (Criteria) this;
        }

        public Criteria andSendGreaterThanOrEqualTo(String value) {
            addCriterion("SEND >=", value, "send");
            return (Criteria) this;
        }

        public Criteria andSendLessThan(String value) {
            addCriterion("SEND <", value, "send");
            return (Criteria) this;
        }

        public Criteria andSendLessThanOrEqualTo(String value) {
            addCriterion("SEND <=", value, "send");
            return (Criteria) this;
        }

        public Criteria andSendLike(String value) {
            addCriterion("SEND like", value, "send");
            return (Criteria) this;
        }

        public Criteria andSendNotLike(String value) {
            addCriterion("SEND not like", value, "send");
            return (Criteria) this;
        }

        public Criteria andSendIn(List<String> values) {
            addCriterion("SEND in", values, "send");
            return (Criteria) this;
        }

        public Criteria andSendNotIn(List<String> values) {
            addCriterion("SEND not in", values, "send");
            return (Criteria) this;
        }

        public Criteria andSendBetween(String value1, String value2) {
            addCriterion("SEND between", value1, value2, "send");
            return (Criteria) this;
        }

        public Criteria andSendNotBetween(String value1, String value2) {
            addCriterion("SEND not between", value1, value2, "send");
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

        public Criteria andMsgcontentIsNull() {
            addCriterion("MSGCONTENT is null");
            return (Criteria) this;
        }

        public Criteria andMsgcontentIsNotNull() {
            addCriterion("MSGCONTENT is not null");
            return (Criteria) this;
        }

        public Criteria andMsgcontentEqualTo(String value) {
            addCriterion("MSGCONTENT =", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotEqualTo(String value) {
            addCriterion("MSGCONTENT <>", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentGreaterThan(String value) {
            addCriterion("MSGCONTENT >", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentGreaterThanOrEqualTo(String value) {
            addCriterion("MSGCONTENT >=", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentLessThan(String value) {
            addCriterion("MSGCONTENT <", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentLessThanOrEqualTo(String value) {
            addCriterion("MSGCONTENT <=", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentLike(String value) {
            addCriterion("MSGCONTENT like", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotLike(String value) {
            addCriterion("MSGCONTENT not like", value, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentIn(List<String> values) {
            addCriterion("MSGCONTENT in", values, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotIn(List<String> values) {
            addCriterion("MSGCONTENT not in", values, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentBetween(String value1, String value2) {
            addCriterion("MSGCONTENT between", value1, value2, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andMsgcontentNotBetween(String value1, String value2) {
            addCriterion("MSGCONTENT not between", value1, value2, "msgcontent");
            return (Criteria) this;
        }

        public Criteria andStateIsNull() {
            addCriterion("STATE is null");
            return (Criteria) this;
        }

        public Criteria andStateIsNotNull() {
            addCriterion("STATE is not null");
            return (Criteria) this;
        }

        public Criteria andStateEqualTo(Short value) {
            addCriterion("STATE =", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotEqualTo(Short value) {
            addCriterion("STATE <>", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThan(Short value) {
            addCriterion("STATE >", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateGreaterThanOrEqualTo(Short value) {
            addCriterion("STATE >=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThan(Short value) {
            addCriterion("STATE <", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateLessThanOrEqualTo(Short value) {
            addCriterion("STATE <=", value, "state");
            return (Criteria) this;
        }

        public Criteria andStateIn(List<Short> values) {
            addCriterion("STATE in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotIn(List<Short> values) {
            addCriterion("STATE not in", values, "state");
            return (Criteria) this;
        }

        public Criteria andStateBetween(Short value1, Short value2) {
            addCriterion("STATE between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andStateNotBetween(Short value1, Short value2) {
            addCriterion("STATE not between", value1, value2, "state");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNull() {
            addCriterion("ACCEPT is null");
            return (Criteria) this;
        }

        public Criteria andAcceptIsNotNull() {
            addCriterion("ACCEPT is not null");
            return (Criteria) this;
        }

        public Criteria andAcceptEqualTo(String value) {
            addCriterion("ACCEPT =", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotEqualTo(String value) {
            addCriterion("ACCEPT <>", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThan(String value) {
            addCriterion("ACCEPT >", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptGreaterThanOrEqualTo(String value) {
            addCriterion("ACCEPT >=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThan(String value) {
            addCriterion("ACCEPT <", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLessThanOrEqualTo(String value) {
            addCriterion("ACCEPT <=", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptLike(String value) {
            addCriterion("ACCEPT like", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotLike(String value) {
            addCriterion("ACCEPT not like", value, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptIn(List<String> values) {
            addCriterion("ACCEPT in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotIn(List<String> values) {
            addCriterion("ACCEPT not in", values, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptBetween(String value1, String value2) {
            addCriterion("ACCEPT between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andAcceptNotBetween(String value1, String value2) {
            addCriterion("ACCEPT not between", value1, value2, "accept");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataIsNull() {
            addCriterion("MSG_CREATE_DATA is null");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataIsNotNull() {
            addCriterion("MSG_CREATE_DATA is not null");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataEqualTo(Date value) {
            addCriterion("MSG_CREATE_DATA =", value, "msgCreateData");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataNotEqualTo(Date value) {
            addCriterion("MSG_CREATE_DATA <>", value, "msgCreateData");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataGreaterThan(Date value) {
            addCriterion("MSG_CREATE_DATA >", value, "msgCreateData");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataGreaterThanOrEqualTo(Date value) {
            addCriterion("MSG_CREATE_DATA >=", value, "msgCreateData");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataLessThan(Date value) {
            addCriterion("MSG_CREATE_DATA <", value, "msgCreateData");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataLessThanOrEqualTo(Date value) {
            addCriterion("MSG_CREATE_DATA <=", value, "msgCreateData");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataIn(List<Date> values) {
            addCriterion("MSG_CREATE_DATA in", values, "msgCreateData");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataNotIn(List<Date> values) {
            addCriterion("MSG_CREATE_DATA not in", values, "msgCreateData");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataBetween(Date value1, Date value2) {
            addCriterion("MSG_CREATE_DATA between", value1, value2, "msgCreateData");
            return (Criteria) this;
        }

        public Criteria andMsgCreateDataNotBetween(Date value1, Date value2) {
            addCriterion("MSG_CREATE_DATA not between", value1, value2, "msgCreateData");
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