package com.example.himanshu.bpit.Database;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName ="chat_node" )
public class EntityNode {
   @PrimaryKey(autoGenerate = true)
    private  int id;
    private String name;
    private  String chat;
    private String stream;
    private  String time;

    public String getName() {
        return name;
    }

    public String getChat() {
        return chat;
    }

    public String getStream() {
        return stream;
    }

    public String getTime() {
        return time;
    }

    public EntityNode(String name, String chat, String stream, String time) {

        this.name = name;
        this.chat = chat;
        this.stream = stream;
        this.time = time;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}
