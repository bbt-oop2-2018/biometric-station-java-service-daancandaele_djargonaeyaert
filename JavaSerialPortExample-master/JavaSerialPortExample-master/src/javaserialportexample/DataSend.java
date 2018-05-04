package javaserialportexample;

import be.vives.oop.mqtt.chatservice.MqttChatService;


public class DataSend {
    
    private MqttChatService chatService;
    
    void send(SerialData data) {
        chatService = new MqttChatService();
        System.out.println(data.getDataAsString());
        chatService.sendMessage(data.getDataAsString());
               
    }
    
}
