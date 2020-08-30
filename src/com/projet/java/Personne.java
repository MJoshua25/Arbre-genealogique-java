package com.projet.java;


import java.io.Serializable;
import java.util.LinkedList;

public class Personne implements Serializable {
    String nom;
    String prenoms;
    String sexe;
    String statut;
    Personne parent;
    Integer age;
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


    public Personne(String nom, String prenoms, String sexe, Integer age){

        this.nom = nom;
        this.prenoms = prenoms;
        this.sexe = sexe;
        this.age = age;
        this.parent = null;
        this.freres = new LinkedList<>();
        this.enfants = new LinkedList<>();
    }
    public Personne(String nom, String prenoms, String sexe, Personne parent, Integer age){

        this.nom = nom;
        this.prenoms = prenoms;
        this.sexe = sexe;
        this.age = age;
        this.parent = parent;
        this.freres = new LinkedList<>();
        this.enfants = new LinkedList<>();
    }

    public void addEnfant(Personne enfant){
        this.enfants.add(enfant);
        enfant.parent = this;
    }

    @Override
    public String toString() {
        return nom + " " + prenoms + '(' + sexe + ')' ;
    }
}
