package com.example.deviceapi.vo;

import javax.validation.constraints.NotBlank;

public class GetUserGetRequest {

    @NotBlank
    private String userNo;

    public String getUserNo() {
        return userNo;
    }

    public void setUserNo(String userNo) {
        this.userNo = userNo;
    }
}
