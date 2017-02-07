package alea.aleademo;

import android.app.Application;

import alea.aleademo.util.UtilLog;

/**
 * Created by aleac on 2/6/2017.
 */

public class AleaApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        UtilLog.setDebug(true);
    }
}

