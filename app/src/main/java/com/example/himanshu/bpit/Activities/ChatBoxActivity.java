package com.example.himanshu.bpit.Activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;

import com.example.himanshu.bpit.R;
import com.example.himanshu.bpit.model.ChatInfo;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ChatBoxActivity extends AppCompatActivity {
ImageButton btnSendIt;
String chat;
EditText etChat;
DatabaseReference dbref;
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

    }
}
