package com.cy.store.entity;

/*实体类的基类 Serizlizable进行序列化方便流传输*/

import javax.xml.crypto.Data;
import java.io.Serializable;
import java.util.Objects;


public class BaseEntity implements Serializable {
    private String createdUser;
    private String modifiedUser;
    private Data createdTime;
    private Data modifiedTime;

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

    public Data getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Data createdTime) {
        this.createdTime = createdTime;
    }

    public Data getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Data modifiedTime) {
        this.modifiedTime = modifiedTime;
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
