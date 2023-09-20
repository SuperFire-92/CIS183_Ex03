package com.example.objectsarraylistcustomadapter;

public class User {
    //first name, last name, email
    private String fName;
    private String lName;
    private String email;


    //Constructor
    public User()
    {

    }

    //Overload Constructor
    public User(String f, String l, String e)
    {
        fName = f;
        lName = l;
        email = e;
    }

    public String getfName()
    {
        return fName;
    }

    public void setfName(String f)
    {
        this.fName = f;
    }

    public String getlName()
    {
        return lName;
    }

    public void setlName(String l)
    {
        this.lName = l;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String e)
    {
        this.email = e;
    }

}
