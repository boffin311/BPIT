package com.example.himanshu.bpit;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;


public class CustomLinearLayoutManager extends LinearLayoutManager {
    public CustomLinearLayoutManager(Context context) {
        super(context);
    }

    @Override
    public boolean canScrollVertically() {
        return false;
    }
}
