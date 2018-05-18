package javaserialportexample;

import be.vives.oop.mqtt.chatservice.MqttChatService;

public class DataSend {

    private String clientId = "biostation1";
    private String tempTopic = "temp";
    private String heartTopic = "heart";
    private String accelxTopic = "Xaccel";
    private String accelyTopic = "Yaccel";
    private String accelzTopic = "Zaccel";
    
    
    
    
    void send(SerialData data) {


        String sdata = data.getDataAsString();
        int t = sdata.indexOf("[");
        int h = sdata.indexOf("|");
        int x = sdata.indexOf(",");
        int y = sdata.indexOf(";");
        int z = sdata.indexOf(":");

        String temp = sdata.substring(t + 1, t + 6);
        String hb = sdata.substring(h + 1, h + 4);
        String xd = sdata.substring(x + 1, x + 5);
        String yd = sdata.substring(y + 1, y + 5);
        String zd = sdata.substring(z + 1, z + 5);

        System.out.println(temp);
        if (hb.contains(",")) {
            hb = sdata.substring(h + 1, h + 3);
        }
        if (xd.contains("-")) {
            xd = sdata.substring(x + 1, x + 6);
        }
        if (yd.contains("-")) {
            yd = sdata.substring(y + 1, y + 6);
        }
        if (zd.contains("-")) {
            zd = sdata.substring(z + 1, z + 6);
        }
        System.out.println(hb);
        System.out.println(xd);
        System.out.println(yd);
        System.out.println(zd);

        MqttChatService tempMqttService = new MqttChatService(clientId, tempTopic);
        tempMqttService.sendMessage(temp);

        MqttChatService heartMqttService = new MqttChatService(clientId, heartTopic);
        heartMqttService.sendMessage(hb);

        MqttChatService accelxMqttService = new MqttChatService(clientId, accelxTopic);
        accelxMqttService.sendMessage(xd);
        
        MqttChatService accelyMqttService = new MqttChatService(clientId, accelyTopic);
        accelyMqttService.sendMessage(yd);
        
        MqttChatService accelzMqttService = new MqttChatService(clientId, accelzTopic);
        accelzMqttService.sendMessage(zd);
    }
}
