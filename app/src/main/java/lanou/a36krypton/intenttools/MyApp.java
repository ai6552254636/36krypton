package lanou.a36krypton.intenttools;

import android.app.Application;
import android.content.Context;

/**
 * Created by dllo on 16/10/27.
 */
public class MyApp extends Application {
    //所有跟界面无关的 都可以用这个全局的Context
    private static Context sContext;
    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
    }
    public static Context getContext() {
        return sContext;
    }

}
