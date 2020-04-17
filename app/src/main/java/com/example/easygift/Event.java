package com.example.easygift;

import java.util.ArrayList;
import java.util.List;
public class Event
{
    private String name;
    private String occasion;
    private String creator;
    private ArrayList<String> participants;

    public Event()
    {
    }

    public Event(String name, String occasion, String creator)
    {
        this.name= name;
        this.occasion = occasion;
        this.creator = creator;
        participants = new ArrayList<>();
        participants.add(creator);
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOccasion(String occasion) {
        this.occasion = occasion;
    }

    public void setParticipants(ArrayList<String> participants) {
        this.participants = participants;
    }

    public String getName()
    {
        return name;
    }

    public String getOccasion()
    {
        return occasion;
    }

    public String getCreator()
    {
        return creator;
    }

    public ArrayList<String> getParticipants()
    {
        return participants;
    }

    public void addParticipant(String name)
    {
        participants.add(name);
    }
}
