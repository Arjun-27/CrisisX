package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class Power_Station {

	@SerializedName("POWER_STATION_ID")
    private String POWER_STATION_ID;

	@SerializedName("NAME")
    private String NAME;

	@SerializedName("LATITUDE")
    private String LATITUDE;

	@SerializedName("LONGITUDE")
    private String LONGITUDE;

	@SerializedName("PINCODE")
    private String PINCODE;

    public String getPOLICE_STATION_NO() {
        return POWER_STATION_ID;
    }

    public void setPOLICE_STATION_NO(String POLICE_STATION_NO) {
        this.POWER_STATION_ID = POLICE_STATION_NO;
    }

    public String getNAME() {
        return NAME;
    }

    public void setNAME(String NAME) {
        this.NAME = NAME;
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
