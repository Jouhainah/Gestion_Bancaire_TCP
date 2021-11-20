package model;

import java.util.ArrayList;
import java.util.List;

public class Compte {

    static int id = 0;
    int numCompte;
    private String nom ;
    private double solde;
    //List<String> operations = new ArrayList<>();

    public Compte() {
    }

    public Compte(String nom, double solde) {
        id++;
        this.numCompte = id;
        this.nom = nom;
        this.solde = solde;
    }

    public int getNumCompte() {
        return numCompte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    // public List<String> getOperations() {
    // return operations;
    // }

    //public void setOperations(List<String> operations) {
    // this.operations = operations;
    //  }
}
