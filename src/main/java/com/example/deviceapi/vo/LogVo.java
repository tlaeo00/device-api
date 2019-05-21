package com.example.deviceapi.vo;

public class LogVo {

    private String cNo;
    private String cCcode;
    private String cUno;
    private String cPage;
    private String cUseyn;
    private String cCreate;
    private String cCuno;
    private String cUpdate;
    private String cUuno;
    private String cMcode;

    public LogVo() {
    }

    public LogVo(String cCcode, String cUno, String cPage) {
        this.cCcode = cCcode;
        this.cUno = cUno;
        this.cPage = cPage;
    }

    public String getcNo() {
        return cNo;
    }

    public void setcNo(String cNo) {
        this.cNo = cNo;
    }

    public String getcCcode() {
        return cCcode;
    }

    public void setcCcode(String cCcode) {
        this.cCcode = cCcode;
    }

    public String getcUno() {
        return cUno;
    }

    public void setcUno(String cUno) {
        this.cUno = cUno;
    }

    public String getcPage() {
        return cPage;
    }

    public void setcPage(String cPage) {
        this.cPage = cPage;
    }

    public String getcUseyn() {
        return cUseyn;
    }

    public void setcUseyn(String cUseyn) {
        this.cUseyn = cUseyn;
    }

    public String getcCreate() {
        return cCreate;
    }

    public void setcCreate(String cCreate) {
        this.cCreate = cCreate;
    }

    public String getcCuno() {
        return cCuno;
    }

    public void setcCuno(String cCuno) {
        this.cCuno = cCuno;
    }

    public String getcUpdate() {
        return cUpdate;
    }

    public void setcUpdate(String cUpdate) {
        this.cUpdate = cUpdate;
    }

    public String getcUuno() {
        return cUuno;
    }

    public void setcUuno(String cUuno) {
        this.cUuno = cUuno;
    }

    public String getcMcode() {
        return cMcode;
    }

    public void setcMcode(String cMcode) {
        this.cMcode = cMcode;
    }
}
