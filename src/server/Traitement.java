package server;

import model.Compte;
import model.Operation;

import java.io.*;
import java.net.*;
import java.util.*;

public class Traitement extends Thread {
    private Socket socket;
    String messageClient, msg = "";

    static List<Operation> operations = new ArrayList<Operation>();

    public Traitement(Socket socket) {

        this.socket = socket;
    }

    public void run() {
        try {

            BufferedReader inFromClient=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter outToClient=new PrintWriter(new BufferedWriter(new OutputStreamWriter(socket.getOutputStream())),true);
            Compte compte =new Compte();
            java.util.Date date=new java.util.Date();
            Operation operation=new Operation(date);

            while(true) {
                messageClient=inFromClient.readLine();
                String[] cmd=messageClient.split(" ");
                if(cmd[0].equalsIgnoreCase("CREATION")) {

                    compte.setNom(cmd[1]);
                    Server.comptes.add(compte);
                    msg="welcome "+compte.getNom()+", votre compte est créé avec succès !";
                    operation.setNomClient(compte.getNom());
                    operation.setType("création");
                }
                else if(cmd[0].equalsIgnoreCase("SOLDE")) {
                    operation.setType("solde");
                    operation.setMontant(compte.getSolde());
                    msg="votre solde est :"+compte.getSolde();
                }
                else if(cmd[0].equalsIgnoreCase("CREDIT")) {
                    double credit=Double.parseDouble(cmd[1]) ;
                    double Solde1 = compte.getSolde()+credit;
                    compte.setSolde(Solde1);
                    operation.setType("credit");
                    operation.setMontant(credit);
                    msg="Solde mis à jour avec succès";

                }
                else if(cmd[0].equalsIgnoreCase("DEBIT")) {

                    double debit=Float.parseFloat(cmd[1]) ;
                    double Solde1 = compte.getSolde()-debit;

                    if(Solde1 > 0) {
                        compte.setSolde(Solde1);
                        msg="Solde mis à jour avec succès";
                        operation.setType("debit");
                        operation.setMontant(debit);
                    }
                    else
                        msg="solde insffusant";
                }

                else {
                    msg="erreur ";
                }

                operations.add(operation);
                outToClient.println(msg);
                int i=0;
                System.out.println(operations.get(i).toString());
                i++;



            }}

        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
