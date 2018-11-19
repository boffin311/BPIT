package com.example.himanshu.bpit.Fragment;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.himanshu.bpit.Adapters.ParticularSubjectAdapter;
import com.example.himanshu.bpit.CustomLinearLayoutManager;
import com.example.himanshu.bpit.R;
import com.example.himanshu.bpit.ewai.MarksItem;
import com.github.lzyzsd.circleprogress.ArcProgress;

import java.util.ArrayList;

public class FragmentOverallResult extends Fragment {
    public FragmentOverallResult(){}
ArcProgress progressAverage,progressCredit;

    RecyclerView rvPartcularSub;
    public static final String TAG="FOR";
    ArrayList<MarksItem> marksItems;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view=inflater.inflate(R.layout.fragment_show_result,container,false);
//       progressAverage=view.findViewById(R.id.ProgressAverage);
//
//       progressAverage.setMax(100);
//       progressAverage.setProgress(84);
//        progressCredit=view.findViewById(R.id.ProgressCredit);
//
//        progressCredit.setMax(100);
//        progressCredit.setProgress(84);
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
