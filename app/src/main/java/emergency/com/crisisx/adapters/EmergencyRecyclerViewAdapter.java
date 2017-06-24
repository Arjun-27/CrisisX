package emergency.com.crisisx.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import java.util.List;

import emergency.com.crisisx.R;

/**
 * Created by Arjun on 23-Mar-2017 for CrisisX.
 */

public class EmergencyRecyclerViewAdapter extends RecyclerView.Adapter<EmergencyItemViewHolder> {

    private List<String> items;

    public EmergencyRecyclerViewAdapter(List<String> items) {
        this.items = items;
    }

    @Override
    public EmergencyItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new EmergencyItemViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_emergency_situation, parent, false));
    }

    @Override
    public void onBindViewHolder(EmergencyItemViewHolder holder, int position) {
        holder.title.setText(items.get(position));
    }

    @Override
    public int getItemCount() {
        return items != null ? items.size() : 0;
    }
}