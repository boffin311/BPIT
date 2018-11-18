package com.example.himanshu.bpit.Activities;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;

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

public class ChatBoxActivity extends AppCompatActivity {
ImageButton btnSendIt;
String chat;
EditText etChat;
DatabaseReference dbref;
static long childrenCount;
public static final String TAG="CBA";
ChatViewModel chatViewModel;
ChatInfo chatInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat_box);

        btnSendIt=findViewById(R.id.btnSendIt);
        etChat=findViewById(R.id.etchat);
        FirebaseDatabase firebaseDatabase=FirebaseDatabase.getInstance();
         dbref=firebaseDatabase.getReference();
        String name="Himanshu Nautiyal";
        String stream="CSE-A";

        String photoLink="https://firebase.google.com/_static/images/firebase/touchicon-180.png";
         chatInfo=new ChatInfo(photoLink,name,chat,stream);

        btnSendIt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chat=etChat.getText().toString();
                dbref.push().setValue(chatInfo);
            }
        });

    chatViewModel=ViewModelProviders.of(this).get(ChatViewModel.class);
    chatViewModel.getAllChats().observe(this, new Observer<ArrayList<EntityNode>>() {
        @Override
        public void onChanged(ArrayList<EntityNode> entityNodes) {

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
//    public void readChatList(DatabaseReference dbref){
//        dbref.addChildEventListener(new ChildEventListener() {
//            @Override
//            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//                  ChatInfo chatInfo=dataSnapshot.getValue(ChatInfo.class);
////                  if (childrenCount>)
////                  {
////
////                  }
//            }
//
//            @Override
//            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {
//
//            }
//
//            @Override
//            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
//
//            }
//
//            @Override
//            public void onCancelled(@NonNull DatabaseError databaseError) {
//
//            }
//        });

