package QuizKamp;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    Database d = new Database();
    
    public Server() {
        System.out.println("Commit 3");
        System.out.println("Richard testar");
        int portNr = 55556; 
        
        try (
            ServerSocket serverSocket = new ServerSocket(portNr);
            Socket clientSocket = serverSocket.accept();
            PrintWriter out = 
                    new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(clientSocket.getInputStream()));
            ){
            
            String inputLine;
            
            out.println(d.f1[0]+ " (" + d.f1[1]+ " " + d.f1[2]
                        + " " + d.f1[3]+ " " + d.f1[4] + "):");
            
            while((inputLine= in.readLine()) != null)  {
                System.out.println("Getting message: " + inputLine);
                
                if(inputLine.equalsIgnoreCase(d.f1[5]))  {
                    out.println("Du hade rätt!");
                }
                else    {
                    out.println("Det var inte korrekt svar.");
                }
            }
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
    
    
    
    
    public static void main(String[] args) {
        Server s = new Server();
    }
}
