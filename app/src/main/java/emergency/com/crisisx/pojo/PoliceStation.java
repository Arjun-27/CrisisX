package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class PoliceStation {

	@SerializedName("STATION_ID")
    private String STATION_ID;

	@SerializedName("STATION_NAME")
    private String STATION_NAME;

	@SerializedName("LATITUDE")
    private String LATITUDE;

	@SerializedName("LONGITUDE")
    private String LONGITUDE;

	@SerializedName("PINCODE")
    private String PINCODE;

    public String getSTATION_ID() {
        return STATION_ID;
    }

    public void setSTATION_ID(String STATION_ID) {
        this.STATION_ID = STATION_ID;
    }

    public String getSTATION_NAME() {
        return STATION_NAME;
    }

    public void setSTATION_NAME(String STATION_NAME) {
        this.STATION_NAME = STATION_NAME;
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
