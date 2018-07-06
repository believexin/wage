package com.believexin.wage.pojo;

public class UserRight {
    private String cId;

    private String cUserid;

    private Byte nType;

    private String cRoleid;

    private String cRightkey;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcUserid() {
        return cUserid;
    }

    public void setcUserid(String cUserid) {
        this.cUserid = cUserid == null ? null : cUserid.trim();
    }

    public Byte getnType() {
        return nType;
    }

    public void setnType(Byte nType) {
        this.nType = nType;
    }

    public String getcRoleid() {
        return cRoleid;
    }

    public void setcRoleid(String cRoleid) {
        this.cRoleid = cRoleid == null ? null : cRoleid.trim();
    }

    public String getcRightkey() {
        return cRightkey;
    }

    public void setcRightkey(String cRightkey) {
        this.cRightkey = cRightkey == null ? null : cRightkey.trim();
    }
}