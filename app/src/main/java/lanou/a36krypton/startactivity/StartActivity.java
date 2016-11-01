package lanou.a36krypton.startactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;

import java.lang.ref.ReferenceQueue;

import lanou.a36krypton.MainActivity;
import lanou.a36krypton.R;
import lanou.a36krypton.base.BaseActivity;
import lanou.a36krypton.intenttools.GsonRequest;
import lanou.a36krypton.intenttools.VolleySingleton;
import lanou.a36krypton.startactivity.bean.StartBean;

/**
 * Created by dllo on 16/10/21.
 */
public class StartActivity extends BaseActivity {

    private String urlStr = "http://img.zcool.cn/community/01b57e5617554f32f875313de00c70.jpg";
    private GsonRequest<StartBean> gsonRequest;
    private ImageView mIV;
    private TextView mTV;
    private CountDownTimer timer;

    @Override
    protected int getLayout() {
        return R.layout.activity_start;
    }

    @Override
    protected void initViews() {
        mIV = bindView(R.id.start_iv);
        mTV = bindView(R.id.start_tvtime);
        DataBOX();
        setTimeDesign();
    }

//创建网络请求

    public void DataBOX () {
        //                        请求成功的方法
        gsonRequest = new GsonRequest<StartBean>(StartBean.class,
                urlStr, new Response.Listener<StartBean>() {
            @Override
            public void onResponse(StartBean response) {
//                        请求成功的方法
//                StartBean startBea = new StartBean( response.getImage() );
                StartBean starBean = response;
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }

        });

    }
//定时器CountDownTimer实现倒计时显示和界面跳转
    public void setTimeDesign() {
        mTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(StartActivity.this, MainActivity.class);
                startActivity(intent);
                timer.cancel();
                finish();   //实现启动页面不在显示
            }

        });
        timer = new CountDownTimer(8000,1000) {
            @Override
            public void onTick(long l) {
                mTV.setText( (l / 1000) + "");
            }

            @Override
            public void onFinish() {
                Intent intent = new Intent(StartActivity.this,MainActivity.class);
                startActivity(intent);
                timer.cancel();
                finish();
            }
        };
          timer.start();
    }

    @Override
    protected void initData() {
//请求图片
        VolleySingleton.getInsatance().getImage(urlStr,mIV);

    }

}
