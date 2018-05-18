package javaserialportexample;

public class JavaSerialPortExample {

    public static void main(String[] args) {
        // First create an object of SerialLineReceiver using the non-default constructor
        // 0 = index of com port (not the COM number from windows!)
        // 9600 = baudrate
        // false = debugging, set to true to see more messages in the console
        SerialLineReceiver receiver = new SerialLineReceiver(0, 115200, false);
        DataSend message = new DataSend();

        receiver.setLineListener(new SerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {
                message.send(data);
            }
        });
    }
}
