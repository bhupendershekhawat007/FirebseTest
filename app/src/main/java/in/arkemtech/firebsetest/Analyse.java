package in.arkemtech.firebsetest;

import android.content.Context;
import android.os.Bundle;

import com.google.firebase.analytics.FirebaseAnalytics;

public class Analyse {
    private static Analyse ourInstance;
    private static Context mcontext;
    private static FirebaseAnalytics mFirebaseAnalytics;
    private User_Data_Repository user_data_repository = new User_Data_Repository();

    public static Analyse getInstance(Context context) {

        if (ourInstance == null) {
            ourInstance = new Analyse();
            mcontext = context;
            mFirebaseAnalytics = FirebaseAnalytics.getInstance(context);
            mFirebaseAnalytics.setUserId("XXX-007");
        }
        return ourInstance;
    }

    private Analyse() {
    }

    public void LoginEvent() {

        Bundle bundle = new Bundle();
        bundle.putString(Param.User_Name, user_data_repository.getUsername());
        mFirebaseAnalytics.logEvent(FirebaseAnalytics.Event.LOGIN, bundle);
    }

    public void LogoutEvent() {

        Bundle bundle = new Bundle();
        bundle.putString(Param.User_Name, user_data_repository.getUsername());
        mFirebaseAnalytics.logEvent(EventType.LOGOUT_NAME, bundle);

    }

    public void ErrorEvent() {

        Bundle bundle = new Bundle();
        bundle.putString(Param.User_Name, user_data_repository.getUsername());
        bundle.putString(Param.User_APPVERSION, user_data_repository.getAppVersion());
        bundle.putString(Param.User_OS,user_data_repository.getUserOS());
        bundle.putString(Param.User_ID, user_data_repository.getUserID());
        bundle.putString(Param.METHODNAME, "Login error");
        mFirebaseAnalytics.logEvent(EventType.ERROR, bundle);

    }

    public void UserProperties() {

        mFirebaseAnalytics.setUserProperty(Param.User_Name, user_data_repository.getUsername());
        mFirebaseAnalytics.setUserProperty(Param.User_Age, user_data_repository.getUserAge());
        mFirebaseAnalytics.setUserProperty(Param.User_ID, user_data_repository.getUserID());
    }


}
