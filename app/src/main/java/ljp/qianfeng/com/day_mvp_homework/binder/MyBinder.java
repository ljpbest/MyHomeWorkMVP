package ljp.qianfeng.com.day_mvp_homework.binder;

import android.app.Activity;
import android.view.View;

import java.lang.reflect.Field;

import ljp.qianfeng.com.day_mvp_homework.bind.BindString;

/**
 * Created by Administrator on 2016/10/31 0031.
 */
public class MyBinder {
    public static void setActivityById(Activity activity){
        Class<? extends Activity> activityclass=activity.getClass();
        Field[] fields=activityclass.getFields();

        for(int i=0;i<fields.length;i++){
            Field field=fields[i];
            BindString bindString=field.getAnnotation(BindString.class);
            if(bindString!=null){
                int value=bindString.value();
                View view=activity.findViewById(value);
                try {
                    field.set(activity,view);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
