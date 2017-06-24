package emergency.com.crisisx.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import emergency.com.crisisx.R;

/**
 * Created by Arjun on 17-Mar-2017 for CrisisX.
 */

public class UserInfoFragment extends Fragment {

    public UserInfoFragment() {

    }

    public static UserInfoFragment newInstance(String text) {

        UserInfoFragment f = new UserInfoFragment();
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
        View rootView = inflater.inflate(R.layout.layout_intro_page_3, container, false);

        return rootView;
    }
}
