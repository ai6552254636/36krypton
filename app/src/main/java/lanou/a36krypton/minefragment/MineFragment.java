package lanou.a36krypton.minefragment;

import android.content.Intent;
import android.view.View;

import lanou.a36krypton.R;
import lanou.a36krypton.activity.LoginActivity;
import lanou.a36krypton.base.BaseFragment;

/**
 * Created by dllo on 16/10/25.
 */
public class MineFragment extends BaseFragment implements View.OnClickListener {

    private View mBtnIv;

    @Override
    protected int getLayout() {
        return R.layout.mine_fragment;
    }

    @Override
    protected void initView() {

        mBtnIv = bindView(R.id.mine_iv);
        mBtnIv.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.mine_iv:
                Intent intent = new Intent(getActivity(), LoginActivity.class);
                startActivity(intent);
                break;
            default:
                break;
        }
    }
}
