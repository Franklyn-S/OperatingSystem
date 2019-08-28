import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;
import java.nio.charset.Charset;

public class Client {
    
        private Socket socket = null;
        private BufferedReader input = null;
        private BufferedOutputStream out = null;

        public Client(String address, int port){ 
            System.out.println("Conectado!");
            System.out.print("Digite uma mensagem: ");
            
            try{
                input = new BufferedReader(new InputStreamReader(System.in));
                out = new BufferedOutputStream(socket.getOutputStream());
                
            }catch(UnknownHostException u){
                System.out.println(u);

            }catch(IOException i){
                System.out.println(i);
            }
        
            String line = "";
            while(!line.equals("exit")){
                try {
                    line = input.readLine();
                    out.write(line.getBytes(Charset.forName("UTF-8")));
                }catch(IOException i) {
                    System.out.println(i);
                }
            }

            System.out.println("Fechando conexão!");
            try {
                input.close();
                out.close();
                socket.close();
            }catch(IOException i) {
                System.out.println(i);
            }
        }
    public static void main(String[] args) {
        Client client = new Client("localhost", 9000);
    }
}