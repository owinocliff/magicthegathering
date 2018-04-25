package thegathering.magic.io.triggerise.application;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import thegathering.magic.io.triggerise.log.L;

/**
 * Created by clifford.owino on 25/04/2018.
 */

public class MyApplication  extends Application {

    private static MyApplication sInstance;
//    private static TriggeriseDB mDatabase;
//
//    public synchronized static TriggeriseDB getWritableDatabase() {
//        if (mDatabase == null) {
//            mDatabase = new KeOnlineDB(getAppContext());
//        }
//        return mDatabase;
//    }


    public static MyApplication getInstance() {
        return sInstance;
    }

    public static Context getAppContext() {
        return sInstance.getApplicationContext();
    }



    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
    }

    public String getVersion() {
        try {
            return (getPackageManager().getPackageInfo(getPackageName(), 0)).versionName;
        } catch (Exception ex) {
            L.m(" error getting version name : ");
            ex.printStackTrace();
            return "1.0";
        }
    }

    public static void saveToPreferences(Context context, String preferenceName, String preferenceValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(preferenceName, preferenceValue);
        editor.apply();
    }

    public static void saveToPreferences(Context context, String preferenceName, boolean preferenceValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(preferenceName, preferenceValue);
        editor.apply();
    }

    public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return sharedPreferences.getString(preferenceName, defaultValue);
    }

    public static boolean readFromPreferences(Context context, String preferenceName, boolean defaultValue) {
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        return sharedPreferences.getBoolean(preferenceName, defaultValue);
    }
}
