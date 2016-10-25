package lanou.a36krypton.base;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by dllo on 16/10/21.
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//   制定流程
        setContentView(getLayout());
        initViews();
        initData();
    }

    /**
     * 加载布局
     * @return
     */
    protected abstract int getLayout();

    /**
     *  //    初始化组件,各种findViewById
     */
    protected abstract void initViews();

    /**
     *    初始化数据
     */
    protected abstract void initData();

    /**
     *   简化findViewById 省去强转过程
     * @param id   控件ID
     * @param <T>  控件
     * @return
     */
    protected <T extends View> T bindView (int id) {
        return (T) findViewById(id);
    }

    protected void setClick (View.OnClickListener clickListener,View...views) {
        for (View view : views) {
            view.setOnClickListener(clickListener);
        }
    }
}
