package lanou.a36krypton.findfragment;

import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Environment;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.Toast;
import android.widget.VideoView;

import lanou.a36krypton.R;
import lanou.a36krypton.base.BaseFragment;

/**
 * Created by dllo on 16/10/25.
 */
public class FindFragment extends BaseFragment{

    private VideoView videoView;
    private Button play;
    private Button stop;

    @Override
    protected int getLayout() {
        return R.layout.fragment_find;
    }


    @Override
    protected void initView() {
        videoView = bindView(R.id.videoview);
        play = bindView(R.id.play);
        stop = bindView(R.id.stop);

        new Thread(new Runnable() {
            @Override
            public void run() {
                videoBox();
            }
        }).start();
    }


//    播放视频的方法
    public void videoBox () {
        //本地的视频 需要在手机SD卡根目录添加一个 fl1234.mp4 视频
        // videoview只支持MP4 3gp格式
//        String videoUrl1 = Environment.getExternalStorageDirectory().
//                getPath()+"/新建文件夹/社会主义核心价值观.avi" ;
        /**
         * 网络视频
         */
        String videoUrl2 = "http://bobolive.nosdn.127.net/aac_bobo_1471873939069_14732651.mp4";
        Uri uri = Uri.parse(videoUrl2);

//        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams
//                (ViewGroup.LayoutParams.MATCH_PARENT,
//                 ViewGroup.LayoutParams.MATCH_PARENT);
//        videoView.setLayoutParams(layoutParams);



//        VideoView 常用的几个方法
//        public int getDuration ()
//        获得所播放视频的总时间
//        public int getCurrentPosition ()
//        获得当前的位置,我们可以用来设置播放时间的显示
//        public int getCurrentPosition ()
//        获得当前的位置,我们可以用来设置播放时间的显示
//        public int pause ()写一个button
//        暂停播放
//        public int seekTo ()
//        设置播放位置，我们用来总快进的时候就能用到
//        public int setOnCompletionListener(MediaPlayer.OnCompletionListener l)
//        注册在媒体文件播放完毕时调用的回调函数。
//        public int setOnErrorListener (MediaPlayer.OnErrorListener l)
//        注册在设置或播放过程中发生错误时调用的回调函数。如果未指定回调函数， 或回调函数返回false，会弹一个dialog提示用户不能播放
//        public void setOnPreparedListener (MediaPlayer.OnPreparedListener l)
//        注册在媒体文件加载完毕，可以播放时调用的回调函数。
//        public void setVideoURI (Uri uri)
//        设置播放的视频源，也可以用setVideoPath指定本地文件
//        public void start ()写一个button
//        开始播放
//        getHolder().setFixedSize(width,height);
//        设置VideoView的分辨率

//        **设置视频控制器
//        videoView.setMediaController(new android.widget.MediaController(this));
//
//        **播放完成回调
        videoView.setOnCompletionListener(new MyPlayerOnCompletionListener());

        //设置视频路径
        videoView.setVideoURI(uri);
        //开始播放视频
        videoView.start();

        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.start();
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                videoView.pause();
            }
        });

    }
//   播放视频回调监听的内部类
    class MyPlayerOnCompletionListener implements MediaPlayer.OnCompletionListener {

        @Override
        public void onCompletion(MediaPlayer mp) {
            Toast.makeText( getActivity(), "播放完成了", Toast.LENGTH_SHORT).show();
        }
    }


    @Override
    protected void initData() {

    }


}
