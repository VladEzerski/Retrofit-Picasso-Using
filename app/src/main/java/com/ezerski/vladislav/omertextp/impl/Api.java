package com.ezerski.vladislav.omertextp.impl;

import com.ezerski.vladislav.omertextp.models.UserModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Api {

    @GET("/posts")
    Call<List<UserModel>> getData(@Query("userId") int resourceId);
}
