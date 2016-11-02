package lanou.a36krypton.headfragment.recommend;

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
import lanou.a36krypton.bean.headfragmentbean.EarlyStageBean;
import lanou.a36krypton.bean.headfragmentbean.RecommendBean;
import lanou.a36krypton.headfragment.recommend.recommendlistview.RecommendListViewAdapter;
import lanou.a36krypton.intenttools.GlidelmageLoader;
import lanou.a36krypton.intenttools.GsonRequest;

/**
 * Created by dllo on 16/10/24.
 */
public class RecommendFragment extends BaseFragment {

    private Banner mBanner;
    private GsonRequest<EarlyStageBean> gsonRequest;
    private String url = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=67&pagingAction=up";
    private ArrayList<String> pics = new ArrayList<>();
    String url1 = "http://img4.cache.netease.com/photo/0001/2016-10-31/C4MK6TJM00AP0001.jpg";
    String url2 ="";
    String url3 = "";
    String url4 = "";
    private ListView mLV;


    protected int getLayout() {
        return R.layout.fragment_recommend;
    }



    @Override
    protected void initView() {
        initData();  //刷新的UI数据
        mBanner = bindView(R.id.recommend_banner);
//        mLV = bindView(R.id.listview_early);
        bannerBox();  //轮播的设置方法

    }
// 轮播的设置
    private void bannerBox() {
        mBanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE);   //样式
        mBanner.setImageLoader(new GlidelmageLoader()); //图片加载器
        mBanner.setImages(pics); //设置图片集合
        mBanner.setBannerAnimation(Transformer.DepthPage); //设置动画效果
        mBanner.setBannerTitles(  Arrays.asList("标题")  ); //设置标题集合
        mBanner.isAutoPlay(true); //设置自动轮播,默认为true
        mBanner.setDelayTime(2000); //设置轮播时间
        mBanner.setIndicatorGravity(BannerConfig.CENTER); //设置轮播指示器位置
        mBanner.start();  //设置完成后启动轮播
    }
    //    创建网络请求
//    public void dataBox () {
//        //                        请求成功的方法
//        gsonRequest = new GsonRequest<RecommendBean>(RecommendBean.class,
//                url, new Response.Listener<RecommendBean>() {
//            @Override
//            public void onResponse(RecommendBean response) {
////                        请求成功的方法
//                ArrayList<RecommendBean.DataBean> mBean1 =
//                        (ArrayList<RecommendBean.DataBean>) response.getData();
//                RecommendListViewAdapter adapter = new RecommendListViewAdapter(getActivity());
//                adapter.setBeanArrayList(mBean1);
//                mLV.setAdapter(adapter);
//            }
//        }, new Response.ErrorListener() {
//            @Override
//            public void onErrorResponse(VolleyError error) {
//
//            }
//
//        });
//
//    }

    @Override
    protected void initData() {
        pics.add(url1);
        pics.add(url2);
        pics.add(url3);
        pics.add(url4);

    }

}
