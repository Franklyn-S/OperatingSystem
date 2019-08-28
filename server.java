import java.net.ServerSocket;

public class server {
    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(9000);
            System.out.println("Servidor ouvindo a porta 9000");

            server.close()
        }catch(Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}