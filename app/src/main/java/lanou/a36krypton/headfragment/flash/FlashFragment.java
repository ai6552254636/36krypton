package lanou.a36krypton.headfragment.flash;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import lanou.a36krypton.R;

/**
 * Created by dllo on 16/10/24.
 */
public class FlashFragment extends Fragment{

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.flash_fragment,null);
    }
}
