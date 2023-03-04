import java.io.*; //clean working
import java.net.*;
public class udpserver {
    public static void main (String[] args) throws Exception {
        DatagramSocket datagramsocket = new DatagramSocket(9000);
        byte[] receivedata= new byte[15];
        byte[] senddata= new byte[15];
        System.out.println("Server is running..."); 
        System.out.println("Server is waiting for a msg from client... ");
        while(true) {
            BufferedReader user = new BufferedReader(new InputStreamReader(System.in));
            DatagramPacket receivepacket = new DatagramPacket(receivedata,receivedata.length);
            datagramsocket.receive(receivepacket);
            String data = new String(receivepacket.getData());
            System.out.println("client data : "+data);
            InetAddress ClientIpAddress = receivepacket.getAddress();
            int port = receivepacket.getPort(); 
            System.out.println("Enter the msg to send to client...");
            String datatosend = user.readLine();
            senddata = datatosend.getBytes();
            DatagramPacket tosendtoclient = new DatagramPacket(senddata,senddata.length,ClientIpAddress,port);
            datagramsocket.send(tosendtoclient);

        }
    }
}