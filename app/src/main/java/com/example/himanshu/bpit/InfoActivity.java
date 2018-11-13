package com.example.himanshu.bpit;

import android.graphics.Color;
import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
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
        ftrax.replace(R.id.infoFrame,fragmentRollNo,"first");
        ftrax.commit();
        Window window=getWindow();
       if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.LOLLIPOP)
        window.setStatusBarColor(Color.rgb(11,67,164));
    }
}
