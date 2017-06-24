package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class Hospital_Staff {

	@SerializedName("USER_ID")
    private String USER_ID;
	
	@SerializedName("EMERGENCY_ID")
    private String EMERGENCY_ID;

	@SerializedName("HOSPITAL_NO")
    private String HOSPITAL_NO;

	@SerializedName("NAME")
    private String NAME;

	@SerializedName("USER_NAME")
    private String USER_NAME;

	@SerializedName("SHIFT")
    private String SHIFT;

	@SerializedName("PASSWORD")
    private String PASSWORD;

    public String getEMERGENCY_ID(){
        return EMERGENCY_ID;
    }
    public void setEMERGENCY_ID(String EMERGENCY_ID) {
        this.EMERGENCY_ID = EMERGENCY_ID;
    }

    public String getUSER_ID() {
        return USER_ID;
    }

    public void setUSER_ID(String USER_ID) {
        this.USER_ID = USER_ID;
    }

    public String getHOSPITAL_NO() {
        return HOSPITAL_NO;
    }

    public void setHOSPITAL_NO(String HOSPITAL_NO) {
        this.HOSPITAL_NO = HOSPITAL_NO;
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

    public String getSHIFT() {
        return SHIFT;
    }

    public void setSHIFT(String SHIFT) {
        this.SHIFT = SHIFT;
    }

	    public String getPASSWORD() {
        return PASSWORD;
    }

    public void setPASSWORD(String PASSWORD) {
        this.PASSWORD = PASSWORD;
    }

}
