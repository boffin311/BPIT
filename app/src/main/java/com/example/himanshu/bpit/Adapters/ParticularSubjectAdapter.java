package com.example.himanshu.bpit.Adapters;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.himanshu.bpit.R;
import com.example.himanshu.bpit.ewai.MarksItem;
import com.example.himanshu.bpit.ewai.ResultItem;

import java.util.ArrayList;

public class ParticularSubjectAdapter extends RecyclerView.Adapter<ParticularSubjectAdapter.MyHolder> {
    ArrayList<MarksItem> arrayList;
    public static final String TAG="PSA";
    public  ParticularSubjectAdapter(ArrayList<MarksItem> arrayList)
    {
        this.arrayList=arrayList;
    }
    @NonNull
    @Override
    public MyHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
         View view=li.inflate(R.layout.particular_subject_result,parent,false);
        return new MyHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyHolder holder, int position) {
         MarksItem marksItem=arrayList.get(position);
        Log.d(TAG, "onBindViewHolder: "+marksItem.getInternal());
         holder.tvSubName.setText(marksItem.getName());
         holder.tvInternal.setText(String.valueOf(marksItem.getInternal()));
         holder.tvExtenal.setText(String.valueOf(marksItem.getExternal()));
         holder.tvTotalMarks.setText(String.valueOf(marksItem.getExternal()+marksItem.getInternal()));
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    class MyHolder extends RecyclerView.ViewHolder {
       TextView tvSubName,tvSubCode,tvInternal,tvExtenal,tvTotalMarks;
        public MyHolder(@NonNull View itemView) {
            super(itemView);
            tvExtenal=itemView.findViewById(R.id.tvExternal);
            tvInternal=itemView.findViewById(R.id.tvInternal);
            tvSubCode=itemView.findViewById(R.id.tvSubCode);
            tvSubName=itemView.findViewById(R.id.tvSubName);
            tvTotalMarks=itemView.findViewById(R.id.tvTotalMarks);
        }
    }
}
