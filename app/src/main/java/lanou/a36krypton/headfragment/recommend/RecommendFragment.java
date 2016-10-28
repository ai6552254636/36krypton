package lanou.a36krypton.headfragment.recommend;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.Arrays;

import lanou.a36krypton.R;
import lanou.a36krypton.base.BaseFragment;
import lanou.a36krypton.intenttools.GlidelmageLoader;

/**
 * Created by dllo on 16/10/24.
 */
public class RecommendFragment extends BaseFragment {

    private Banner mBanner;
    private ArrayList<String> pics = new ArrayList<>();
    String url1 = "";
    String url2 = "";
    String url3 = "";
    String url4 = "";


    protected int getLayout() {
        return R.layout.recommend_fragment;
    }



    @Override
    protected void initView() {
        initData();  //刷新的UI数据
        mBanner = bindView(R.id.recommend_banner);
        bannerBOX();  //轮播的设置方法

    }
// 轮播的设置
    private void bannerBOX() {
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);   //样式
        mBanner.setImageLoader(new GlidelmageLoader()); //图片加载器
        mBanner.setImages(pics); //设置图片集合
        mBanner.setBannerAnimation(Transformer.DepthPage); //设置动画效果
        mBanner.setBannerTitles(  Arrays.asList("")  ); //设置标题集合
        mBanner.isAutoPlay(true); //设置自动轮播,默认为true
        mBanner.setDelayTime(2000); //设置轮播时间
        mBanner.setIndicatorGravity(BannerConfig.CENTER); //设置轮播指示器位置
        mBanner.start();  //设置完成后启动轮播
    }

    @Override
    protected void initData() {
        pics.add(url1);
        pics.add(url2);
        pics.add(url3);
        pics.add(url4);

    }

}
