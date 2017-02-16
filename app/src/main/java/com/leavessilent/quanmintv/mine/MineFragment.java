package com.leavessilent.quanmintv.mine;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leavessilent.quanmintv.R;

/**
 * Created by Administrator on 2017/2/14.
 */

public class MineFragment extends Fragment {
    public static final String TAG = MineFragment.class.getSimpleName();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_mine, container, false);
    }
}
