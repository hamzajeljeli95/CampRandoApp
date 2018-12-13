package com.wassi.camprandoapp.Beans;

import java.io.Serializable;
import java.util.Collection;

public class UserInfo implements Serializable {
    private int id;
    private String infoType;
    private Collection<UserAdditionalInfos> userAdditionalInfosById;

    public UserInfo() {
    }

    public UserInfo(int id, String infoType, Collection<UserAdditionalInfos> userAdditionalInfosById) {
        this.id = id;
        this.infoType = infoType;
        this.userAdditionalInfosById = userAdditionalInfosById;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getInfoType() {
        return infoType;
    }

    public void setInfoType(String infoType) {
        this.infoType = infoType;
    }

    public Collection<UserAdditionalInfos> getUserAdditionalInfosById() {
        return userAdditionalInfosById;
    }

    public void setUserAdditionalInfosById(Collection<UserAdditionalInfos> userAdditionalInfosById) {
        this.userAdditionalInfosById = userAdditionalInfosById;
    }
}
