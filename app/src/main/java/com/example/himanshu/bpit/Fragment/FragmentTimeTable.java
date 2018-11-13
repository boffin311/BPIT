package com.example.himanshu.bpit.Fragment;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.example.himanshu.bpit.R;


public class FragmentTimeTable extends Fragment {
    public FragmentTimeTable(){}
     ImageView imageView;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
         View view=inflater.inflate(R.layout.fragment_time_table,container,false);
        imageView=view.findViewById(R.id.imageTimeTable);
        Log.d("CHK", "onCreateView: ");

        return view;
    }

}
