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

    public void addMember(){
        Process.affichage("Choisissez son parent\n");
        for (int i = 0; i<this.getMembers().size(); i++){
            Process.affichage(i + "- " + this.getMembers().get(i) + "\n");
        }
        Process.affichage(this.getMembers().size() + "- Nouveau root");

    }
}
