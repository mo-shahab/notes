import java.net.*;
import java.io.*;
public class client {
    public static void main(String [] args) throws Exception{
        Socket sock = new Socket("127.0.0.1", 4000);
        System.out.println("client is online");
        System.out.println("enter the file name");
        BufferedReader keyread = new BufferedReader(new InputStreamReader(System.in));
        String fname = keyread.readLine();
        OutputStream ostream = sock.getOutputStream();
        PrintWriter pwrite = new PrintWriter(ostream, true);
        pwrite.println(fname);
        InputStream istream = sock.getInputStream();
        BufferedReader socketread = new BufferedReader(new InputStreamReader(istream));
        String str;
        System.out.println("file is received!!!");
        System.out.println("content of the file is:");
        while((str = socketread.readLine()) != null){
            System.out.println(str);
        }
        pwrite.close(); socketread.close(); keyread.close();
    }
}