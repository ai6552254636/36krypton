package lanou.a36krypton.headfragment;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;

import java.util.ArrayList;

import lanou.a36krypton.R;
import lanou.a36krypton.base.BaseFragment;
import lanou.a36krypton.headfragment.earlystage.EarlyStageFragment;
import lanou.a36krypton.headfragment.flash.FlashFragment;
import lanou.a36krypton.headfragment.recommend.RecommendFragment;

/**
 * Created by dllo on 16/10/25.
 */
public class HeadFragment extends BaseFragment {


    private TabLayout mTb;
    private ViewPager mVp;

    @Override
    protected int getLayout() {
        return R.layout.head_fragment;
    }

    @Override
    protected void initView() {
        mTb = bindView(R.id.main_tb);
        mVp = bindView(R.id.main_vp);
    }

    @Override
    protected void initData() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(new FlashFragment());
        fragments.add(new RecommendFragment());
        fragments.add(new EarlyStageFragment());

        HeadTabAdapter adapter = new HeadTabAdapter(getFragmentManager());
        adapter.setFragments(fragments);
        mVp.setAdapter(adapter);
//        默认选择tablayout的标签  默认第几个ViewPager
        mVp.setCurrentItem(1);
        mTb.setupWithViewPager(mVp);

        mTb.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorGrey));//分割线颜色
        mTb.setTabTextColors(getResources().getColor(R.color.colorGrey), getResources().getColor(R.color.colorBlack));//选中文字的颜色

    }




}
