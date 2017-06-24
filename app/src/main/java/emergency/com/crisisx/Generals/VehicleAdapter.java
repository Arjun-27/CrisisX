package emergency.com.crisisx.Generals;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import emergency.com.crisisx.R;

public class VehicleAdapter extends RecyclerView.Adapter<VehicleAdapter.MyViewHolder2> {

    private List<Vehicle> vehicleList;
    public Context context;
    public ViewGroup parent;

    public class MyViewHolder2 extends RecyclerView.ViewHolder {
        public TextView vehName, vehId;

        public MyViewHolder2(View view) {
            super(view);
            vehName = (TextView) view.findViewById(R.id.vehicleSelecName);
            vehId = (TextView) view.findViewById(R.id.vehicleSelecNo);
        }
    }


    public VehicleAdapter(List<Vehicle> vehicleList) {
        this.vehicleList = vehicleList;
    }

    @Override
    public MyViewHolder2 onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.vehicleselector, parent, false);
        //this.parent = parent;
        return new MyViewHolder2(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder2 holder2, final int position) {
        Vehicle vehicle = vehicleList.get(position);
        holder2.vehName.setText(vehicle.getVehicle());
        holder2.vehId.setText(vehicle.getPlateNo());
    }

        @Override
    public int getItemCount() {
        return vehicleList.size();
    }
}