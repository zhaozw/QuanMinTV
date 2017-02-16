package com.leavessilent.quanmintv.adapter;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.leavessilent.quanmintv.R;
import com.leavessilent.quanmintv.home.model.HomeModel;
import com.leavessilent.quanmintv.home.model.LinkObject;
import com.leavessilent.quanmintv.loader.GlideImageLoader;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;

/**
 * Created by Administrator on 2017/2/16.
 */

public class HomeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final int TYPE_AD = 0;
    private static final int TYPE_CLASSIFY = 1;
    private static final int TYPE_LIVE = 2;

    public static final String TAG = HomeAdapter.class.getSimpleName();

    private HomeModel mHomeModel;
    private LayoutInflater mInflater;

    public HomeAdapter(Context context, HomeModel homeModel) {
        mHomeModel = homeModel;
        mInflater = LayoutInflater.from(context);
    }

    public void update(HomeModel homeModel) {
        if (homeModel != null) {
            mHomeModel = homeModel;
            this.notifyDataSetChanged();
        }
    }

    @Override
    public int getItemViewType(int position) {
        HomeModel.ListBean listBean = mHomeModel.getList().get(position);
        String name = listBean.getSlug();
        int viewType;
        if ("app-index".equals(name)) {
            viewType = TYPE_AD;
        } else if ("app-classification".equals(name)) {
            viewType = TYPE_CLASSIFY;
        } else {
            viewType = TYPE_LIVE;
        }
        return viewType;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView;
        RecyclerView.ViewHolder viewHolder = null;
        switch (viewType) {
            case TYPE_AD:
                itemView = mInflater.inflate(R.layout.item_home_ad, parent, false);
                viewHolder = new AdViewHolder(itemView);
                break;
            case TYPE_CLASSIFY:
                itemView = mInflater.inflate(R.layout.item_home_classify, parent, false);
                viewHolder = new ClassifyViewHolder(itemView);
                break;
            case TYPE_LIVE:
                itemView = mInflater.inflate(R.layout.item_home_live, parent, false);
                viewHolder = new LiveViewHolder(itemView);
                break;
        }
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        switch (getItemViewType(position)) {
            case TYPE_AD:
                adBindViewHolder(holder, position);
                break;
            case TYPE_CLASSIFY:
                break;
            case TYPE_LIVE:
                break;
        }
    }

    /**
     * 将绑定轮播页数据
     *
     * @param holder
     * @param position
     */
    private void adBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof AdViewHolder) {
            AdViewHolder adViewHolder = (AdViewHolder) holder;
            List<HomeModel.AppindexBean> appindex = mHomeModel.getAppindex();
            List<String> imageUrls = new ArrayList<>();
            List<String> titles = new ArrayList<>();
            for (int i = 0, size = appindex.size(); i < size; i++) {
                HomeModel.AppindexBean appindexBean = appindex.get(i);
                LinkObject object = appindexBean.getLink_object();
                imageUrls.add(object.getRecommend_image());
                titles.add(object.getTitle());
            }
            adViewHolder.mBanner
                    .setBannerStyle(BannerConfig.CIRCLE_INDICATOR_TITLE_INSIDE)
                    .setIndicatorGravity(BannerConfig.RIGHT)
                    .setImageLoader(new GlideImageLoader())
                    .setImages(imageUrls)
                    .setBannerTitles(titles)
                    .setDelayTime(3000)
                    .start();
        }
    }

    @Override
    public int getItemCount() {
        return mHomeModel == null ? 0 : mHomeModel.getList().size();
    }

    public static class LiveViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTv;
        private TextView mMoreTv;
        private RecyclerView mRecyclerView;

        public LiveViewHolder(View itemView) {
            super(itemView);
            mTitleTv = (TextView) itemView.findViewById(R.id.item_tv_title);
            mMoreTv = (TextView) itemView.findViewById(R.id.item_tv_more);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.item_rv);
        }
    }

    public static class AdViewHolder extends RecyclerView.ViewHolder {
        private Banner mBanner;

        public AdViewHolder(View itemView) {
            super(itemView);
            mBanner = (Banner) itemView.findViewById(R.id.item_home_banner);

        }
    }

    public static class ClassifyViewHolder extends RecyclerView.ViewHolder {


        public ClassifyViewHolder(View itemView) {
            super(itemView);
        }
    }
}
