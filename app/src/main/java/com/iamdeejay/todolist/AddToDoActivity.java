package com.iamdeejay.todolist;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;


public class AddToDoActivity extends AppCompatActivity {

    private static final String TAG = AddToDoActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);
    }
}
