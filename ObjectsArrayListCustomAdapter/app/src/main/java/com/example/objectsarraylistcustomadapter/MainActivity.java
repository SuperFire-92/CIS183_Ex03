package com.example.objectsarraylistcustomadapter;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText et_j_fName;
    EditText et_j_lName;
    EditText et_j_email;
    Button btn_j_addUser;
    ListView lv_j_listUsers;

    ArrayList<User> listOfUsers;
    UserListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_j_fName = findViewById(R.id.et_v_fName);
        et_j_lName = findViewById(R.id.et_v_lName);
        et_j_email = findViewById(R.id.et_v_email);
        btn_j_addUser = findViewById(R.id.btn_v_addUser);
        lv_j_listUsers = findViewById(R.id.lv_v_users);

        //User user = new User("Bob","Smith","email@email.gov");
        //Log.d("First Name",user.getfName());

        //Create a new instance of the list
        listOfUsers = new ArrayList<User>();

        //Within this array called listOfUsers, can grow endlessly
        //      1              2              3
        // /---------\    /---------\    /---------\
        // |   User  |    |   User  |    |   User  |
        // |fName    |    |fName    |    |fName    |
        // |lName    |    |lName    |    |lName    |
        // |email    |    |email    |    |email    |
        // \---------/    \---------/    \---------/

        registerButtonEventHandler();
        fillListView();
    }

    public void registerButtonEventHandler()
    {
        btn_j_addUser.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Log.d("Register Button","Pressed");

                addUser();

                displayListOfUsers();
                //Ensures the data list updates
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void addUser()
    {
        //Make sure there is something in the text boxes
        if (!et_j_fName.getText().toString().equals("")
                && !et_j_lName.getText().toString().equals("")
                && !et_j_email.getText().toString().equals(""))
        {
            //If we are here, the user has entered the information into all of the text boxes

            //Make a new user to add to the list
            User newUser = new User();
            //get the information stored in the text boxes
            String fName = et_j_fName.getText().toString();
            String lName = et_j_lName.getText().toString();
            String email = et_j_email.getText().toString();

            newUser.setfName(fName);
            newUser.setlName(lName);
            newUser.setEmail(email);

            //Store the information into the arraylist
            listOfUsers.add(newUser);

            clearTextBoxes();
        }
    }

    public void clearTextBoxes()
    {
        et_j_fName.setText("");
        et_j_lName.setText("");
        et_j_email.setText("");
    }

    public void displayListOfUsers()
    {
        for(int i = 0; i < listOfUsers.size(); i++)
        {
            Log.d("User:",listOfUsers.get(i).getfName());
        }
    }

    public void fillListView()
    {
        adapter = new UserListAdapter(this, listOfUsers);
        //set the listviews adapter
        lv_j_listUsers.setAdapter(adapter);
    }
}