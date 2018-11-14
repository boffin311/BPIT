package com.example.himanshu.bpit.Fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.example.himanshu.bpit.Adapters.ParticularSubjectAdapter;
import com.example.himanshu.bpit.CustomLinearLayoutManager;
import com.example.himanshu.bpit.R;
import com.example.himanshu.bpit.ewai.MarksItem;
import com.example.himanshu.bpit.ewai.ResultItem;
import com.github.lzyzsd.circleprogress.ArcProgress;

import java.util.ArrayList;

public class FragmentOverallResult extends Fragment {
    public FragmentOverallResult(){}
ArcProgress arcProgressOverall;
    RecyclerView rvPartcularSub;
    public static final String TAG="FOR";
    ArrayList<MarksItem> marksItems;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_show_result,container,false);
       arcProgressOverall=view.findViewById(R.id.arcProgressOverall);
       arcProgressOverall.setMax(100);
       arcProgressOverall.setProgress(84);
       marksItems= getArguments().getParcelableArrayList("ResultItem");
        Log.d(TAG, "onCreateView: "+marksItems.size());
        rvPartcularSub=view.findViewById(R.id.rvParticularSub);
           /**CustomLinearLayoutManager is made instead of LinearLayoutManager so that we can
           stop default scroll effect of Recycler View*/

         CustomLinearLayoutManager cllManager=new CustomLinearLayoutManager(getActivity().getBaseContext());
        rvPartcularSub.setLayoutManager(cllManager);
        ParticularSubjectAdapter particularSubjectAdapter=new ParticularSubjectAdapter(marksItems);
        rvPartcularSub.setAdapter(particularSubjectAdapter);


        return view;
    }
}
