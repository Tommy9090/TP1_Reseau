import java.net.*;
import java.io.*;
import java.util.Date;

public class Serveur {
    private Socket socket = null;
    private ServerSocket server = null;
    public Serveur(int port) {
        try {
            server = new ServerSocket(port);

            System.out.println("En attente d'une connexion");
            socket = server.accept();

            System.out.println("Client connecter");

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream());

            String line;
            while ((line = in.readLine()) != null) {
                if (line.length() == 0)
                    break;
                out.print(line + "\r\n");
            }
            Date today = new Date();
            out.print("Date: " + today);

            out.close();
            in.close();
            socket.close();
            System.out.println("Connection fermer");

        } catch (IOException e) {
            System.out.println(e);
        }
    }
}