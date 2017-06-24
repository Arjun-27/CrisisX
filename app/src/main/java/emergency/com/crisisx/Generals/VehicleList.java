package emergency.com.crisisx.Generals;

import java.util.ArrayList;
import java.util.List;

public class VehicleList {

    public static List<Vehicle> vehicleList = new ArrayList<>();

    public VehicleList(){

    }

    public void prepare(){
        vehicleList.add(new Vehicle("asfd", "mh 12 yz 1234", "idle"));
        vehicleList.add(new Vehicle("zxc", "mh 21 xy 7894", "idle"));
        vehicleList.add(new Vehicle("qwer", "mh 34 lm 4561", "idle"));
    }

}
