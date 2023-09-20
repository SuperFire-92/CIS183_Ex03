package com.example.objectsarraylistcustomadapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

//Press the red light bulb and press add methods after typing extends BaseAdapter
public class UserListAdapter extends BaseAdapter
{
    Context context;
    ArrayList<User> listOfUsers;

    public UserListAdapter(Context c, ArrayList<User> ls)
    {
        //Context tells the adapter where it needs to go (usually sent "this")
        //Being passed from MainActivity.java
        context = c;
        listOfUsers = ls;
    }

    //Count of how many cells in the listview
    @Override
    public int getCount()
    {
        return listOfUsers.size();
    }

    //Gets a specific cell
    @Override
    public Object getItem(int i)
    {
        return listOfUsers.get(i);
    }

    //Get the item's id
    @Override
    public long getItemId(int i)
    {
        return i;
    }

    //Get custom view for each cell
    @Override
    public View getView(int i, View view, ViewGroup viewGroup)
    {
        if (view == null)
        {
            //This line gives us the ability to find the cell
            LayoutInflater mInflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            view = mInflater.inflate(R.layout.custom_cell, null);
        }

        //find the gui elements in my custom_cell
        TextView name = view.findViewById(R.id.txt_v_customCell_name);
        TextView email = view.findViewById(R.id.tv_v_customCell_email);

        //Get the user at position i (i is passed to this function)
        User user = listOfUsers.get(i);

        //set the gui for the custom_cell.xml
        name.setText(user.getlName() + ", " + user.getfName());
        email.setText(user.getEmail());

        //Do not forget to return the view
        return view;
    }
}
