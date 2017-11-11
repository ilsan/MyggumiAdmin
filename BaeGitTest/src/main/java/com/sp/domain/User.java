package com.sp.domain;

public class User {

    private String USR_LGN;
    private String USR_NM;
    private String USR_EML;
    private String USR_TEL;
    private String CRT_DT;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("User{");
        sb.append("USR_LGN='").append(USR_LGN).append('\'');
        sb.append(", USR_NM='").append(USR_NM).append('\'');
        sb.append(", USR_EML='").append(USR_EML).append('\'');
        sb.append(", USR_TEL='").append(USR_TEL).append('\'');
        sb.append(", CRT_DT='").append(CRT_DT).append('\'');
        sb.append('}');
        return sb.toString();
    }

    public String getUSR_LGN() {
        return USR_LGN;
    }

    public void setUSR_LGN(String USR_LGN) {
        this.USR_LGN = USR_LGN;
    }

    public String getUSR_NM() {
        return USR_NM;
    }

    public void setUSR_NM(String USR_NM) {
        this.USR_NM = USR_NM;
    }

    public String getUSR_EML() {
        return USR_EML;
    }

    public void setUSR_EML(String USR_EML) {
        this.USR_EML = USR_EML;
    }

    public String getUSR_TEL() {
        return USR_TEL;
    }

    public void setUSR_TEL(String USR_TEL) {
        this.USR_TEL = USR_TEL;
    }

    public String getCRT_DT() {
        return CRT_DT;
    }

    public void setCRT_DT(String CRT_DT) {
        this.CRT_DT = CRT_DT;
    }
}
