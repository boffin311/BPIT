package com.example.himanshu.bpit.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.himanshu.bpit.Adapters.ChatSettingAdapter;
import com.example.himanshu.bpit.Database.ChatViewModel;
import com.example.himanshu.bpit.Database.EntityNode;
import com.example.himanshu.bpit.R;
import com.example.himanshu.bpit.model.ChatInfo;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class ChatBoxActivity extends AppCompatActivity {
    ImageButton btnSendIt;
    String chat,photoLink,stream;
    String name;
    EditText etChat;
    RecyclerView rvChats;
    DatabaseReference dbref;
    static long childrenCount;
    public static final String TAG = "CBA";
    ChatViewModel chatViewModel;
    ChatInfo chatInfo;
    ChatSettingAdapter chatSettingAdapter;
    ArrayList<ChatInfo> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);
        rvChats=findViewById(R.id.rvChats);
        btnSendIt = findViewById(R.id.btnSendIt);
        etChat = findViewById(R.id.etchat);
        arrayList=new ArrayList<>();
        FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
        dbref = firebaseDatabase.getReference();

        name = "Himanshu Nautiyal";

        stream = "CSE-A";


        photoLink = "https://firebase.google.com/_static/images/firebase/touchicon-180.png";


        btnSendIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chat = etChat.getText().toString();
                chatInfo = new ChatInfo(photoLink, name, chat, stream);
                dbref.push().setValue(chatInfo);
            }
        });
        readChatList(dbref);
        rvChats.setLayoutManager(new LinearLayoutManager(ChatBoxActivity.this));

        chatSettingAdapter = new ChatSettingAdapter(arrayList);
        rvChats.setAdapter(chatSettingAdapter);
//    chatViewModel=ViewModelProviders.of(this).get(ChatViewModel.class);
//    chatViewModel.getAllChats().observe(this, new Observer<List<EntityNode>>() {
//        @Override
//        public void onChanged(List<EntityNode> entityNodes) {
//
//        }
//    });


    }

    public void readChatList(DatabaseReference dbref) {
        dbref.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Log.d(TAG, "onChildAdded: "+dataSnapshot.getValue(ChatInfo.class).getName());
                arrayList.add( dataSnapshot.getValue(ChatInfo.class));
                chatSettingAdapter.notifyDataSetChanged();

            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}




//       dbref.addListenerForSingleValueEvent(new ValueEventListener() {
//           @Override
//           public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
//               childrenCount=dataSnapshot.getChildrenCount();
//           }
//
//           @Override
//           public void onCancelled(@NonNull DatabaseError databaseError) {
//
//           }
//       });
//
//    }


