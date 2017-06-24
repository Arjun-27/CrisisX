package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

public class CalculateNearest {

	@SerializedName("Location")
    private String Location;

	@SerializedName("UID")
    private String UID;

	@SerializedName("Emergency_type")
    private String Emergency_type;

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    public String getUID() {
        return UID;
    }

    public void setUID(String UID) {
        this.UID = UID;
    }

    public String getEmergency_type() {
        return Emergency_type;
    }

    public void setEmergency_type(String Emergency_type) {
        this.Emergency_type = Emergency_type;
    }
}
