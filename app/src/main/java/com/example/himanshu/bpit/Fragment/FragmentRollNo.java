package com.example.himanshu.bpit.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.himanshu.bpit.R;

public class FragmentRollNo extends Fragment {
    public FragmentRollNo(){}
Button btnLogIn;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.rool_no_fragment,container,false);
        btnLogIn=view.findViewById(R.id.btnLogIn);
        btnLogIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                FragmentTransaction ftrax=getActivity().getSupportFragmentManager().beginTransaction();
                ftrax.addToBackStack("frist");
                ftrax.replace(R.id.infoFrame,new FragmentOtherInfo());
                ftrax.commit();
            }
        });
        return view;
    }
}
