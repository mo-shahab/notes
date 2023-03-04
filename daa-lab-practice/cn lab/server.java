import java.net.*;
import java.io.*;
public class server{
    public static void main(String [] args) throws Exception{
        ServerSocket sersock = new ServerSocket(4000);
        System.out.println("server ready for connection");
        Socket sock = sersock.accept();
        System.out.println("connection succesfull");
        InputStream istream = sock.getInputStream();
        BufferedReader fileread = new BufferedReader(new InputStreamReader(istream));
        String fname = fileread.readLine();
        OutputStream ostream = sock.getOutputStream();
        BufferedReader contentread = new BufferedReader(new FileReader(fname));
        String str;
        PrintWriter pwrite = new PrintWriter(ostream, true);
        while((str = contentread.readLine()) != null){
            pwrite.println(str);
        }
        sock.close(); sersock.close(); pwrite.close(); fileread.close();
        System.out.println("file sent successfully");
    }
}