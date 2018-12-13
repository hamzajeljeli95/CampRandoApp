package com.wassi.camprandoapp.Beans;

import java.io.Serializable;

public class UserAdditionalInfos implements Serializable {
    private int id;
    private String userId;
    private int infoId;
    private String infoContent;
    private AppUser appUserByUserId;
    private UserInfo userInfoByInfoId;

    @Override
    public String toString() {
        return "UserAdditionalInfos{" +
                "id=" + id +
                ", userId='" + userId + '\'' +
                ", infoId=" + infoId +
                ", infoContent='" + infoContent + '\'' +
                '}';
    }

    public UserAdditionalInfos() {
    }

    public UserAdditionalInfos(int id, String userId, int infoId, String infoContent, AppUser appUserByUserId, UserInfo userInfoByInfoId) {
        this.id = id;
        this.userId = userId;
        this.infoId = infoId;
        this.infoContent = infoContent;
        this.appUserByUserId = appUserByUserId;
        this.userInfoByInfoId = userInfoByInfoId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getInfoId() {
        return infoId;
    }

    public void setInfoId(int infoId) {
        this.infoId = infoId;
    }

    public String getInfoContent() {
        return infoContent;
    }

    public void setInfoContent(String infoContent) {
        this.infoContent = infoContent;
    }

    public AppUser getAppUserByUserId() {
        return appUserByUserId;
    }

    public void setAppUserByUserId(AppUser appUserByUserId) {
        this.appUserByUserId = appUserByUserId;
    }

    public UserInfo getUserInfoByInfoId() {
        return userInfoByInfoId;
    }

    public void setUserInfoByInfoId(UserInfo userInfoByInfoId) {
        this.userInfoByInfoId = userInfoByInfoId;
    }
}
