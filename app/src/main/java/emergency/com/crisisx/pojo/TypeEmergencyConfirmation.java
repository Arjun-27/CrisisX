package emergency.com.crisisx.pojo;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arjun on 02-Apr-2017 for CrisisX.
 */

public class TypeEmergencyConfirmation implements Parcelable {
    private String ambulance_no, hospital_name, staff_name, mobile_no;
    private String notification_type;

    public String getNotification_type() {
        return notification_type;
    }

    public void setNotification_type(String notification_type) {
        this.notification_type = notification_type;
    }

    public String getAmbulance_no() {
        return ambulance_no;
    }

    public void setAmbulance_no(String ambulance_no) {
        this.ambulance_no = ambulance_no;
    }

    public String getHospital_name() {
        return hospital_name;
    }

    public void setHospital_name(String hospital_name) {
        this.hospital_name = hospital_name;
    }

    public String getStaff_name() {
        return staff_name;
    }

    public void setStaff_name(String staff_name) {
        this.staff_name = staff_name;
    }

    public String getMobile_no() {
        return mobile_no;
    }

    public void setMobile_no(String mobile_no) {
        this.mobile_no = mobile_no;
    }

    public TypeEmergencyConfirmation() {

    }
    protected TypeEmergencyConfirmation(Parcel in) {
        ambulance_no = in.readString();
        hospital_name = in.readString();
        staff_name = in.readString();
        mobile_no = in.readString();
    }

    public static final Creator<TypeEmergencyConfirmation> CREATOR = new Creator<TypeEmergencyConfirmation>() {
        @Override
        public TypeEmergencyConfirmation createFromParcel(Parcel in) {
            return new TypeEmergencyConfirmation(in);
        }

        @Override
        public TypeEmergencyConfirmation[] newArray(int size) {
            return new TypeEmergencyConfirmation[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(ambulance_no);
        parcel.writeString(hospital_name);
        parcel.writeString(staff_name);
        parcel.writeString(mobile_no);
    }
}
