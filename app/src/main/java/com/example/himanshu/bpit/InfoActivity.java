package com.example.himanshu.bpit;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.FrameLayout;

import com.example.himanshu.bpit.Fragment.FragmentRollNo;

public class InfoActivity extends AppCompatActivity {
FrameLayout infoFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_info);
     infoFrame=findViewById(R.id.infoFrame);
        FragmentRollNo fragmentRollNo=new FragmentRollNo();
        FragmentTransaction ftrax=getSupportFragmentManager().beginTransaction();
        ftrax.replace(R.id.infoFrame,fragmentRollNo);
        ftrax.commit();
    }
}
