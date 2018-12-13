package com.wassi.camprandoapp.constants;

/**
 * Created by Arun on 06-09-2015.
 */
public class AppConstants {

    public enum SharedPreferenceKeys {
        USER_ID("userID"),
        USER_NAME("userName"),
        USER_EMAIL("userEmail"),
        USER_IMAGE_URL("userImageUrl"),
        USER_TEL("userTel");
        private String value;

        SharedPreferenceKeys(String value) {
            this.value = value;
        }

        public String getKey() {
            return value;
        }
    }

    public static final String GOOGLE_CLIENT_ID = "23827797825-vbv6a8da9rm0bpseevtpknakc14c32j4.apps.googleusercontent.com";
}
