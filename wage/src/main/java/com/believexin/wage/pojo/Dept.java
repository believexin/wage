package com.believexin.wage.pojo;

public class Dept {
    private String cId;

    private String cName;

    private String cPid;

    private String cCorp;

    private String cAlias;

    private Byte nValid;

    private Short nOrder;

    public String getcId() {
        return cId;
    }

    public void setcId(String cId) {
        this.cId = cId == null ? null : cId.trim();
    }

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public String getcPid() {
        return cPid;
    }

    public void setcPid(String cPid) {
        this.cPid = cPid == null ? null : cPid.trim();
    }

    public String getcCorp() {
        return cCorp;
    }

    public void setcCorp(String cCorp) {
        this.cCorp = cCorp == null ? null : cCorp.trim();
    }

    public String getcAlias() {
        return cAlias;
    }

    public void setcAlias(String cAlias) {
        this.cAlias = cAlias == null ? null : cAlias.trim();
    }

    public Byte getnValid() {
        return nValid;
    }

    public void setnValid(Byte nValid) {
        this.nValid = nValid;
    }

    public Short getnOrder() {
        return nOrder;
    }

    public void setnOrder(Short nOrder) {
        this.nOrder = nOrder;
    }
}