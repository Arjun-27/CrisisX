package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class Civilians {

	@SerializedName("USER_ID")
    private String USER_ID;

	@SerializedName("NAME")
    private String NAME;

	@SerializedName("USERNAME")
    private String USERNAME;

	@SerializedName("ADDRESS")
    private String ADDRESS;

	@SerializedName("CITY")
    private String CITY;
	
	@SerializedName("PINCODE")
    private String PINCODE;
	
	@SerializedName("REG_DATE_TIME")
    private String REG_DATE_TIME;

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getUSER_NAME() {
        return NAME;
    }

    public void setUSER_NAME(String USER_NAME) {
        this.NAME = USER_NAME;
    }

    public String getUSERNAME() {
        return USERNAME;
    }

    public void setUSERNAME(String USERNAME) {
        this.USERNAME = USERNAME;
    }

    public String getADDRESS() {
        return ADDRESS;
    }

    public void setADDRESS(String ADDRESS) {
        this.ADDRESS = ADDRESS;
    }

    public String getCITY() {
        return CITY;
    }

    public void setCITY(String CITY) {
        this.CITY = CITY;
    }
    public String getPINCODE() {
        return PINCODE;
    }

    public void setPINCODE(String PINCODE) {
        this.PINCODE = PINCODE;
    }

	
    public String getREG_DATE_TIME() {
        return REG_DATE_TIME;
    }

    public void setREG_DATE_TIME(String REG_DATE_TIME) {
        this.REG_DATE_TIME = REG_DATE_TIME;
    }


}
