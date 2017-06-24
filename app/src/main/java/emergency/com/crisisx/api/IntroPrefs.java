package emergency.com.crisisx.api;

import android.content.Context;
import android.content.SharedPreferences;

public class IntroPrefs {

    SharedPreferences pref;
    SharedPreferences.Editor prefEditor;
    private boolean isFirstLaunch;
    Context context;

    public IntroPrefs(Context context){
        this.context = context;
        pref = context.getSharedPreferences("Pref", Context.MODE_PRIVATE);
        prefEditor = pref.edit();
    }

    public boolean getFirstLaunch(){
        this.isFirstLaunch = pref.getBoolean("ISFIRSTLAUNCH", true);
        return isFirstLaunch;
    }

    public void setFirstLaunch(boolean firstLaunch) {
        prefEditor.putBoolean("ISFIRSTLAUNCH", firstLaunch);
        prefEditor.commit();
    }
}
