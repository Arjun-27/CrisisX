package emergency.com.crisisx.pojo;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Arjun on 02-Apr-2017 for CrisisX.
 */

public class ConatactNearest {
    @SerializedName("Confirm")
    private String confirm;

    @SerializedName("Staff_List")
    private String staff_list;

    @SerializedName("Ambulance_No")
    private String ambulanceNo;

    @SerializedName("Phone_no")
    private String phone;

    public String getConfirm() {
        return confirm;
    }

    public void setConfirm(String confirm) {
        this.confirm = confirm;
    }

    public String getStaff_list() {
        return staff_list;
    }

    public void setStaff_list(String staff_list) {
        this.staff_list = staff_list;
    }

    public String getAmbulanceNo() {
        return ambulanceNo;
    }

    public void setAmbulanceNo(String ambulanceNo) {
        this.ambulanceNo = ambulanceNo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
