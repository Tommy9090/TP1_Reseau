import java.net.*;
import java.io.*;

public class Main {
    public static void main(String[] argv){
        try{
            InetAddress ip = InetAddress.getByName("tommybart.ddns.net"); //robdangero.us
            Client c = new Client("206.41.87.6", 12080); //ip.getHostAddress(), 80
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
}
