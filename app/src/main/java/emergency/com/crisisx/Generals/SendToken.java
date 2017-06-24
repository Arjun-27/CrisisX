package emergency.com.crisisx.Generals;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arjun on 02-Apr-2017 for OfficialsApp.
 */

public class SendToken {

    @SerializedName("FCM_STAFF")
    private String token;

    @SerializedName("FCM_ID")
    private String hospitalId;

    @SerializedName("UID")
    private String uid;

    public String getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(String hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
