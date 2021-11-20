package client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        String hostname="127.0.0.1";
        int port= 4000;
        String message;
        String messageReceived;
        Socket ClientSocket = new Socket(hostname,port);
        while (true){
            BufferedReader inFromClient =new BufferedReader(new InputStreamReader(System.in));
            BufferedReader inFromServer = new BufferedReader(new InputStreamReader(ClientSocket.getInputStream()));
            PrintWriter outToServer = new PrintWriter(new BufferedWriter(new OutputStreamWriter(ClientSocket.getOutputStream())),true);
            message=inFromClient.readLine();
            outToServer.println(message);
            messageReceived=inFromServer.readLine();
            System.out.println(messageReceived);
        }
    }
}