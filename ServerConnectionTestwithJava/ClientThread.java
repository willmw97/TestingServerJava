

//Class ClientThread is meant to mimick the client side of a network

import java.io.*;
import java.net.*;

public class ClientThread extends Thread
{
   private ServerSocket serversocket;
   
   public ClientThread(){};

//run method
   public void run()
   {   
      try{
      //establish socket connection to server
         Socket socket = new Socket("localhost", 5000);
         PrintWriter out = null;
         BufferedReader in = null;
         //out is a outputstream
         out = new PrintWriter(socket.getOutputStream());
         //in is input stream
         in =  new BufferedReader(new InputStreamReader(socket.getInputStream()));
         //reads in line as string
         String response = in.readLine();
         System.out.println("Client" + response);
         
         int num = 0;
      
         String serverResponse = null;
         //cycles 50 times
         for(int i = 0;i<=50;i++)
         {
            num += 1;//add one every time
            System.out.println(num+" Client");//prints that its client
            out.println(num);//output to line
            out.flush();//flush
            num = Integer.parseInt(in.readLine());
         }
         //close out of all streams           
         out.close();
         in.close();
         socket.close();
      
      }
      catch(Exception e){};
   
   }
}