package com.iamdeejay.todolist;

import android.content.Context;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.iamdeejay.todolist.model.Todo;
import com.iamdeejay.todolist.model.TodoDAO;
import com.iamdeejay.todolist.model.TodoDatabase;

public class AddToDoActivity extends AppCompatActivity {

    TextView title;
    TextView description;
    FloatingActionButton fab;
    Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        title = findViewById(R.id.title);
        description = findViewById(R.id.description);
        fab = findViewById(R.id.floatingActionButton);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String todoTitle = title.getText().toString();
                final String todoDescription = description.getText().toString();

                if (TextUtils.isEmpty(todoTitle) && TextUtils.isEmpty(todoDescription)){
                    Toast.makeText(context, "Todo Entry cannot be empty", Toast.LENGTH_SHORT).show();
                } else {
                    Todo newTodo = new Todo();
                    //Add new entry to the list
                    TodoDAO todoDAO = TodoDatabase.getInstance(context).todo();
                    todoDAO.insertToDo(newTodo);

                    Toast.makeText(context, "Successfully entered a new Todo", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
