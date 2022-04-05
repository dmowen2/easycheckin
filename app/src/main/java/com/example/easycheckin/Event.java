package com.example.easycheckin;

import java.sql.Time;

public class Event {
    private String hostname;
    private String eventName;
    private String[] attendednames;
    private String eventDate;
    //private QR code
    private String location;
    private Time starttime;
    private Time endtime;
    private int ppllimit;

    Event(String ename, String hname, String loc, String eDate, Time start, Time end, int limit){
        eventName = ename;
        hostname = hname;
        eventDate = eDate;
        location = loc;
        starttime = start;
        endtime = end;
        //add qr code storage
        ppllimit = limit;
        if (limit == 0){
            attendednames = new String[50];
        } else {
            attendednames = new String[limit];
        }
        //not sure if this works but automatically update the event within the database
        updateEventDB();
    }

    public void checkInEvent(String name){
        //add user to the array
        for (int i = 0; i < (attendednames.length-1); i++){
            if (attendednames[i].equals("")){
                attendednames[i] = name;
                break;
            }
        }
        updateEventDB();
    }

    private void updateEventDB(){
        //find event in database
        //update all event data for the event in the datbase
        return;
    }


}
