package alea.aleademo.util;

import android.util.Log;

/**
 * Created by aleac on 2/6/2017.
 */

public class UtilLog {

    private static boolean Debug = false;

    public static void setDebug(boolean b){
        Debug = b;
    }

    public static void logD(String key, String value){
        if(Debug){
            Log.d(key, value);
        }
    }
}
