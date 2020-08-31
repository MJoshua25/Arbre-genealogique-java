package com.projet.java;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class ArbreGenealogique implements Serializable {
    Personne root;
    private LinkedList<Personne> members = new LinkedList<Personne>();

    public LinkedList<Personne> getMembers() {
        return getListemembers(root, new LinkedList<Personne>());
    }

    public LinkedList<Personne> getListemembers(Personne start, LinkedList<Personne> liste){
        liste.add(start);
        start.enfants.forEach(enfant->{
            getListemembers(enfant, liste);
        });
        return liste;
    }

    public ArbreGenealogique(Personne first){
        this.root = first;
    }

    public void afficheArbre(Personne membre, Integer space){
        Process.affichage(Process.setSpace(space) + membre + "\n" );
        membre.enfants.forEach(enfant ->{
            afficheArbre(enfant, space+2);
        });
    }

    public Personne getMember(){
        Process.affichage("Choisissez le membre :\n");
        for (int i = 0; i<this.getMembers().size(); i++){
            Process.affichage(i + "- " + this.getMembers().get(i) + "\n");
        }
        Process.affichage("Veuillez choisir une option... ");
        Integer option = new Scanner(System.in).nextInt();
        return this.getMembers().get(option);
    }

    public void addMember(){
        Process.affichage("Choisissez son parent\n");
        for (int i = 0; i<this.getMembers().size(); i++){
            Process.affichage(i + "- " + this.getMembers().get(i) + "\n");
        }
        Process.affichage(this.getMembers().size() + "- Nouveau root \n");
        Process.affichage("Veuillez choisir une option... ");
        Integer option = new Scanner(System.in).nextInt();
        if (option < this.getMembers().size()){
            this.getMembers().get(option).addEnfant(new Personne("New"));
        } else {
            Personne newRoot = new Personne("New");
            newRoot.addEnfant(this.root);
            this.root = newRoot;
        }

    }
}
