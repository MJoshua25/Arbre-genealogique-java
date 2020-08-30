package com.projet.java;


import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class Personne implements Serializable {
    String nom;
    String prenoms;
    String sexe;
    String statut;
    Personne parent;
    LinkedList<Personne> enfants;
    LinkedList<Personne> freres;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenoms() {
        return prenoms;
    }

    public void setPrenoms(String prenoms) {
        this.prenoms = prenoms;
    }

    public String getSexe() {
        return sexe;
    }

    public void setSexe(String sexe) {
        this.sexe = sexe;
    }


    public Personne(String nom, String prenoms, String sexe){

        this.nom = nom;
        this.prenoms = prenoms;
        this.sexe = sexe;
        this.parent = null;
        this.freres = new LinkedList<>();
        this.enfants = new LinkedList<>();
    }
    public Personne(String nom, String prenoms, String sexe, Personne parent){

        this.nom = nom;
        this.prenoms = prenoms;
        this.sexe = sexe;
        this.parent = parent;
        this.freres = new LinkedList<>();
        this.enfants = new LinkedList<>();
    }
}
