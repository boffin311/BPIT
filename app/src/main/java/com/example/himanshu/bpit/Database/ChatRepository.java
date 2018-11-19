package com.example.himanshu.bpit.Database;

import android.app.Application;
import android.os.AsyncTask;

import java.util.ArrayList;
import java.util.List;

import androidx.lifecycle.LiveData;

public class ChatRepository {
    private ChatDatabase chatDatabase;
    private DaoChatNode daoChatNode;
    private  LiveData<List<EntityNode>> liveData;

  public ChatRepository(Application application)
  {
      chatDatabase=ChatDatabase.getChatInstance(application);
      daoChatNode=chatDatabase.daoChatNode();
      liveData=daoChatNode.getAllChats();
  }

    public void insert(EntityNode entityNode){
      new InsertInBackground(daoChatNode).execute(entityNode);

  }
    public void delete(EntityNode entityNode){
new DeleteInBackground(daoChatNode).execute(entityNode);
    }
    public void update(EntityNode entityNode){
new UpdateInBackground(daoChatNode).execute(entityNode);
    }

   public LiveData<List<EntityNode>> getAllChats()
   {
       return liveData;
   }

    public static class InsertInBackground extends AsyncTask<EntityNode,Void,Void>
    {
        private DaoChatNode chatNode;
        public InsertInBackground(DaoChatNode daoChatNode){
            this.chatNode=daoChatNode;
        }
        @Override
        protected Void doInBackground(EntityNode... entityNodes) {
           chatNode.insert(entityNodes[0]);
           return null;
        }
    }
    public static class DeleteInBackground extends AsyncTask<EntityNode,Void,Void>
    {
        private DaoChatNode chatNode;
        public DeleteInBackground(DaoChatNode daoChatNode){
            this.chatNode=daoChatNode;
        }
        @Override
        protected Void doInBackground(EntityNode... entityNodes) {
            chatNode.delete(entityNodes[0]);
            return null;
        }
    }
    public static class UpdateInBackground extends AsyncTask<EntityNode,Void,Void>
    {
        private DaoChatNode chatNode;
        public UpdateInBackground(DaoChatNode daoChatNode){
            this.chatNode=daoChatNode;
        }
        @Override
        protected Void doInBackground(EntityNode... entityNodes) {
            chatNode.update(entityNodes[0]);
            return null;
        }
    }

}
