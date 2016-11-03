package lanou.a36krypton.headfragment.flash;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

import lanou.a36krypton.R;
import lanou.a36krypton.bean.headfragmentbean.FlashBean;

/**
 * Created by dllo on 16/11/3.
 */
public class FlashListAdapter extends BaseAdapter {

    private ArrayList<FlashBean> beanArrayList;

    @Override
    public int getCount() {
        return beanArrayList == null ? 0 :beanArrayList.size() ;
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
        ViewHolder viewHolder = null;
        if ( convertView==null ) {
            Context mContext = viewGroup.getContext();
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_flash,viewGroup,false);
            viewHolder =new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        return null;

    }

    private class ViewHolder {
        public ViewHolder(View convertView) {

        }
    }
}
