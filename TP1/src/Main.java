import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] argv){
        try{
            InetAddress ip = InetAddress.getByName("robdangero.us");
            Client c = new Client("192.168.2.249",80); //ip.getHostAddress(), 80
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
