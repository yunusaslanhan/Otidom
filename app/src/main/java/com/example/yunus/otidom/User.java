package com.example.yunus.otidom;

/**
 * Created by yunus on 23.05.2018.
 */

class User {

    private String userName;
    private String uId;

    public User() {
    }

    public User(String userName, String uId) {
        this.userName = userName;
        this.uId = uId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getuId() {
        return uId;
    }

    public void setuId(String uId) {
        this.uId = uId;
    }

}
