package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class Hospital {

	@SerializedName("HOSPITAL_ID")
    private String HOSPITAL_ID;

	@SerializedName("HOSPITAL_NAME")
    private String HOSPITAL_NAME;

	@SerializedName("LATITUDE")
    private String LATITUDE;

	@SerializedName("LONGITUDE")
    private String LONGITUDE;

	@SerializedName("PINCODE")
    private String PINCODE;
	

    public String getHOSPITAL_ID() {
        return HOSPITAL_ID;
    }

    public void setHOSPITAL_ID(String HOSPITAL_ID) {
        this.HOSPITAL_ID = HOSPITAL_ID;
    }

    public String getHOSPITAL_NAME() {
        return HOSPITAL_NAME;
    }

    public void setHOSPITAL_NAME(String HOSPITAL_NAME) {
        this.HOSPITAL_NAME = HOSPITAL_NAME;
    }

    public String getLATITUDE() {
        return LATITUDE;
    }

    public void setLATITUDE(String LATITUDE) {
        this.LATITUDE = LATITUDE;
    }

    public String getLONGITUDE() {
        return LONGITUDE;
    }

    public void setLONGITUDE(String LONGITUDE) {
        this.LONGITUDE = LONGITUDE;
    }

    public String getPINCODE() {
        return PINCODE;
    }

    public void setPINCODE(String PINCODE) {
        this.PINCODE = PINCODE;
    }
}
