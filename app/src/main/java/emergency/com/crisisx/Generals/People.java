package emergency.com.crisisx.Generals;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import emergency.com.crisisx.R;

import static emergency.com.crisisx.Generals.PeopleList.peopleList;

public class People extends AppCompatActivity {

    private RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.personlist);

        recyclerView = (RecyclerView) findViewById(R.id.personRecycler);

        SelectAdapter peopleAdapter = new SelectAdapter(peopleList);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());

//        peopleList.add(new Person("asfd", "0123456789", "asdf"));
//        peopleList.add(new Person("zxc", "0654123798", "rwt"));
//        peopleList.add(new Person("qwer", "0987456312", "juh"));
        peopleAdapter.notifyDataSetChanged();

        recyclerView.setAdapter(peopleAdapter);

    }
}
