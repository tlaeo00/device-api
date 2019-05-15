package com.example.deviceapi.vo;

import java.util.List;

public class GetUserPostResponse {

    private List<UserVo> userList;

    public GetUserPostResponse(List<UserVo> userList) {
        this.userList = userList;
    }

    public List<UserVo> getUserList() {
        return userList;
    }

    public void setUserList(List<UserVo> userList) {
        this.userList = userList;
    }
}
