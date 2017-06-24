package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class Police_Officer {

	@SerializedName("POLICE_STATION_NO")
    private String POLICE_STATION_NO;

	@SerializedName("USER_ID")
    private String USER_ID;

	@SerializedName("NAME")
    private String NAME;

	@SerializedName("SHIFT")
    private String SHIFT;

	@SerializedName("USER_NAME")
    private String USER_NAME;
	
	@SerializedName("PASSWORD")
    private String PASSWORD;

	@SerializedName("REGISTRATION")
    private String REGISTRATION;

    public String getPOLICE_STATION_NO() {
        return POLICE_STATION_NO;
    }

    public void setPOLICE_STATION_NO(String POLICE_STATION_NO) {
        this.POLICE_STATION_NO = POLICE_STATION_NO;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
    }

    public String getSHIFT() {
        return SHIFT;
    }

    public void setSHIFT(String SHIFT) {
        this.SHIFT = SHIFT;
    }

    public String getUSER_NAME() {
        return USER_NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.USER_NAME = USER_NAME;
    }

	public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }
	public String getREGISTRSTION() {
        return REGISTRATION;
    }

    public void setREGISTRSTION(String REGISTRSTION) {
        this.REGISTRATION = REGISTRSTION;
    }

}
