package lanou.a36krypton.attentionfragment;

import android.content.Intent;
import android.view.View;

import lanou.a36krypton.R;
import lanou.a36krypton.activity.AttentionTagActivity;
import lanou.a36krypton.base.BaseFragment;

public class AttentionFragment extends BaseFragment implements View.OnClickListener {

    private View mBtn;

    //  加载布局
    @Override
    protected int getLayout() {
        return R.layout.fragment_attention;
    }

    @Override
    protected void initView() {
        mBtn = bindView(R.id.btn_attention);
        mBtn.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_attention:
                Intent intent = new Intent(getActivity(),AttentionTagActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }

}
