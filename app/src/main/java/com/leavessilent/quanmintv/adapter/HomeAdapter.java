package com.leavessilent.quanmintv.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.leavessilent.quanmintv.R;
import com.leavessilent.quanmintv.home.model.HomeModel;

/**
 * Created by Administrator on 2017/2/16.
 */

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.HomeViewHolder> {

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
    public HomeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item_home, parent, false);
        HomeViewHolder holder = new HomeViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(HomeViewHolder holder, int position) {
        holder.mTitleTv.setText(mHomeModel.getList().get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mHomeModel == null ? 0 : mHomeModel.getList().size();
    }

    public static class HomeViewHolder extends RecyclerView.ViewHolder {
        private TextView mTitleTv;
        private TextView mMoreTv;
        private RecyclerView mRecyclerView;

        public HomeViewHolder(View itemView) {
            super(itemView);
            mTitleTv = (TextView) itemView.findViewById(R.id.item_tv_title);
            mMoreTv = (TextView) itemView.findViewById(R.id.item_tv_more);
            mRecyclerView = (RecyclerView) itemView.findViewById(R.id.item_rv);
        }
    }
}
