import java.net.*; //clean working 
import java.io.*;
public class udps{
    public static void main(String [] args) throws Exception {
        byte[] senddata = new byte[15];
        byte[] receivedata = new byte[15];
        DatagramSocket mysocekt = new DatagramSocket(9000);
        System.out.println("server is running");
        System.out.println("server is waiting for the client to send the message");
        while(true){
            BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
            DatagramPacket receivepacket = new DatagramPacket(receivedata, receivedata.length);
            String data = new String(receivepacket.getData());
            System.out.println("client data " + data);
            InetAddress clientipaddress = receivepacket.getAddress();
            int port = receivepacket.getPort();
            System.out.println("enter the msg to send it to the client");
            String msg = user.readLine();
            senddata = msg.getBytes();
            DatagramPacket sendpacket = new DatagramPacket(senddata, senddata.length, clientipaddress, port);
            mysocekt.send(sendpacket);                        
        }
    }
}