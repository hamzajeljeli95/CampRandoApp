package com.wassi.camprandoapp.Webservices.Users;

import com.wassi.camprandoapp.Beans.UserAdditionalInfos;
import com.wassi.camprandoapp.helpers.WsCommunicator;

import java.util.List;

public class UserAdditionalInfosWS {

    private static String methodURI = UsersWSBaseURI.BASE_URL + "/UAI";

    public UserAdditionalInfos getAdditionalInfo(UserAdditionalInfos body) {
        return WsCommunicator.getObject(methodURI + "/get/", body, UserAdditionalInfos.class);
        //return infosService.getAdditionalInfo(Integer.parseInt(body.get("infoId")),body.get("userId"));
    }

    public List<UserAdditionalInfos> getUserAdditionalInfos(UserAdditionalInfos body) {
        return WsCommunicator.getListOfObjects(methodURI + "/getAllByUser/", body, UserAdditionalInfos[].class);
        //return infosService.getUserAdditionalInfos(body.get("userId"));
    }

    public boolean setUserAdditionalInfo(UserAdditionalInfos body) {
        return WsCommunicator.getObject(methodURI + "/set/", body, Boolean.class);
        //return infosService.setUserAdditionalInfo(Integer.parseInt(body.get("infoId")),body.get("userId"),body.get("content"));
    }
}
