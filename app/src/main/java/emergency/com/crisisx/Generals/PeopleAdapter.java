package emergency.com.crisisx.Generals;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.transition.TransitionManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import emergency.com.crisisx.R;

class PeopleAdapter extends RecyclerView.Adapter<PeopleAdapter.MyViewHolder> {

    private List<Person> personList;
    int mExpandedPosition = -1;
    public Context context;
    public ViewGroup parent;

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView name, id;
        public LinearLayout details;

        public MyViewHolder(View view) {
            super(view);
            name = (TextView) view.findViewById(R.id.personName);
            id = (TextView) view.findViewById(R.id.personId);
            details = (LinearLayout) view.findViewById(R.id.details);
        }
    }


    public PeopleAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.personrecycler, parent, false);
        this.parent = parent;
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Person person = personList.get(position);
        holder.name.setText(person.getName());
        holder.id.setText(person.getId());

        final boolean isExpanded = position==mExpandedPosition;
        holder.details.setVisibility(isExpanded?View.VISIBLE:View.GONE);
        holder.itemView.setActivated(isExpanded);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mExpandedPosition = isExpanded ? -1:position;
                //TransitionManager.beginDelayedTransition(recyclerView);
                TransitionManager.beginDelayedTransition(parent);
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return personList.size();
    }
}