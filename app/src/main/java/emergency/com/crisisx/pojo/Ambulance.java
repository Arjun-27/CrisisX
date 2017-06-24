package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class Ambulance {
	@SerializedName("EMERGENCY_ID")
    private String EMERGENCY_ID;

	@SerializedName("HOSPITAL_NO")
    private String HOSPITAL_NO;

	@SerializedName("AMBULANCE_ID")
    private String AMBULANCE_ID;

	@SerializedName("AMBULANCE_NO")
    private String AMBULANCE_NO;

	@SerializedName("LOCATION")
    private String LOCATION;

	@SerializedName("START_TIME")
    private String START_TIME;

	@SerializedName("END_TIME")
    private String END_TIME;
	
	public String getEMERGENCY_ID(){
        return EMERGENCY_ID;
    }

    public void setEMERGENCY_ID(String EMERGENCY_ID) {
        this.EMERGENCY_ID = EMERGENCY_ID;
    }

    public String getHOSPITAL_NO() {
        return HOSPITAL_NO;
    }

    public void setHOSPITAL_NO(String HOSPITAL_NO) {
        this.HOSPITAL_NO = HOSPITAL_NO;
    }

    public String getAMBULANCE_ID() {
        return AMBULANCE_ID;
    }

    public void setAMBULANCE_ID(String AMBULANCE_ID) {
        this.AMBULANCE_ID = AMBULANCE_ID;
    }

    public String getAMBULANCE_NO() {
        return AMBULANCE_NO;
    }

    public void setAMBULANCE_NO(String AMBULANCE_NO) {
        this.AMBULANCE_NO = AMBULANCE_NO;
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
