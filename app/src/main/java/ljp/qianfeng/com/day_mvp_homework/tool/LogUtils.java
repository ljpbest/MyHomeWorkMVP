package ljp.qianfeng.com.day_mvp_homework.tool;

import android.util.Log;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class LogUtils {
    private static final boolean IS_LOG=true;
    private static final String TAG="Day_MVP_HomeWork";
    public static void logString(Class mclass,String str){
        if(IS_LOG){
            Log.i(TAG,mclass.getName()+"=="+str);
        }
    }
}
