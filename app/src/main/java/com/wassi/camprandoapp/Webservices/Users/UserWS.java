package com.wassi.camprandoapp.Webservices.Users;


import com.wassi.camprandoapp.Beans.AppUser;
import com.wassi.camprandoapp.helpers.WsCommunicator;

public class UserWS {

    private static String methodURI = UsersWSBaseURI.BASE_URL + "/Users";

    public boolean login(AppUser body) {
        return WsCommunicator.getObject(methodURI + "/connect/", body, Boolean.class);
        //return userService.login(body.get("username"),body.get("passwordHash"));
    }

    public AppUser getUserInfos(AppUser body) {
        return WsCommunicator.getObject(methodURI + "/get/", body, AppUser.class);
        //return userService.getUserInfos(body.get("username"));
    }

    public boolean signup(AppUser body) {
        return WsCommunicator.getObject(methodURI + "/signup/", body, Boolean.class);
    }
}
