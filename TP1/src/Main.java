import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] argv){
        try{
            InetAddress ip = InetAddress.getByName("jmarshall.com");
            Client c = new Client(ip.getHostAddress(),80);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
