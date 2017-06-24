package emergency.com.crisisx.Generals;

public class Vehicle {

    private String vehicle, plateNo, status;
    boolean selected;

    Vehicle(String vehicle, String plateNo, String status){
        this.vehicle = vehicle;
        this.plateNo = plateNo;
        this.status = status;
    }

    public String getVehicle() {
        return vehicle;
    }

    public void setVehicle(String vehicle) {
        this.vehicle = vehicle;
    }

    public String getPlateNo() {
        return plateNo;
    }

    public void setPlateNo(String plateNo) {
        this.plateNo = plateNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }
}
