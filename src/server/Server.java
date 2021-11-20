package server;

import model.Compte;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server extends Thread {
    public static List<Compte> comptes = new ArrayList<Compte>();
    int port = 4000;
    static ServerSocket serverSocket;
    static Socket socket;

    public Server() throws IOException {
        this.serverSocket =new ServerSocket(port);
        this.socket =serverSocket.accept();
    }

    public static void main(String[] args) throws IOException {

        comptes=new ArrayList<Compte>();

        try {
            serverSocket = new ServerSocket(4000);

            while(true) {
                socket =serverSocket.accept();
                Traitement traitement =new Traitement(socket);
                traitement.start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
