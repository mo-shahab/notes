import java.net.*;
import java.io.*;

public class udpclient {
    public static void main(String args[]) throws Exception {
        byte[] sendData = new byte [15];
        byte[] receiveData = new byte [15]; DatagramSocket mySocket =
        new DatagramSocket();
        System.out.println("Client is running...");
        System.out.println("Enter msg to send to server... ");
        BufferedReader informuser = new BufferedReader(new InputStreamReader(System.in));
        InetAddress myIP=InetAddress.getByName("localhost");
        String data=informuser.readLine();
        sendData=data.getBytes();
        DatagramPacket sendpacket=new DatagramPacket(sendData,sendData.length,myIP,9000);
        mySocket.send(sendpacket); DatagramPacket
        receivepacket=new DatagramPacket(receiveData,receiveData.length);
        mySocket.receive(receivepacket);
        String datatodisplay= new String(receivepacket.getData());
        System.out.println("msg from server : " + datatodisplay);
        mySocket.close();
    }
}