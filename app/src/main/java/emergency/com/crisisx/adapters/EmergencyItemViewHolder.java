package emergency.com.crisisx.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import emergency.com.crisisx.R;

/**
 * Created by Arjun on 23-Mar-2017 for CrisisX.
 */

public class EmergencyItemViewHolder extends RecyclerView.ViewHolder {

    TextView title;
    public EmergencyItemViewHolder(View itemView) {
        super(itemView);

        title = (TextView) itemView.findViewById(R.id.tv_title);
    }
}
