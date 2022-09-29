import java.net.*;
import java.io.*;

public class Client {
    private Socket socket = null;
    private DataInputStream in = null;
    private  DataOutputStream out = null;

    private BufferedReader reader = null;
    private  PrintWriter writer = null;

    public Client(String address, int port){
        try{
            socket = new Socket(address, port);
            System.out.println("Connecter");

            in = new DataInputStream(System.in);
            out = new DataOutputStream(socket.getOutputStream());




//            writer = new PrintWriter(socket.getOutputStream());
//            writer.print("GET / HTTP/1.0\r\n");
//            writer.print("HOST: robdangero.us\r\n\r\n");
//            writer.flush();
//            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
//
//            String outString;
//
//            while ((outString = reader.readLine())!=null){
//                System.out.println(outString);
//            }

            String line = "";
            while(!line.equals("fini")){
                try{


                    line = in.readLine();
//                    out.writeUTF(line);

                    CommandReceive(line);

                }
                catch (IOException i){
                    System.out.println(i);
                }
            }
            try{
                in.close();
                out.close();
                socket.close();
                writer.close();
                reader.close();
            }
            catch (IOException e){
                System.out.println(e);
            }
        }
        catch (Exception e){
            System.out.println(e);
        }
    }


    private void CommandReceive(String line){
        switch (line){
            case "GET":
                try{
                    writer = new PrintWriter(socket.getOutputStream());
                    writer.print("GET / HTTP/1.0\r\n");
                    writer.print("HOST: robdangero.us\r\n\r\n");
                    writer.flush();
                    reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                    String outString;

                    while ((outString = reader.readLine())!=null){
                        System.out.println(outString);
                    }
                }
                catch (IOException e){
                    System.out.println(e);
                }
                break;
            default:
        }
    }
}
