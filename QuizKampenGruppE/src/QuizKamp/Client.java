package QuizKamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class Client {

    Client()   {
    	
        String hostName = "127.0.0.1";
        int portNr = 55556;

        try  (
            Socket clientSocket = new Socket(hostName, portNr);
            PrintWriter out = 
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            ){
            String fromServer;
            String toServer;
            
            BufferedReader userIn = new BufferedReader(
                    new InputStreamReader(System.in));
            
            while((fromServer = in.readLine()) != null) {
                System.out.println("Server: " + fromServer);
                
                toServer = userIn.readLine();
                System.out.println("Klient: " + toServer);
                out.println(toServer);
            }
            
        }catch(IOException e)    {
            e.printStackTrace();
        }
              
   }
    public static void main(String[] args) {
            Client k = new Client();
    }
}
