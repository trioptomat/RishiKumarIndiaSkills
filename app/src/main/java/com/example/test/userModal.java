package com.example.test;

public class userModal {

    private String userEmail,userPassword,userFname,userLname,userDOB;

    public userModal(String userEmail, String userPassword, String userFname, String userLname, String userDOB) {
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.userFname = userFname;
        this.userLname = userLname;
        this.userDOB = userDOB;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword;
    }

    public String getUserFname() {
        return userFname;
    }

    public void setUserFname(String userFname) {
        this.userFname = userFname;
    }

    public String getUserLname() {
        return userLname;
    }

    public void setUserLname(String userLname) {
        this.userLname = userLname;
    }

    public String getUserDOB() {
        return userDOB;
    }

    public void setUserDOB(String userDOB) {
        this.userDOB = userDOB;
    }
}
