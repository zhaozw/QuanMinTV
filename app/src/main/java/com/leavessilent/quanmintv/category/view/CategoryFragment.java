package com.leavessilent.quanmintv.category.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.leavessilent.quanmintv.R;
import com.leavessilent.quanmintv.category.presenter.CategoryPresenter;
import com.leavessilent.quanmintv.common.base.BaseFragment;

/**
 * Created by Administrator on 2017/2/14.
 */

public class CategoryFragment extends BaseFragment<ICategoryView, CategoryPresenter> {
    public static final String TAG = CategoryFragment.class.getSimpleName();


    @Override
    protected void init(Bundle savedInstanceState) {
        mPresenter.getCategories();
    }

    @Override
    protected CategoryPresenter initPresenter() {
        return new CategoryPresenter();
    }

    @Override
    protected int getContentViewId() {
        return R.layout.fragment_category;
    }
}
