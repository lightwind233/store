package com.cy.store.entity;

/*实体类的基类 Serizlizable进行序列化方便流传输*/


import java.io.Serializable;
import java.util.Date;
import java.util.Objects;


public class BaseEntity implements Serializable {
    private String createdUser;
    private String modifiedUser;
    private Date createdTime;
    private Date modifiedTime;

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getCreatedTime() {
        return (Date) createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = (Date) createdTime;
    }

    public Date getModifiedTime() {
        return (Date) modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = (Date) modifiedTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseEntity that = (BaseEntity) o;
        return Objects.equals(createdUser, that.createdUser) && Objects.equals(modifiedUser, that.modifiedUser) && Objects.equals(createdTime, that.createdTime) && Objects.equals(modifiedTime, that.modifiedTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(createdUser, modifiedUser, createdTime, modifiedTime);
    }

    @Override
    public String toString() {
        return "BaseEntity{" +
                "createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", createdTime=" + createdTime +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}
