package com.example.himanshu.bpit;

import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.himanshu.bpit.Adapters.TotalSemesterAdapter;
import com.example.himanshu.bpit.Fragment.FragmentOverallResult;
import com.example.himanshu.bpit.ewai.Result;
import com.example.himanshu.bpit.ewai.ResultItem;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static android.widget.Toast.LENGTH_SHORT;

public class ResultActivity extends AppCompatActivity {
ArrayList<ResultItem> resultItems;
RecyclerView rvSemester;
Button btnOverall;
public static final String TAG="RAC";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        rvSemester=findViewById(R.id.rvSemester);
        btnOverall=findViewById(R.id.btnOverall);
        rvSemester.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.myjson.com/bins/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofit.create(ResultInterface.class).getResult().enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Result result=response.body();
                resultItems=(ArrayList<ResultItem>) result.getResult();
                Log.d(TAG, "onResponse: "+resultItems.get(0).getSem());
                ResultActivity.this.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        Toast.makeText(ResultActivity.this, "Successful Call", Toast.LENGTH_SHORT).show();
//                        btnOverall.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View v) {
//                                FragmentOverallResult fragmentOverallResult=new FragmentOverallResult();
//                                FragmentTransaction ftrax=getSupportFragmentManager().beginTransaction();
//                                ftrax.replace(R.id.frameResultContainer,fragmentOverallResult);
//                                Bundle bundle=new Bundle();
//                                bundle.putParcelableArrayList("ResultItem",resultItems);
//                                fragmentOverallResult.setArguments(bundle);
//                                ftrax.commit();
//                            }
//                        });
                        TotalSemesterAdapter totalSemesterAdapter=new TotalSemesterAdapter(resultItems,getSupportFragmentManager());
                        rvSemester.setAdapter(totalSemesterAdapter);
                    }
                });

            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
              ResultActivity.this.runOnUiThread(new Runnable() {
                  @Override
                  public void run() {
                      Toast.makeText(ResultActivity.this, "Failed Call", Toast.LENGTH_SHORT).show();
                  }
              });

            }
        });

    }
}