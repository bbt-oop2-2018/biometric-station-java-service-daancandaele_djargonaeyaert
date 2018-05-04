
package javaserialportexample;


public class JavaSerialPortExample {

    public static void main(String[] args) {
        // First create an object of SerialLineReceiver using the non-default constructor
        // 0 = index of com port (not the COM number from windows!)
        // 9600 = baudrate
        // false = debugging, set to true to see more messages in the console
        SerialLineReceiver receiver = new SerialLineReceiver(0, 115200, false);
        
        // To receive data from the serial port device you need to register a listener.
        // This is an instance of SerialPortLineListener that has a method serialLineEvent().
        // This method is called from inside SerialLineReceiver every time the serial port
        // received a data stream that contains a newline (\n).
        // The data is past using an object of type SerialData. You can access the data as a String
        // or as an array of bytes.
        receiver.setLineListener(new SerialPortLineListener() {
            @Override
            public void serialLineEvent(SerialData data) {
                DataSend message = new DataSend();
                message.send(data);
            }
        });
    }
}
