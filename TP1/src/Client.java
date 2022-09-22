import java.net.*;
import java.io.*;

public class Client {
    private Socket socket = null;
    private DataInputStream in = null;
    private  DataOutputStream out = null;

    public Client(String address, int port){
        try{
            socket = new Socket(address, port);
            System.out.println("Connecter");

            in = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());

            DataInputStream In = new DataInputStream(System.in);

            String line = "";
            while(!line.equals("fini")){
                try{
                    line = in.readLine();
                    out.writeUTF(line);
                }
                catch (IOException i){
                    System.out.println(i);
                }
            }
            try{
                in.close();
                out.close();
                socket.close();
            }
            catch (IOException e){
                System.out.println(e);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }
}
