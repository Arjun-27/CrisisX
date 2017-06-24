package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class Fire_Officer {

	@SerializedName("FIRE_STATION_NO")
    private String FIRE_STATION_NO;

	@SerializedName("USER_ID")
    private String USER_ID;

	@SerializedName("NAME")
    private String NAME;

	@SerializedName("USER_NAME")
    private String USER_NAME;

	@SerializedName("PASSWORD")
    private String PASSWORD;
	
	@SerializedName("REGISTRATION")
    private String REGISTRATION;

	@SerializedName("SHIFT")
    private String SHIFT;	

    public String getFIRE_STATION_NO() {
        return FIRE_STATION_NO;
    }

    public void setFIRE_STATION_NO(String FIRE_STATION_NO) {
        this.FIRE_STATION_NO = FIRE_STATION_NO;
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

    public String getREGISTRATION() {
        return REGISTRATION;
    }

	public void setREGISTRATION(String REGISTRATION) {
        this.REGISTRATION = REGISTRATION;
    }


    public String getSHIFT() {
        return SHIFT;
    }

    public void setSHIFT(String SHIFT) {
        this.SHIFT = SHIFT;
    }

}
