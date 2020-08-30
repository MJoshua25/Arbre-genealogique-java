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
