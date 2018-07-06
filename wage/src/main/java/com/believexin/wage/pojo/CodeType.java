package com.believexin.wage.pojo;

public class CodeType {
    private String cId;

    private String cName;

    private Byte nValid;

    private Byte nSfkwh;

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

    public Byte getnValid() {
        return nValid;
    }

    public void setnValid(Byte nValid) {
        this.nValid = nValid;
    }

    public Byte getnSfkwh() {
        return nSfkwh;
    }

    public void setnSfkwh(Byte nSfkwh) {
        this.nSfkwh = nSfkwh;
    }
}