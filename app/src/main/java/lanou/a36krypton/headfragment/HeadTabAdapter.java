package lanou.a36krypton.headfragment;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * Created by dllo on 16/10/24.
 */
public class HeadTabAdapter extends FragmentPagerAdapter {

    private ArrayList<Fragment> fragments;
    String[] strings = {"快讯","推荐","早期项目"};

    public HeadTabAdapter(FragmentManager fm) {
        super(fm);
    }


    public void setFragments(ArrayList<Fragment> fragments) {
        this.fragments = fragments;
    }



    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 :fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return strings[position];
    }
}
