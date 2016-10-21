package lanou.a36krypton.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lanou.a36krypton.R;

/**
 * Created by dllo on 16/10/21.
 */
public abstract class BaseFragment extends Fragment {

    protected Context mContext;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (getLayout() == 0 ) {
//           如果Fragment没有指定布局
//           默认 就加载一个空布局,防止程序崩溃
            return inflater.inflate(R.layout.null_layout,container,false);
        }
        return inflater.inflate(getLayout(),container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
//        销毁广播
    }

    protected  <T extends View> T bindView (int id) {
        return (T) getView().findViewById(id);
    }

    //    指定在哪个View里的findViewById
    protected <T extends View> T bindView (View view,int id ) {
        return (T) view.findViewById(id);
    }

    //   初始化数据方法
    protected abstract void initData();

    //    初始化组件方法
    protected abstract void initView();

    //    布局
    protected abstract int getLayout();


}
