package com.example.himanshu.bpit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.himanshu.bpit.ewai.Result;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ResultActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/1dpxzu")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(ResultInterface.class).getResult().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result=response.body();

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {

            }
        });
    }
}
