package com.leavessilent.quanmintv.adapter;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.leavessilent.quanmintv.home.model.HomeModel;

import java.util.List;

/**
 * Created by Administrator on 2017/2/16.
 */

public class AdViewPagerAdapter extends PagerAdapter {

    private List<View> mData;

    public AdViewPagerAdapter(List<View> data) {
        mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mData.get(position));
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mData.get(position));
        return mData.get(position);
    }
}
