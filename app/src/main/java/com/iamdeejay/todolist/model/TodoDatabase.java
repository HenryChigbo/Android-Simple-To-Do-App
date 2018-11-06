package com.iamdeejay.todolist.model;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

@Database(entities = {Todo.class}, version =1)
public abstract class TodoDatabase extends RoomDatabase {

    private static TodoDatabase todoDatabase;
    public abstract TodoDAO todo();
    private Context context;

    public static TodoDatabase getInstance(Context context){
        if (todoDatabase == null){
            todoDatabase = Room.databaseBuilder(context.getApplicationContext(),
                    TodoDatabase.class, "Todo-Database")
                    .allowMainThreadQueries()
                    .build();
        }
        return todoDatabase;
    }

    public static void destroyInstance(){
        todoDatabase = null;
    }

}
