package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class DAE_Officials {

	@SerializedName("USER_ID")
    private String USER_ID;

	@SerializedName("USER_NAME")
    private String USER_NAME;

	@SerializedName("PASSWORD")
    private String PASSWORD;

	@SerializedName("POWER_STATION_NO")
    private String POWER_STATION_NO;

	@SerializedName("DEPARTMENT")
    private String DEPARTMENT;

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
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

    public String getPOWER_STATION_NO() {
        return POWER_STATION_NO;
    }

    public void setPOWER_STATION_NO(String POWER_STATION_NO) {
        this.POWER_STATION_NO = POWER_STATION_NO;
    }

    public String getDEPARTMENT() {
        return DEPARTMENT;
    }

    public void setDEPARTMENT(String DEPARTMENT) {
        this.DEPARTMENT = DEPARTMENT;
    }

}
