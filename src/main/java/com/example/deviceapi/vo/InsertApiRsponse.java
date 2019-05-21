package com.example.deviceapi.vo;

public class InsertApiRsponse {

    private String resultCode = "SUCCESS";
    private String resultMsg = "성공";

    public String getResultCode() {
        return resultCode;
    }

    public void setResultCode(String resultCode) {
        this.resultCode = resultCode;
    }

    public String getResultMsg() {
        return resultMsg;
    }

    public void setResultMsg(String resultMsg) {
        this.resultMsg = resultMsg;
    }
}
