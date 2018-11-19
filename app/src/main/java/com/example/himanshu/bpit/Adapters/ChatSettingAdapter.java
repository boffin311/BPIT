package com.example.himanshu.bpit.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.himanshu.bpit.R;
import com.example.himanshu.bpit.model.ChatInfo;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ChatSettingAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
ArrayList<ChatInfo> arrayList;
public static final String TAG="CSA";
    public ChatSettingAdapter(ArrayList<ChatInfo> arrayList) {
        this.arrayList = arrayList;
    }

    @Override
    public int getItemViewType(int position) {
        if (arrayList.get(position).getName().equals("Himanshu Nautiyal"))
            return 1;
         else return 0;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li= (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        Log.d(TAG, "onCreateViewHolder: "+viewType);
        if (viewType==0)
        {  View view=li.inflate(R.layout.left_chat_show,parent,false);
            return new MyHolderLeft(view);
        }
        else
        {View view=li.inflate(R.layout.right_chat_show,parent,false);
            return new MyHolderRight(view);

        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
       ChatInfo chatInfo=arrayList.get(position);
        Log.d(TAG, "onBindViewHolder: "+holder.getItemViewType());
        if (holder.getItemViewType()==0)
        {   MyHolderLeft myHolderLeft=(MyHolderLeft)holder;
            myHolderLeft.tvLeftChat.setText(chatInfo.getChat());
            myHolderLeft.tvLeftName.setText(chatInfo.getName());
        }
        else
        {
            MyHolderRight myHolderRight= (MyHolderRight) holder;
           myHolderRight.tvRightChat.setText(chatInfo.getChat());
        }
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }
public  void dataChanged(ChatSettingAdapter chatSettingAdapter)
{
   // chatSettingAdapter.notifyItemChanged();
}
    class MyHolderRight extends RecyclerView.ViewHolder {
        TextView tvRightChat;
        TextView tvRightTime;
        public MyHolderRight(@NonNull View itemView) {
            super(itemView);
            tvRightChat=itemView.findViewById(R.id.tvRightChat);
        }
    }

    class MyHolderLeft extends RecyclerView.ViewHolder {
        TextView tvLeftChat,tvLeftName,tvLeftStream;
        public MyHolderLeft(@NonNull View itemView)
        {
            super(itemView);
        tvLeftChat=itemView.findViewById(R.id.tvLeftChat);
            tvLeftName=itemView.findViewById(R.id.tvLeftName);

            tvLeftStream=itemView.findViewById(R.id.tvLeftStream);}
    }
}
