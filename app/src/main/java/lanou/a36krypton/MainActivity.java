package lanou.a36krypton;


import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.RadioButton;

import java.util.ArrayList;


import lanou.a36krypton.headfragment.HeadTabAdapter;
import lanou.a36krypton.headfragment.earlystage.EarlyStageFragment;
import lanou.a36krypton.headfragment.flash.FlashFragment;
import lanou.a36krypton.headfragment.recommend.RecommendFragment;


public class MainActivity extends AppCompatActivity {

    private TabLayout mTb;
    private ViewPager mVp;
    private RadioButton mBtnHead;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mTb = (TabLayout) findViewById(R.id.main_tb);
        mVp = (ViewPager) findViewById(R.id.main_vp);
        mBtnHead = (RadioButton) findViewById(R.id.main_btnhead);

        mBtnHead.setOnClickListener(new View.OnClickListener() {
    @Override
        public void onClick(View view) {
             ArrayList<Fragment> fragments = new ArrayList<>();
             fragments.add(new FlashFragment());
             fragments.add(new RecommendFragment());
             fragments.add(new EarlyStageFragment());

        HeadTabAdapter adapter = new HeadTabAdapter(getSupportFragmentManager());
             adapter.setFragments(fragments);
             mVp.setAdapter(adapter);
             mTb.setupWithViewPager(mVp);

        mTb.setSelectedTabIndicatorColor(Color.BLACK);//分割线颜色
        mTb.setTabTextColors(Color.GRAY,Color.BLACK);//选中文字的颜色

    }
});



    }
}


//    private TextView mainTv;
//
//
//    @Override
//    protected int getLayout() {
//        return R.layout.activity_main;
//    }
//
//    //    this指的是本类对象 java:命名规范:对象.方法(类)
//    @Override
//    protected void initViews() {
//        mainTv = bindView(R.id.main_tv);
//
//        setClick(this,mainTv);//报红实现OnClick接口
//    }
//
//    @Override
//    protected void initData() {
//
//    }
//
//    @Override
//    public void onClick(View view) {
//
//    }
//
//
//}
