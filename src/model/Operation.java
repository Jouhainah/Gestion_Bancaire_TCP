package model;

import java.util.Date;

public class Operation {


    public String toString() {
        return "Operation [date=" + date + ", type=" + type + ", nomClient=" + nom + ", montant=" + montant
                + "]";
    }
    Date date ;
    String type ;
    String nom ;
    double montant ;
    public Operation() {
    }
    public Operation(Date date, String type, String nom, double montant) {
        super();
        this.date = date;
        this.type = type;
        this.nom = nom;
        this.montant = montant;
    }
    public Operation(Date date) {
        super();
        this.date = date;

    }
    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getNomClient() {
        return nom;
    }
    public void setNomClient(String nom) {
        this.nom = nom;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }



}