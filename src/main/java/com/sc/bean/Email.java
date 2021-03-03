package com.sc.bean;

import java.io.Serializable;
import java.util.Date;

public class Email implements Serializable {
    private Long id;

    private String send;//发送者

    private String title;

    private String msgcontent;

    private Long state;//状态

    private String accept;//接收者

    private Date msgCreateData;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSend() {
        return send;
    }

    public void setSend(String send) {
        this.send = send == null ? null : send.trim();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title == null ? null : title.trim();
    }

    public String getMsgcontent() {
        return msgcontent;
    }

    public void setMsgcontent(String msgcontent) {
        this.msgcontent = msgcontent == null ? null : msgcontent.trim();
    }

    public Long getState() {
        return state;
    }

    public void setState(Long state) {
        this.state = state;
    }

    public String getAccept() {
        return accept;
    }

    public void setAccept(String accept) {
        this.accept = accept == null ? null : accept.trim();
    }

    public Date getMsgCreateData() {
        return msgCreateData;
    }

    public void setMsgCreateData(Date msgCreateData) {
        this.msgCreateData = msgCreateData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", send=").append(send);
        sb.append(", title=").append(title);
        sb.append(", msgcontent=").append(msgcontent);
        sb.append(", state=").append(state);
        sb.append(", accept=").append(accept);
        sb.append(", msgCreateData=").append(msgCreateData);
        sb.append("]");
        return sb.toString();
    }
}