package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class CMG_Officials {

	@SerializedName("USER_ID")
    private String USER_ID;

	@SerializedName("USER_NAME")
    private String USER_NAME;

	@SerializedName("PASSWORD")
    private String PASSWORD;

	@SerializedName("LOCATION")
    private String LOCATION;

	@SerializedName("EMAIL")
    private String EMAIL;
	
	@SerializedName("PHONE")
    private String PHONE;

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

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getEMAIL() {
        return EMAIL;
    }

    public void setEMAIL(String EMAIL) {
        this.EMAIL = EMAIL;
    }
    public String getPHONE() {
        return PHONE;
    }

    public void setPHONE(String PHONE) {
        this.PHONE = PHONE;
    }


}
