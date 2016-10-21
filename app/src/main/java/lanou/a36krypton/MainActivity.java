package lanou.a36krypton;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import lanou.a36krypton.base.BaseActivity;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private TextView mainTv;

    @Override
    protected int getLaout() {
        return R.layout.activity_main;
    }

    //    this指的是本类对象 java:命名规范:对象.方法(类)
    @Override
    protected void initViews() {
        mainTv = bindView(R.id.main_tv);
        setClick(this,mainTv);//报红实现OnClick接口
    }

    @Override
    protected void initData() {
    }

    @Override
    public void onClick(View view) {

    }
}
