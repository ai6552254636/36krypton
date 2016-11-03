package lanou.a36krypton.headfragment.recommend.recommendlistview;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.Transformer;

import java.util.ArrayList;
import java.util.Arrays;

import lanou.a36krypton.R;
import lanou.a36krypton.base.BaseFragment;
import lanou.a36krypton.bean.headfragmentbean.RecommendBean;
import lanou.a36krypton.bean.urls.Utils;

import lanou.a36krypton.intenttools.GlidelmageLoader;
import lanou.a36krypton.intenttools.GsonRequest;
import lanou.a36krypton.intenttools.VolleySingleton;

/**
 * Created by dllo on 16/10/24.
 */
public class RecommendFragment extends BaseFragment {

    private Banner mBanner;
    private GsonRequest<RecommendBean> gsonRequest;
    private ListView mLV;


    protected int getLayout() {
        return R.layout.fragment_recommend;
    }



    @Override
    protected void initView() {

        mLV = bindView(R.id.recommend_listview);

//        用布局加载器添加ListView头布局
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.layout_head,null);
        mBanner = (Banner) view.findViewById(R.id.recommend_banner);
        mLV.addHeaderView(view);

        bannerBox();  //轮播的设置方法
        dataBox(); //Listview内的请求数据
    }
// 轮播的设置
    private void bannerBox() {
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);   //样式
        mBanner.setImageLoader(new GlidelmageLoader()); //图片加载器
        mBanner.setImages(Utils.picsline); //设置图片集合
        mBanner.setBannerAnimation(Transformer.DepthPage); //设置动画效果
        mBanner.setBannerTitles(  Arrays.asList("标题")  ); //设置标题集合
        mBanner.isAutoPlay(true); //设置自动轮播,默认为true
        mBanner.setDelayTime(2000); //设置轮播时间
        mBanner.setIndicatorGravity(BannerConfig.CENTER); //设置轮播指示器位置
        mBanner.start();  //设置完成后启动轮播
    }
    //    创建网络请求
    public void dataBox () {
        //                        请求成功的方法
        gsonRequest = new GsonRequest<RecommendBean>(RecommendBean.class,
                Utils.urlline, new Response.Listener<RecommendBean>() {
            @Override
            public void onResponse(RecommendBean response) {
                Log.d("RecommendFragment", "请求成功");
                Log.d("RecommendFragment", "response:" + response);
//                        请求成功的方法
                ArrayList<RecommendBean.T1348647909107Bean> mBean1 =
                        (ArrayList<RecommendBean.T1348647909107Bean>) response.getT1348647909107();

                RecommendListViewAdapter adapter = new RecommendListViewAdapter();
                adapter.setBeanArrayList(mBean1);
                mLV.setAdapter(adapter);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });
//加请求下来的数据加入到请求队列
        VolleySingleton.getInsatance().addRequest(gsonRequest);
    }

    @Override
    protected void initData() {
        Utils.picsline.add(Utils.url1);
        Utils.picsline.add(Utils.url2);
        Utils.picsline.add(Utils.url3);
        Utils.picsline.add(Utils.url4);

    }
}
