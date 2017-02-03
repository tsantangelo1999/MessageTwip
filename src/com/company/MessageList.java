package com.company;

import java.util.ArrayList;

public class MessageList
{
    public ArrayList<Message> msgList = new ArrayList<>();
    public String name;

    public MessageList(String n)
    {
        name = n;
    }

    public void add(Message m)
    {
        msgList.add(0, m);
    }

    public void display()
    {
        for(int i = msgList.size() - 1; i >= 0; i--)
        {
            System.out.println(msgList.get(i).owner + ": " + msgList.get(i).message);
        }
        System.out.println("");
    }

    public void erase(int pos)
    {
        msgList.remove(pos);
    }

    public void clear()
    {
        msgList.clear();
    }

    public void move(int pos, MessageList ml)
    {
        for(int i = 0; i < ml.msgList.size(); i++)
        {
            if(msgList.get(pos).timeReceived > ml.msgList.get(i).timeReceived)
            {
                ml.msgList.add(i, msgList.get(pos));
                msgList.remove(pos);
                return;
            }
        }
        ml.msgList.add(msgList.get(pos));
        msgList.remove(pos);
    }
}
