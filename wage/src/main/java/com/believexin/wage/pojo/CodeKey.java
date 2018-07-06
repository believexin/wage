package com.believexin.wage.pojo;

public class CodeKey {
    private String cPid;

    private String cCode;

    public String getcPid() {
        return cPid;
    }

    public void setcPid(String cPid) {
        this.cPid = cPid == null ? null : cPid.trim();
    }

    public String getcCode() {
        return cCode;
    }

    public void setcCode(String cCode) {
        this.cCode = cCode == null ? null : cCode.trim();
    }
}