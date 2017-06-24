package emergency.com.crisisx.api;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Arjun on 03-Jul-2016 for Harvesters.
 */
public class AppUtils {

    public static final String BASE_GOOGLE_URL = "https://maps.googleapis.com/maps/api/";
    public static final String BASE_SERVER_URL = "http://192.168.1.128:8000/";
    //public static final String GOOGLE_PROJECT_ID = "554947342098";
    public static ProgressDialog dialog;

    private static final Retrofit retrofit_g_instance = new Retrofit.Builder()
            .baseUrl(BASE_GOOGLE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    private static final Retrofit retrofit_server_instance = new Retrofit.Builder()
            .baseUrl(BASE_SERVER_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build();

    public static final APIEndpoints googleApiService = retrofit_g_instance.create(APIEndpoints.class);
    public static final APIEndpoints serverApiService = retrofit_server_instance.create(APIEndpoints.class);

//    public static View getViewByPosition(int pos, ListView listView) {
//        final int firstListItemPosition = listView.getFirstVisiblePosition();
//        final int lastListItemPosition = firstListItemPosition + listView.getChildCount() - 1;
//
//        if (pos < firstListItemPosition || pos > lastListItemPosition ) {
//            return listView.getAdapter().getView(pos, null, listView);
//        } else {
//            final int childIndex = pos - firstListItemPosition;
//            return listView.getChildAt(childIndex);
//        }
//    }

    public static boolean isNetworkAvailable(Context c) {
        ConnectivityManager connectivityManager
                = (ConnectivityManager) c.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    public static void showDialog(Context c) {
        dialog = new ProgressDialog(c, AlertDialog.THEME_HOLO_DARK);
        dialog.setMessage("Please Wait...");
        dialog.setCanceledOnTouchOutside(false);
        dialog.setIndeterminate(true);
        dialog.show();
    }

    public static void dismissDialog(Context c) {
        if(dialog.isShowing())
            dialog.dismiss();
    }
}
