package com.believexin.wage.pojo;

public class Corp {
    private String cId;

    private String cName;

    private String cPid;

    private Byte nLevel;

    private String cGbm;

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

    public Byte getnLevel() {
        return nLevel;
    }

    public void setnLevel(Byte nLevel) {
        this.nLevel = nLevel;
    }

    public String getcGbm() {
        return cGbm;
    }

    public void setcGbm(String cGbm) {
        this.cGbm = cGbm == null ? null : cGbm.trim();
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