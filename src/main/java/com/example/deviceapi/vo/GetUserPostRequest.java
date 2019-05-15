package com.example.deviceapi.vo;

import javax.validation.constraints.NotBlank;

public class GetUserPostRequest {

    @NotBlank
    private String userNo; // 필수

    private String userName; // 옵션

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
