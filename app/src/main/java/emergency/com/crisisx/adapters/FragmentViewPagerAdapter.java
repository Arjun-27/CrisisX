package emergency.com.crisisx.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import emergency.com.crisisx.fragments.FirstFragment;
import emergency.com.crisisx.fragments.UserInfoFragment;

/**
 * Created by Arjun on 16-Mar-2017 for CrisisX.
 */

public class FragmentViewPagerAdapter extends FragmentPagerAdapter {
    private boolean forLogin;

    public FragmentViewPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public boolean isForLogin() {
        return forLogin;
    }

    public void setForLogin(boolean forLogin) {
        this.forLogin = forLogin;
        Log.d("Boolean", ""+forLogin);
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return FirstFragment.newInstance("Role Selection");

            case 1:
                return UserInfoFragment.newInstance("Multiple Options");
        }
        return null;
    }

    @Override
    public int getCount() {
        return 2;
    }
}
