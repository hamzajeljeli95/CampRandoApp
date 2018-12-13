package com.wassi.camprandoapp.Webservices.Users;

public class UsersWSBaseURI {

    public static String BASE_URL = "http://41.229.118.249:33830/userws";

    /**
     public static List<UserAdditionalInfos> getUserInfos(UserAdditionalInfos user)
     {
     return WsCommunicator.getObject(BASE_URL + "Users/get/",user,AppUser.class);
     return WsCommunicator.getListOfObjects(BASE_URL + "UAI/getAllByUser/", user,UserAdditionalInfos[].class);
     }
     */
}

