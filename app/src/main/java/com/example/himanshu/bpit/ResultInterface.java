package com.example.himanshu.bpit;

import com.example.himanshu.bpit.ewai.Result;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ResultInterface {
    @GET("1dpxzu")
    Call<Result> getResult();
}
