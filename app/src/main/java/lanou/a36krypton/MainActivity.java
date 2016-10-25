package lanou.a36krypton;


import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;


import lanou.a36krypton.attentionfragment.AttentionFragment;
import lanou.a36krypton.base.BaseActivity;
import lanou.a36krypton.findfragment.FindFragment;
import lanou.a36krypton.headfragment.HeadFragment;
import lanou.a36krypton.minefragment.MineFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {


    private RadioButton mBtnHead;
    private RadioButton mBtnAttention;
    private View mBtnFind;
    private View mBtnMine;


    //   加载布局
    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    //    绑定控件
    @Override
    protected void initViews() {
        mBtnHead = bindView(R.id.main_btnhead);
        mBtnAttention = bindView(R.id.main_btnattention);
        mBtnFind = bindView(R.id.main_btnfind);
        mBtnMine = bindView(R.id.main_btnmine);
        mBtnHead.setOnClickListener(this);
        mBtnAttention.setOnClickListener(this);
        mBtnFind.setOnClickListener(this);
        mBtnMine.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
        switch (view.getId()) {
            case R.id.main_btnhead:
                fragmentTransaction.replace(R.id.main_headlayout,new HeadFragment());
                break;
            case R.id.main_btnattention:
                fragmentTransaction.replace(R.id.main_headlayout,new AttentionFragment());
                break;
            case R.id.main_btnfind:
                fragmentTransaction.replace(R.id.main_headlayout,new FindFragment());
                    break;
            case R.id.main_btnmine:
                fragmentTransaction.replace(R.id.main_headlayout,new MineFragment());
                break;
            default:
                break;
        }
        fragmentTransaction.commit();
    }


    //    加载数据
    @Override
    protected void initData() {

    }

}





