package com.example.himanshu.bpit.Database;

import android.app.Application;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

public class ChatViewModel extends AndroidViewModel {
    private ChatRepository chatRepository;
    private LiveData<List<EntityNode>> liveData;

    public ChatViewModel(@NonNull Application application) {
        super(application);
        chatRepository = new ChatRepository(application);
        liveData = chatRepository.getAllChats();
    }
    void insert(EntityNode entityNode)
    {
      chatRepository.insert(entityNode);
    }
    void delete(EntityNode entityNode)
    {
        chatRepository.delete(entityNode);
    }
    void update(EntityNode entityNode)
    {
        chatRepository.update(entityNode);
    }
    public LiveData<List<EntityNode>> getAllChats()
    {
        return liveData;
    }
}
