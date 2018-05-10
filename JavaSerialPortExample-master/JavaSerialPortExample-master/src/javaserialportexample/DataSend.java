package javaserialportexample;

import be.vives.oop.mqtt.chatservice.MqttChatService;


public class DataSend {
    
    private MqttChatService chatService;
   /* private MqttChatService chatService;
    private MqttChatService chatService;
    */
    void send(SerialData data) {
       

        /*  
        chatService = new MqttChatService();
        System.out.println(data.getDataAsString());
        chatService.sendMessage(data.getDataAsString());
        
        chatService = new MqttChatService();
        System.out.println(data.getDataAsString());
        chatService.sendMessage(data.getDataAsString());
    */
      /*
        String ss ="[22.2 |100 | 50 ]";
        String[] parts = ss.split("|");
        System.out.println(parts[8].trim());
      */
      String sdata = data.getDataAsString();
      int t= sdata.indexOf("[");
      int h= sdata.indexOf("|");
      int x= sdata.indexOf(",");
      int y= sdata.indexOf(";");
      int z= sdata.indexOf(":");
      
      String temp = sdata.substring(t+1,t+6);
      String hb = sdata.substring(h+1,h+4);
      String xd = sdata.substring(x+1,x+5);
      String yd = sdata.substring(y+1,y+5);
      String zd = sdata.substring(z+1,z+5);
      
      System.out.println( temp); 
      if( hb.contains(",")){
      hb = sdata.substring(h+1,h+3);
    }
      if( xd.contains("-")){
      xd = sdata.substring(x+1,x+6);
    }
      if( yd.contains("-")){
      yd = sdata.substring(y+1,y+6);
    }
      if( zd.contains("-")){
      zd = sdata.substring(z+1,z+6);
    }
      System.out.println( hb);
      System.out.println(xd);
      System.out.println(yd);
      System.out.println(zd);
      chatService = new MqttChatService();
      chatService.sendMessage(temp);
    } 
}