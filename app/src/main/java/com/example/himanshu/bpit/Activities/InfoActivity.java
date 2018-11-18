package com.example.himanshu.bpit.Activities;

import android.graphics.Color;
import android.os.Build;

import androidx.fragment.app.FragmentTransaction;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.widget.FrameLayout;

import com.example.himanshu.bpit.Fragment.FragmentRollNo;
import com.example.himanshu.bpit.R;

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
