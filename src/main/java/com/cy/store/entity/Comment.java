package com.cy.store.entity;

;
import java.util.Date;

public class Comment extends BaseEntity {
    private Integer commentId;
    private Integer orderId;
    private Integer pId;
    private Integer uid;
    private String content;

    @Override
    public String toString() {
        return "Comment{" +
                "commentId=" + commentId +
                ", orderId=" + orderId +
                ", pId=" + pId +
                ", uid=" + uid +
                ", content='" + content + '\'' +
                ", username='" + username + '\'' +
                ", updatedTime=" + updatedTime +
                '}';
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String username;

    private Date updatedTime;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getpId() {
        return pId;
    }

    public void setpId(Integer pId) {
        this.pId = pId;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getUpdatedTime() {
        return updatedTime;
    }

    public void setUpdatedTime(Date updatedTime) {
        this.updatedTime = updatedTime;
    }
}
