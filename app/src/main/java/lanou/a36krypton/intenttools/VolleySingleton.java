package lanou.a36krypton.intenttools;

import android.app.VoiceInteractor;
import android.graphics.Bitmap;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

import lanou.a36krypton.R;

/**
 * Created by dllo on 16/10/27.
 */
public class VolleySingleton {

    private static VolleySingleton volleySingleton;
    private final RequestQueue mRequestQueue;
    private final ImageLoader mImageLoader;

    public VolleySingleton() {
//        创建队列 MyApp自定义类继承Application整个工程的上下文
        mRequestQueue = Volley.newRequestQueue(MyApp.getContext());
        mImageLoader = new ImageLoader(mRequestQueue, new MemoryCache());
    }

    public static VolleySingleton getInsatance() {
        if (volleySingleton == null) {
            synchronized (VolleySingleton.class) {
                if (volleySingleton == null) {
                    volleySingleton = new VolleySingleton();
                }
            }
        }
        return volleySingleton;
    }
//    请求图片
    public void getImage(String url, ImageView imageView) {
        mImageLoader.get(url,new AnimImageListener(imageView) );
    }

    class AnimImageListener implements ImageLoader.ImageListener {
        private ImageView mImageView;
        public AnimImageListener(ImageView imageView) {
            mImageView = imageView;
        }
//访问成功
        @Override
        public void onResponse(ImageLoader.ImageContainer response, boolean isImmediate) {
            Bitmap bitmap = response.getBitmap();
            if (bitmap == null) {
//                图片还在请求中
                mImageView.setImageResource(R.mipmap.ic_launcher);
            } else {
//                图片请求成功
                mImageView.setImageBitmap(bitmap);
//                添加动画效果
                AlphaAnimation alphaAnimation = new AlphaAnimation(0,1f);
                alphaAnimation.setDuration(5000);
                mImageView.setAnimation(alphaAnimation);
                alphaAnimation.start();
            }
        }
//访问失败
        @Override
        public void onErrorResponse(VolleyError error) {
            mImageView.setImageResource(R.mipmap.ic_launcher);
        }
    }

//    获得RequestQueue
    public RequestQueue getRequestQueue () {
        return mRequestQueue;
    }

//   将请求添加到请求队列
    public <T> void addRequest(Request<T> request) {
        mRequestQueue.add(request);
    }

    
}