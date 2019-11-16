/*
Author: Marshal
Program: Program will exchange between a server and client while counting 50 values.
This is meant to showcase Java's networking functionality
*/
import java.net.*;
import java.io.*;

public class mainServer
{


   public static void main(String args[]) throws IOException
   {
      //create server then client
      ServerThread st = new ServerThread();
      ClientThread ct = new ClientThread();
   
      //start the threads
      st.start();
      ct.start();
      
   }


}