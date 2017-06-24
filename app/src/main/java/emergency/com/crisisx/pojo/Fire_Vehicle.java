package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class Fire_Vehicle {

	@SerializedName("STATION_NO")
    private String STATION_NO;

	@SerializedName("VEHICLE_ID")
    private String VEHICLE_ID;

	@SerializedName("VEHICLE_NO")
    private String VEHICLE_NO;

	@SerializedName("LOCATION")
    private String LOCATION;

	@SerializedName("START_TIME")
    private String START_TIME;
	
	@SerializedName("END_TIME")
    private String END_TIME;

    public String getSTATION_NO() {
        return STATION_NO;
    }

    public void setSTATION_NO(String STATION_NO) {
        this.STATION_NO = STATION_NO;
    }

    public String getVEHICLE_ID() {
        return VEHICLE_ID;
    }

    public void setVEHICLE_ID(String VEHICLE_ID) {
        this.VEHICLE_ID = VEHICLE_ID;
    }

    public String getVEHICLE_NO() {
        return VEHICLE_NO;
    }

    public void setVEHICLE_NO(String VEHICLE_NO) {
        this.VEHICLE_NO = VEHICLE_NO;
    }

    public String getLOCATION() {
        return LOCATION;
    }

    public void setLOCATION(String LOCATION) {
        this.LOCATION = LOCATION;
    }

    public String getSTART_TIME() {
        return START_TIME;
    }

    public void setSTART_TIME(String START_TIME) {
        this.START_TIME = START_TIME;
    }

    public String getEND_TIME() {
        return END_TIME;
    }

	public void setEND_TIME(String END_TIME) {
        this.END_TIME = END_TIME;
    }

}
