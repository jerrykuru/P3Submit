package it.jaschke.alexandria;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/**
 * Created by binu on 2/10/16.
 */
public  class Utility {
    private static final String TAG = "Utility";
    public static boolean hasNetWorkConnectivity(Context c){
        ConnectivityManager connectivityManager =  (ConnectivityManager) c.getSystemService(c.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo =  connectivityManager.getActiveNetworkInfo();
        boolean hasConnection = networkInfo != null && networkInfo.isConnectedOrConnecting();
        return hasConnection;
    }
}
