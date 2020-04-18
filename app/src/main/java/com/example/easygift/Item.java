package com.example.easygift;

public class Item
{
    private String name;
    private String link;
    private int priority;

    public Item()
    {
    }

    public Item(String name, String link, int priority)
    {
        this.name = name;
        this.link = link;
        this.priority = priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPriority() {
        return priority;
    }

    public String getLink() {
        return link;
    }

    public String getName() {
        return name;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
