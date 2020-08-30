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
    public Personne(String option){
        if (option.equals("New")){
            Scanner sc = new Scanner(System.in);
            System.out.print("Entrer le nom: ");
            this.nom = sc.nextLine();
            System.out.print("Entrer le prenom: ");
            this.prenoms = sc.nextLine();
            while(true)
            {
                Process.affichage("\nSexe:\n 1. Masculin\n 2. Feminin\nChoix: ");

                int opt=Integer.parseInt(sc.next());
                if(opt==1)
                {
                    this.sexe = "Masculin";
                    break;
                }
                else if(opt==2)
                {
                    this.sexe = "Féminin";
                    break;
                }
                else
                {
                    Process.affichage("\nMauvais choix\nVeuiller recommencer...  ");
                }
            }
        }
        this.parent = null;
        this.freres = new LinkedList<>();
        this.enfants = new LinkedList<>();

    }

    public void addEnfant(Personne enfant){
        for (Personne frere:this.enfants) {
            frere.freres.add(enfant);
        }
        this.enfants.add(enfant);
        enfant.parent = this;
    }

    public void afficheEnfant(){
        this.enfants.forEach(
                Process.affichage(enfants);
        );
    }

    @Override
    public String toString() {
        return nom + " " + prenoms + '(' + sexe + ')' ;
    }
}
