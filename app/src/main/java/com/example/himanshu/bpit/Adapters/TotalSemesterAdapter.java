package com.example.himanshu.bpit.Adapters;

import android.content.Context;
import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.himanshu.bpit.Fragment.FragmentOverallResult;
import com.example.himanshu.bpit.R;
import com.example.himanshu.bpit.ewai.MarksItem;
import com.example.himanshu.bpit.ewai.ResultItem;

import java.util.ArrayList;

public class TotalSemesterAdapter extends RecyclerView.Adapter<TotalSemesterAdapter.MyHoder> {
   ArrayList<ResultItem> arrayList;
   FragmentManager fragmentManager;
   ArrayList<MarksItem> marksItems;
public static final String TAG="TSA";
    public TotalSemesterAdapter(ArrayList<ResultItem> arrayList,FragmentManager fragmentManager){
        this.arrayList=arrayList;
        this.fragmentManager=fragmentManager;

   }
    @NonNull
    @Override
    public MyHoder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view=li.inflate(R.layout.sem_count,parent,false);
        return new MyHoder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHoder holder, final int position) {
         ResultItem resultItem=arrayList.get(position);
        Log.d(TAG, "onBindViewHolder: "+resultItem.getMarks());
         holder.btnSelectSem.setText(resultItem.getSem());
         holder.btnSelectSem.setOnClickListener(new View.OnClickListener() {
             @Override
             public void onClick(View v) {
                 FragmentOverallResult fragmentOverallResult=new FragmentOverallResult();
                 FragmentTransaction ftrax=fragmentManager.beginTransaction();
                 ftrax.replace(R.id.frameResultContainer,fragmentOverallResult);
                 marksItems=(ArrayList<MarksItem>) arrayList.get(position).getMarks();
                 Bundle bundle=new Bundle();
                 bundle.putParcelableArrayList("ResultItem",marksItems);
                 fragmentOverallResult.setArguments(bundle);
                 ftrax.commit();
             }
         });

    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

     class MyHoder extends RecyclerView.ViewHolder{
Button btnSelectSem;
       public MyHoder(@NonNull View itemView) {
           super(itemView);
           btnSelectSem=itemView.findViewById(R.id.btnSelectSem);
       }
   }
}
