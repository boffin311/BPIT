package com.example.himanshu.bpit.model;

public class ChatInfo {
    String photoLink;
    String name;
    String chat;
    String stream;

    public ChatInfo(String photoLink, String name, String chat, String stream) {
        this.photoLink = photoLink;
        this.name = name;
        this.chat = chat;
        this.stream = stream;
    }

    public ChatInfo() {
    }

    public String getPhotoLink() {
        return photoLink;
    }

    public void setPhotoLink(String photoLink) {
        this.photoLink = photoLink;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getChat() {
        return chat;
    }

    public void setChat(String chat) {
        this.chat = chat;
    }

    public String getStream() {
        return stream;
    }

    public void setStream(String stream) {
        stream = stream;
    }
}
