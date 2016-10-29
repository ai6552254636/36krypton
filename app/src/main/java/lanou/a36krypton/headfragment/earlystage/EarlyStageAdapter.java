package lanou.a36krypton.headfragment.earlystage;

import android.content.Context;

import android.content.pm.LabeledIntent;
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
import lanou.a36krypton.headfragment.bean.EarlyStageBean;
import lanou.a36krypton.intenttools.VolleySingleton;

/**
 * Created by dllo on 16/10/29.
 */
public class EarlyStageAdapter extends BaseAdapter {

    private Context mContext;
    private ArrayList<EarlyStageBean.DataBean.DataBean1> beanArrayList;

    public EarlyStageAdapter(Context mContext) {
        this.mContext = mContext;
    }

    public void setBeanArrayList(ArrayList<EarlyStageBean.DataBean.DataBean1> beanArrayList) {
        this.beanArrayList = beanArrayList;
    }

    @Override
    public int getCount() {
        return beanArrayList == null ? 0 : beanArrayList.size();
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
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_earlystage,null);
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

//        时间戳转换
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy - MM - dd HH:mm:ss");
        String finalTime = sdf.format(new Date
                (  ( beanArrayList.get(i).getPublishTime() )
                ));

        VolleySingleton.getInsatance().getImage(beanArrayList.get(i).getFeatureImg(),viewHolder.mIV);
        viewHolder.mTV.setText(beanArrayList.get(i).getTitle());
        viewHolder.mTV1.setText(beanArrayList.get(i).getColumnName());
        viewHolder.mTV2.setText(finalTime);


//        viewHolder.mTV1.setText(  String.valueOf( beanArrayList.get(i).getPublishTime() ) );


        return convertView;
    }

    private class ViewHolder {

        private final ImageView mIV;
        private final TextView mTV;
        private final TextView mTV1;
        private final TextView mTV2;

        public ViewHolder(View convertView) {
            mIV = (ImageView) convertView.findViewById(R.id.item_earlyimageview);
            mTV = (TextView) convertView.findViewById(R.id.item_earlytextview);
            mTV1 = (TextView) convertView.findViewById(R.id.item_earlytextview1);
            mTV2 = (TextView) convertView.findViewById(R.id.item_earlytextview2);
        }
    }
}
