package emergency.com.crisisx;

public class Reports {
    private String descp, header, repId, loc, pv1, pv2, av1, av2, fv1, fv2, eta;

    public Reports() {
    }

    public Reports(String header, String descp, String loc, String repId) {
        this.header = header;
        this.descp = descp;
        this.loc = loc;
    }

    public String getDescp() {
        return descp;
    }

    public void setDescp(String descp) {
        this.descp = descp;
    }

    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
    }

    public String getRepId() {
        return repId;
    }

    public void setRepId(String repId) {
        this.repId = repId;
    }

    public String getLoc() {
        return loc;
    }

    public void setLoc(String loc) {
        this.loc = loc;
    }

    public String getPv1() {
        return pv1;
    }

    public void setPv1(String pv1) {
        this.pv1 = pv1;
    }

    public String getPv2() {
        return pv2;
    }

    public void setPv2(String pv2) {
        this.pv2 = pv2;
    }

    public String getAv1() {
        return av1;
    }

    public void setAv1(String av1) {
        this.av1 = av1;
    }

    public String getAv2() {
        return av2;
    }

    public void setAv2(String av2) {
        this.av2 = av2;
    }

    public String getFv1() {
        return fv1;
    }

    public void setFv1(String fv1) {
        this.fv1 = fv1;
    }

    public String getFv2() {
        return fv2;
    }

    public void setFv2(String fv2) {
        this.fv2 = fv2;
    }

    public String getEta() {
        return eta;
    }

    public void setEta(String eta) {
        this.eta = eta;
    }
}
