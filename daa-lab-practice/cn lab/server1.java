import java.io.*;
import java.net.*;
public class server1 {
    public static void main(String [] args) throws Exception {
        ServerSocket socket = new ServerSocket(4000);
        System.out.println("server is ready for the connection");
        Socket sock = socket.accept();
        System.out.println("connection succesfull");
        InputStream istream = sock.getInputStream();
        String fname;
        BufferedReader fileread = new BufferedReader(new InputStreamReader(istream));
        fname =  fileread.readLine();
        BufferedReader contentread = new BufferedReader(new FileReader(fname));
        OutputStream ostream = sock.getOutputStream();
        String str;
        PrintWriter pwrite = new PrintWriter(ostream, true);
        while((str = contentread.readLine()) != null){
            pwrite.println(str);
        }
        sock.close();
        socket.close();
        fileread.close();
        pwrite.close();
        System.out.println("file sent successfully");
    }
}