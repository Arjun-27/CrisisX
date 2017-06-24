package emergency.com.crisisx.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioGroup;

import emergency.com.crisisx.IntroActivity;
import emergency.com.crisisx.R;

/**
 * Created by Arjun on 16-Mar-2017 for CrisisX.
 */

public class FirstFragment extends Fragment {

    public FirstFragment() {

    }

    public static FirstFragment newInstance(String text) {

        FirstFragment f = new FirstFragment();
        Bundle b = new Bundle();
        b.putString("msg", text);

        f.setArguments(b);

        return f;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.layout_intro_page_1, container, false);
        ((RadioGroup) rootView.findViewById(R.id.radio_group)).setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.radio_dae:
                    case R.id.radio_emergency:
                        IntroActivity.viewPagerAdapter.setForLogin(true);
                        break;
                    case R.id.radio_user:
                        IntroActivity.viewPagerAdapter.setForLogin(false);
                        break;
                }
            }
        });
        return rootView;
    }
}
