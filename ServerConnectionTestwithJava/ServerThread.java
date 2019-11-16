//class ServerThread is meant to mimick the server side of a network

import java.net.*; 
import java.io.*; 

public class ServerThread extends Thread
{
   private ServerSocket serversocket;
   
   //consturctor sets port at 5000
   public ServerThread() throws IOException 
   {
      serversocket = new ServerSocket(5000);
      //serverSocket.setSoTimeout(10000);
   }

   private static void debug(String msg)
   {
      System.out.println("Server: " + msg);
   }

   public void run() 
   {
      try {
         System.out.println("Waiting for client on port ");
         //accepts socket conection
         Socket server = serversocket.accept();
         PrintWriter out = null;
         BufferedReader in = null;
         //create in and out streams
         out = new PrintWriter(server.getOutputStream());
         in =  new BufferedReader(new InputStreamReader(server.getInputStream())); 
         out.println("Started Thread"); 
         out.flush();//always flush your data
         
         int num = 0; 
         //continusly runs while it reads in and retuns values
         while(true)
         {
            //read line
            int result = Integer.parseInt(in.readLine());
            result += 1;//increments
            out.println(result);//uses output stream with the number
            out.flush();
            System.out.println(result+ " Server");//print result
            
            if(result == 50)
               break;
         }
         
         //closes streams   
         out.close();
         in.close();  
         server.close(); 
                      
      }catch (Exception e) {
         e.printStackTrace();
      }
      
   } 
}