
import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class Client {
    
        private Socket socket = null;
        private BufferedReader input = null;
        private DataOutputStream out = null;

        public Client(String address, int port){ 
            
            
            try{
                Socket socket = new Socket(address, port);
                System.out.println("Conectado!");
                System.out.print("Digite uma mensagem: ");
                input = new BufferedReader(new InputStreamReader(System.in));
                out = new DataOutputStream(socket.getOutputStream());
                
            }catch(UnknownHostException u){
                System.out.println(u);

            }catch(IOException i){
                System.out.println(i);
            }
        
            String line = "";
            while(!line.equals("exit")){
                try {
                    line = input.readLine();
                    out.writeUTF(line); 
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
        Client client = new Client("127.0.0.1", 9000);
    }
}