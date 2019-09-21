package com.sabre.microservices.api;


import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import java.io.IOException;
import java.util.Scanner;
import java.util.concurrent.TimeoutException;

public class Sender {
     public static void main(String [] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Please enter your name!!");
        String name = input.next();       
        ConnectionFactory factory = new ConnectionFactory();
        try {
            Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            String message = "Hello my name is, "+name;
            channel.queueDeclare("my", false, false, false, null);
           
            channel.basicPublish("","my", null,message.getBytes());            
           connection.close();
            System.out.println("Message has been sent");
               } catch (IOException | TimeoutException e) {
                      e.printStackTrace();
        }
       
    }
}
