package com.example.himanshu.bpit.Database;

import java.util.ArrayList;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface DaoChatNode {
    @Insert
      void insert(EntityNode node);

    @Delete
    void delete(EntityNode node);

    @Update
    void update(EntityNode node);

    @Query( "Select * from chat_node ")
    LiveData<ArrayList<EntityNode>> getAllChats();
}
