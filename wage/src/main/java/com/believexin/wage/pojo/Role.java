package com.believexin.wage.pojo;

public class Role {
    private String cId;

    private String cName;

    private String cDescript;

    private Byte nXtgy;

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

    public String getcDescript() {
        return cDescript;
    }

    public void setcDescript(String cDescript) {
        this.cDescript = cDescript == null ? null : cDescript.trim();
    }

    public Byte getnXtgy() {
        return nXtgy;
    }

    public void setnXtgy(Byte nXtgy) {
        this.nXtgy = nXtgy;
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