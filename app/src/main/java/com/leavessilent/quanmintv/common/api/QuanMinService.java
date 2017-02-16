package com.leavessilent.quanmintv.common.api;

import com.leavessilent.quanmintv.home.model.HomeModel;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * Created by Administrator on 2017/2/16.
 */

public interface QuanMinService {
    @GET("page/appv2-index/info.json")
    Observable<HomeModel> getHomeModel();
}