package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    public static ArrayList<MessageList> messageList = new ArrayList<>();

    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        String topLevelResponse = "";
        while(!topLevelResponse.equals("exit"))
        {
            System.out.println("Input message list name. (EXIT to exit)");
            String name = input.nextLine();
            if(name.equalsIgnoreCase("exit"))
                break;
            else if(!nameExists(name))
            {
                System.out.println("What is your name?");
                String n = input.nextLine();
                messageList.add(new MessageList(name));
                enterSession(findMsgList(name), n);
            }
            else
            {
                System.out.println("What is your name?");
                String n = input.nextLine();
                enterSession(findMsgList(name), n);
            }
        }
    }
    
    public static boolean nameExists(String name)
    {
        for (int i = 0; i < messageList.size(); i++)
        {
            if(name.equals(messageList.get(i).name))
                return true;
        }
        return false;
    }

    public static MessageList findMsgList(String name)
    {
        for(MessageList i : messageList)
        {
            if(i.name.equals(name))
            {
                return i;
            }
        }
        return null;
    }

    public static void enterSession(MessageList ml, String n)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Now viewing " + ml.name + ".");
        String response = "";
        while(!(response.equalsIgnoreCase("exit")))
        {
            System.out.println("Would you like to SEND, DISPLAY, ERASE, or MOVE a message, CLEAR the message list or EXIT?");
            response = input.nextLine();
            if(response.equalsIgnoreCase("send"))
            {
                System.out.println("Enter message contents. Type EXIT to go back.");
                String msg = input.nextLine();
                if(!msg.equalsIgnoreCase("exit"))
                    ml.add(new Message(n, msg));
            }
            if(response.equalsIgnoreCase("display"))
            {
                ml.display();
            }
            if(response.equalsIgnoreCase("erase"))
            {
                System.out.println("Which message would you like to erase? There are " + ml.msgList.size() + " messages.");
                String number = input.nextLine();
                int num;
                if(number.equalsIgnoreCase("exit"))
                    continue;
                try
                {
                    num = Integer.parseInt(number);
                    if(num <= 0 || num > ml.msgList.size())
                        throw new Exception();
                }
                catch(Exception e)
                {
                    System.out.println("Message number must be between 1 and " + ml.msgList.size() + ".");
                    continue;
                }
                ml.erase(num - 1);
            }
            if(response.equalsIgnoreCase("move"))
            {
                System.out.println("Which message would you like to move? There are " + ml.msgList.size() + " messages.");
                String number = input.nextLine();
                int num;
                if(number.equalsIgnoreCase("exit"))
                    continue;
                try
                {
                    num = Integer.parseInt(number);
                    if(num <= 0 || num > ml.msgList.size())
                        throw new Exception();
                }
                catch(Exception e)
                {
                    System.out.println("Message number must be between 1 and " + ml.msgList.size() + ".");
                    continue;
                }
                System.out.println("Which message list would you like to move this message to?");
                String list = input.nextLine();
                try
                {
                    ml.move(num - 1, findMsgList(list));
                }
                catch(NullPointerException e)
                {
                    System.out.println("That message list does not exist.");
                    continue;
                }
            }
            if(response.equalsIgnoreCase("clear"))
            {
                ml.clear();
            }
        }
        System.out.println("");
    }
}
