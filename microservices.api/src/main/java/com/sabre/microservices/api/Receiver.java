package com.sabre.microservices.api;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import com.rabbitmq.client.DeliverCallback;
import java.io.IOException;

import java.util.concurrent.TimeoutException;

public class Receiver {
    public static void main(String [] args) throws IOException , TimeoutException {              
        ConnectionFactory factory = new ConnectionFactory();
          Connection connection = factory.newConnection();
            Channel channel = connection.createChannel();
            channel.queueDeclare("my", false, false, false, null);
            DeliverCallback deliverCallback = (tag,message) -> {               
               String msg = new String(message.getBody(),"UTF-8");
               String [] partsOfMessage = msg.split(",");
               if (partsOfMessage.length > 1){
                   System.out.println("Hello"+ partsOfMessage[1]+", I am your father!"); 
               }
              };
        channel.basicConsume("my", true, deliverCallback, tag -> { });
    
    }
}
