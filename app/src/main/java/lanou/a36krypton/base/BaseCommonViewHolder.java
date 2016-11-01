package lanou.a36krypton.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lanou.a36krypton.intenttools.MyApp;

/**
 * Created by dllo on 16/10/31.
 */
public class BaseCommonViewHolder extends RecyclerView.ViewHolder {
    /**
     * SparseArray 谷歌封装用法和HashMap相似,但是Key值固定式int类型
     * 用他来存放所有的View,key就是View的id
     */
    private SparseArray <View> viewSparseArray;
    private View itemView;   //行布局


    public BaseCommonViewHolder(View itemView) {
        super(itemView);
        this.itemView = itemView;
        viewSparseArray = new SparseArray<>();
    }


    /**
     * 通过View的id来获得指定的View,如果该View没有赋值,就先执行findViewByID.
     * 然后把它放到View的集合里,使用泛型来取消强转
     * @param id
     * @param <T>
     * @return 指定View
     */

    public <T extends View> T getView (int id) {
        View view = viewSparseArray.get(id);
        if (view == null) {
//           证明SparseArray里面没有这个View
            view = itemView.findViewById(id);
            viewSparseArray.put(id,view);
        }
        return (T) view;
    }

//    专门给ListView使用的方法
    public static BaseCommonViewHolder getViewHolder(View itemView , ViewGroup parent , int layoutItemId) {
        BaseCommonViewHolder mBaseVH;
        if (itemView == null) {
            Context mContext =  parent.getContext();
            itemView = LayoutInflater.from(mContext).inflate(layoutItemId,parent,false);
            mBaseVH = new BaseCommonViewHolder(itemView);
            itemView.setTag(mBaseVH);
        } else {
            mBaseVH = (BaseCommonViewHolder) itemView.getTag();
        }
        return mBaseVH;
    }

//   方法重载,专门给RecyclerView 的Adapter使用的方法
    public static BaseCommonViewHolder getViewHolder(ViewGroup parent,int layoutItemId) {
        return getViewHolder(null,parent,layoutItemId);
    }

//    返回(获取)行布局
    public View getItemView() {
        return itemView;
    }

     /** ViewHolder 设置数据的方法 **/
//    设置文字
    public BaseCommonViewHolder setText(int id,String text) {
        TextView textView = getView(id);
        textView.setText(text);

        return this;
    }

//   设置图片,图片是 mipmap里的
    public BaseCommonViewHolder setImage (int imageViewId , int imgId) {
        ImageView imageView  =getView(imageViewId);
        imageView.setImageResource(imgId);

        return this;
    }

//    这是图片,图片需要网络请求
    public BaseCommonViewHolder setImage (int imageViewId , String imgUrl ) {
        ImageView imageView = getView(imageViewId);
        // TODO 网络请求图片
        Picasso.with(  MyApp.getContext() ).load(imgUrl);

        return this;
    }

//    设置 View的点击事件
    public BaseCommonViewHolder setViewClick (int id , View.OnClickListener onClickListener) {
        getView(id).setOnClickListener(onClickListener);

        return this;
    }

//    为行布局设置点击事件
    public BaseCommonViewHolder setItemClick (View.OnClickListener onClickListener) {
        itemView.setOnClickListener(onClickListener);

        return this;
    }


}
