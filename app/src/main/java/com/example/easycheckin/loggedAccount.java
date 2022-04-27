package com.example.easycheckin;

import java.io.IOException;
import java.util.ArrayList;


public class loggedAccount {

    class Account {

        public String username;
        public String name;

        public Event[] eventsHosted;
        public Event[] eventsAttended;

        public Account(String uname, String personname) {
            //logged in account only needs basic info
            username = uname;
            name = personname;
            eventsHosted = new Event[5];
            eventsAttended = new Event[5];
        }


    }

    private loggedAccount() {
        //Search database for the username


    }

    public void addAcc(String username, String email, String pname, String pass) {
        //REGISTER NEW USER TO THE DATABASE
        //connect to the network to access database
    }

    public boolean checkAccLogin(String username, String password) {
        //check if the username matches to a name in database
        //check if password matches the stored username password
        //have to connect to the network to register to the database

        return false;
    }


    private static final loggedAccount accInfo = new loggedAccount();
    public static loggedAccount getInstance() { return accInfo; }
}
