package com.wassi.camprandoapp.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Arun on 06-09-2015.
 */
public class UserModel implements Parcelable {
    public String userid;
    public String userName;
    public String userEmail;
    public String profilePic;
    public String userTel;


    public static final Creator<UserModel> CREATOR = new Creator<UserModel>() {

        @Override
        public UserModel createFromParcel(Parcel parcel) {
            return new UserModel(parcel);
        }

        @Override
        public UserModel[] newArray(int size) {
            return new UserModel[size];
        }
    };

    public UserModel() {

    }

    private UserModel(Parcel parcel) {
        userid=parcel.readString();
        userName = parcel.readString();
        userEmail = parcel.readString();
        profilePic = parcel.readString();
        userTel = parcel.readString();
    }


    @Override
    public void writeToParcel(Parcel parcel, int flag) {
        parcel.writeString(userid
        );
        parcel.writeString(userName);
        parcel.writeString(userEmail);
        parcel.writeString(profilePic);
        parcel.writeString(userTel);
    }

    @Override
    public int describeContents() {
        return 0;
    }
}
