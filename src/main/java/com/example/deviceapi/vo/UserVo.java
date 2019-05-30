package com.example.deviceapi.vo;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo {

    private String cUno;
    private String cName;
    private String cDname;

    public UserVo() {
    }

    public UserVo(String cUno) {
        this.cUno = cUno;
    }

    public String getcUno() {
        return cUno;
    }

    public void setcUno(String cUno) {
        this.cUno = cUno;
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName;
    }

    public String getcDname() {
        return cDname;
    }

    public void setcDname(String cDname) {
        this.cDname = cDname;
    }
}
