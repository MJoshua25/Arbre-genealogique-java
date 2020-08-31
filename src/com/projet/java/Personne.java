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
            System.out.print("Entrer l'age: ");
            this.age = sc.nextInt();
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

    public void setFreres(LinkedList<Personne> freres) {
        this.freres = freres;
    }

    public LinkedList<Personne> getAscendant(){
        if (this.parent!=null){
            LinkedList<Personne> aux = parent.getAscendant();
            aux.add(this.parent);
            return aux;
        } else {
            return new LinkedList<Personne>();
        }
    }

    public void setFreres(Personne frere){
        if (this.freres.size() == 0){
            this.freres.add(frere);
        } else if (this.freres.get(0).age < frere.age) {
            this.freres.add(0, frere);
        } else if (this.freres.get(this.freres.size() -1).age > frere.age){
            this.freres.add(frere);
        } else {
            int i =0;
            while (this.freres.get(i).age > frere.age){
                i++;
            }
            freres.add(i, frere);
        }
    }

    public void setEnfants(LinkedList<Personne> enfants) {
        this.enfants = enfants;
    }

    public void setEnfants(Personne enfant){
        if (this.enfants.size() == 0){
            this.enfants.add(enfant);
        } else if (this.enfants.get(0).age < enfant.age) {
            this.enfants.add(0, enfant);
        } else if (this.enfants.get(this.enfants.size() -1).age > enfant.age){
            this.enfants.add(enfant);
        } else {
            int i =0;
            while (this.enfants.get(i).age > enfant.age){
                i++;
            }
            enfants.add(i, enfant);
        }
    }

    public void addEnfant(Personne enfant){
        if (enfant.equals(this))
            Process.affichage("Impossible de s'ajouter soit même comme enfant \n");
        else if (this.enfants.contains(enfant)){
            Process.affichage("Impossible d'ajouter 2 fois le même enfant \n");
        }
        else {
            for (Personne frere : this.enfants) {
                frere.setFreres(enfant);
            }
            this.setEnfants(enfant);
            enfant.parent = this;
        }
    }

    public Integer getNbSpace() {

        Personne actu = this;
        if (actu.parent!=null){
            return actu.parent.getNbSpace() + 2;
        } else {
            return 0;
        }
    }

    public void afficheEnfant(){
        this.enfants.forEach(enfant-> {
            Process.affichage(enfant  + "\n");
        });
    }

    @Override
    public String toString() {
        return nom + " " + prenoms + '(' + sexe + ')' ;
    }
}
