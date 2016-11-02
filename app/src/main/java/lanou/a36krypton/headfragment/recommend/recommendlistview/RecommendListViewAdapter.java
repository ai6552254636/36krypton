package lanou.a36krypton.headfragment.recommend.recommendlistview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import lanou.a36krypton.R;
import lanou.a36krypton.bean.headfragmentbean.RecommendBean;
import lanou.a36krypton.intenttools.VolleySingleton;

/**
 * Created by dllo on 16/11/1.
 */
public class RecommendListViewAdapter extends BaseAdapter{

    ArrayList<RecommendBean.DataBean> beanArrayList ;

    public void setBeanArrayList(ArrayList<RecommendBean.DataBean> beanArrayList) {
        this.beanArrayList = beanArrayList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return beanArrayList == null ? 0 : beanArrayList.size() ;
    }

    @Override
    public Object getItem(int i) {
        return beanArrayList.size();
    }

    @Override
    public long getItemId(int i) {

        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        ViewHolder viewholder = null;
        if (convertView == null) {
            Context mContext = viewGroup.getContext();     //有viewGroup  null的参数就要变成viewGroup,后面的布尔要给false
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_earlystage,viewGroup,false);
            viewholder = new ViewHolder(convertView);
            convertView.setTag(convertView);
        } else {
           viewholder =  (ViewHolder) convertView.getTag();
        }
//时间戳格式转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd HH:mm:ss");
        String finalTime = sdf.format(new Date
                (  ( beanArrayList.get(i).getPublishTime() )
                ));

        VolleySingleton.getInsatance().getImage(beanArrayList.get(i).getFeatureImg() ,viewholder.mIV );
        viewholder.mTV.setText(beanArrayList.get(i).getTitle());
        viewholder.mTV1.setText(beanArrayList.get(i).getColumnName());
        viewholder.mTV2.setText(finalTime);

        return convertView;
    }

    private class ViewHolder {

        private ImageView mIV;
        private TextView mTV;
        private TextView mTV1;
        private TextView mTV2;

        public ViewHolder(View convertView) {
            mIV = (ImageView) convertView.findViewById(R.id.item_earlyimageview);
            mTV = (TextView) convertView.findViewById(R.id.item_earlytextview);
            mTV1 = (TextView) convertView.findViewById(R.id.item_earlytextview1);
            mTV2 = (TextView) convertView.findViewById(R.id.item_earlytextview2);
        }
    }
}
