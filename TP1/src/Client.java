import java.net.*;
import java.io.*;
import java.util.Objects;

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

            String line = "";
            while(!line.equals("FIN")){
                try{
                    line = in.readLine();

                    if(Objects.equals(line, "FIN"))
                    {
                        out.writeUTF(line);
                    }

                    //"GET" OU "HEAD"
                    EnterCommand(line);
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

    private void EnterCommand(String line){
        switch (line){
            case "GET":
                try{
                    writer = new PrintWriter(socket.getOutputStream());
                    writer.print("GET / HTTP/1.0\r\n");
                    writer.print("HOST: 206.41.87.6\r\n\r\n"); //robdangero.us
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
            case "HEAD":
                try{
                    writer = new PrintWriter(socket.getOutputStream());
                    writer.print("HEAD / HTTP/1.0\r\n");
                    writer.print("HOST: 206.41.87.6\r\n\r\n"); //robdangero.us
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
            case "PUT":
                try{
                    writer = new PrintWriter(socket.getOutputStream());
                    writer.print("PUT /new.html HTTP/1.0\r\n");
                    writer.print("HOST: 206.41.87.6\r\n\r\n");
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