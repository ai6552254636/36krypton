package lanou.a36krypton.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;

/**
 * Created by dllo on 16/10/21.
 */
public abstract class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //        绑定布局
        setContentView(getLayout());
//        初始化组件
        initViews();
//        初始化数据
        initData();
    }

    protected abstract int getLayout();

    //    初始化组件,各种findViewById
    protected abstract void initViews();

    //    初始化数据,基本上就是 拉取网络数据
    protected abstract void initData();

    //    简化findViewById 省去强转过程
    protected <T extends View> T bindView (int id) {
        return (T) findViewById(id);
    }

    protected void setClick (View.OnClickListener clickListener,View...views) {
        for (View view : views) {
            view.setOnClickListener(clickListener);        }
    }
}
