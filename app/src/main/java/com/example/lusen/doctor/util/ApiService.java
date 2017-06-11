package com.example.lusen.doctor.util;

import com.example.lusen.doctor.model.uploadModel;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

/**
 * 请求接口
 * Created by Rye on 2017/5/6.
 */

public interface ApiService {

    // TODO: 2017/5/6 此处为测试接口 等待后台接口提供

    @FormUrlEncoded
    @POST("/cycle/api/article/fresh")
    Observable<uploadModel> upload(@Field("userId") int userId);
}
