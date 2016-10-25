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


import lanou.a36krypton.base.BaseActivity;
import lanou.a36krypton.headfragment.HeadTabAdapter;
import lanou.a36krypton.headfragment.earlystage.EarlyStageFragment;
import lanou.a36krypton.headfragment.flash.FlashFragment;
import lanou.a36krypton.headfragment.recommend.RecommendFragment;


public class MainActivity extends BaseActivity {

    private TabLayout mTb;
    private ViewPager mVp;
    private RadioButton mBtnHead;

    //   加载布局
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    //    绑定控件
    @Override
    protected void initViews() {
        mTb = bindView(R.id.main_tb);
        mVp = bindView(R.id.main_vp);
        mBtnHead = bindView(R.id.main_btnhead);

    }

    //    加载数据
    @Override
    protected void initData() {

        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FlashFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new EarlyStageFragment());

        HeadTabAdapter adapter = new HeadTabAdapter(getSupportFragmentManager());
        adapter.setFragments(fragments);
        mVp.setAdapter(adapter);
        mTb.setupWithViewPager(mVp);

        mTb.setSelectedTabIndicatorColor(Color.BLACK);//分割线颜色
        mTb.setTabTextColors(Color.GRAY, Color.BLACK);//选中文字的颜色

    }
}






