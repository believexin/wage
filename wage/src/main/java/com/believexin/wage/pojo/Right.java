package com.believexin.wage.pojo;

public class Right {
    private String cRightkey;

    private String cName;

    private String cDescript;

    private Integer nOrder;

    public String getcRightkey() {
        return cRightkey;
    }

    public void setcRightkey(String cRightkey) {
        this.cRightkey = cRightkey == null ? null : cRightkey.trim();
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

    public Integer getnOrder() {
        return nOrder;
    }

    public void setnOrder(Integer nOrder) {
        this.nOrder = nOrder;
    }
}