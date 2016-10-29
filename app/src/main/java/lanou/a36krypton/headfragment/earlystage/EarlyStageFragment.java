package lanou.a36krypton.headfragment.earlystage;

import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.util.ArrayList;

import lanou.a36krypton.R;
import lanou.a36krypton.base.BaseFragment;
import lanou.a36krypton.headfragment.bean.EarlyStageBean;
import lanou.a36krypton.intenttools.GsonRequest;
import lanou.a36krypton.intenttools.VolleySingleton;

/**
 * Created by dllo on 16/10/24.
 */
public class EarlyStageFragment extends BaseFragment {

    private String url = "https://rong.36kr.com/api/mobi/news?pageSize=20&columnId=67&pagingAction=up";
    private GsonRequest<EarlyStageBean> gsonRequest;
    private ListView mLV;


    //  加载布局
    @Override
    protected int getLayout() {
        return R.layout.fragment_earlystage;

    }

    @Override
    protected void initView() {
        mLV = bindView(R.id.listview_early);
        DataBOX();
    }

//    创建网络请求
    public void DataBOX () {
        //                        请求成功的方法
        gsonRequest = new GsonRequest<EarlyStageBean>(EarlyStageBean.class,
               url, new Response.Listener<EarlyStageBean>() {
           @Override
           public void onResponse(EarlyStageBean response) {
//                        请求成功的方法
               ArrayList<EarlyStageBean.DataBean.DataBean1> mBean1 = (ArrayList<EarlyStageBean.DataBean.DataBean1>) response.getData().getData();
               EarlyStageAdapter adapter = new EarlyStageAdapter(getActivity());
               adapter.setBeanArrayList(mBean1);
               mLV.setAdapter(adapter);
           }
       }, new Response.ErrorListener() {
           @Override
           public void onErrorResponse(VolleyError error) {

           }

});

    }



//请求图片
    @Override
    protected void initData() {
//请求所有数据
        VolleySingleton.getInsatance().addRequest(gsonRequest);

        }

    }


