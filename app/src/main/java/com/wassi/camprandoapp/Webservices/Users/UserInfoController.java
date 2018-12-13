package com.wassi.camprandoapp.Webservices.Users;

import com.wassi.camprandoapp.Beans.UserInfo;
import com.wassi.camprandoapp.helpers.WsCommunicator;

import java.util.List;

public class UserInfoController {

    private static String methodURI = UsersWSBaseURI.BASE_URL + "/UserInfos";

    public List<UserInfo> getAll() {
        return WsCommunicator.getListOfObjects(methodURI + "/getInfoTypes/", null, UserInfo[].class);
    }
}
