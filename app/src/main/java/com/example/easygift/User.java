package com.example.easygift;

import java.util.*;
public class User
{
    private String name;
    private String email;
    private Map<String, String> wishList;
    private String eventsParticipatingIn;

    public User()
    {
    }

    public User(String name, String email)
    {
        this.name =name;
        this.email = email;
        wishList = new HashMap<>();
        eventsParticipatingIn = "";
    }

    public String getEventsParticipatingIn()
    {
        return eventsParticipatingIn;
    }

    public void setEventsParticipatingIn(String eventsParticipatingIn) {
        this.eventsParticipatingIn = eventsParticipatingIn;
    }

    public void setName(String newName)
    {
        name = newName;
    }

    public void setEmail(String newMail)
    {
        email = newMail;
    }

    public void setWishList(Map<String, String> newMap)
    {
        wishList = newMap;
    }

    public String getName()
    {
        return name;
    }

    public String getEmail()
    {
        return email;
    }

    public Map<String, String> getWishList()
    {
        return wishList;
    }

    public void addToWishList(String key, String field)
    {
        wishList.put(key, field);
    }

}
