import java.net.*;
import java.io.*;
public class udpc{
    public static void main(String [] args) throws Exception {
        byte[] senddata = new byte[15];
        byte[] receivedata = new byte[15];
        DatagramSocket mysocket = new DatagramSocket();
        System.out.println("the client is ready");
        System.out.println("enter the msg to send it to thee client");
        BufferedReader informuser = new BufferedReader(new InputStreamReader(System.in));
        String data = informuser.readLine();
        senddata = data.getBytes();
        InetAddress myip = InetAddress.getByName("localhost");
        DatagramPacket sendpacket = new DatagramPacket(senddata, senddata.length, myip, 9000);
        mysocket.send(sendpacket);
        DatagramPacket receivepacket = new DatagramPacket(receivedata, receivedata.length, myip, 9000);
        mysocket.receive(receivepacket);
        String datatodisplay = new String(receivepacket.getData());
        System.out.println("the msg from the client is " + datatodisplay);
        mysocket.close();
    }
}