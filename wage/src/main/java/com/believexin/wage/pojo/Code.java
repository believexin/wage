package com.believexin.wage.pojo;

public class Code extends CodeKey {
    private String cName;

    private Byte nKwh;

    private String cLevelinfo;

    private Byte nValid;

    private Short nOrder;

    private String cDmjp;

    public String getcName() {
        return cName;
    }

    public void setcName(String cName) {
        this.cName = cName == null ? null : cName.trim();
    }

    public Byte getnKwh() {
        return nKwh;
    }

    public void setnKwh(Byte nKwh) {
        this.nKwh = nKwh;
    }

    public String getcLevelinfo() {
        return cLevelinfo;
    }

    public void setcLevelinfo(String cLevelinfo) {
        this.cLevelinfo = cLevelinfo == null ? null : cLevelinfo.trim();
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

    public String getcDmjp() {
        return cDmjp;
    }

    public void setcDmjp(String cDmjp) {
        this.cDmjp = cDmjp == null ? null : cDmjp.trim();
    }
}