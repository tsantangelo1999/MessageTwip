package com.company;

/**
 * Created by ts159 on 1/30/17.
 */
public class Message
{
    public final String owner;
    public final String message;
    public final long timeReceived;

    public Message(String o, String m)
    {
        owner = o;
        message = m;
        timeReceived = System.currentTimeMillis();
    }
}
