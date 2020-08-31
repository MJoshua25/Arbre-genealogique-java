package com.projet.java;

import java.io.*;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class ArbreGenealogique implements Serializable {
    private static LinkedList<LinkedList<Personne>>arbres = new LinkedList<>();
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
    public void saveTree(Personne root){
        //On ajoute ici la racine à un grand arbre qui contient tous les arbres crées
        /*La classe LinkedListe est une classe sérializable elle va nous permettre de stocker plusieurs objets au lieu
        d'un seul.
        */

        //On recupère les données pré-sauvegardées
        getTrees();
        //Pour changer l'affichage
        boolean exist= false;
        //On verifie si l'arbre se trouve dans le fichier data.txt
        if(existTree(this.root)){
            exist = true;
            Iterator<Personne> it = arbres.iterator();
            while( it.hasNext() ) {

                Personne pers = it.next();
                //On ecrase l'ancienne valeur de l'arbre du root
                if( pers.getId().toString().equals(root.getId().toString())) {
                    it.remove();
                }

            }
//            for (Personne pers:arbres
//            ) {
//                //On ecrase l'ancienne valeur de l'arbre du root
//                if (pers.getId().toString().equals(root.getId().toString())){
//                    arbres.remove(pers);
//                }
//            }
            //On ajoute la nouvelle à la liste des arbres
            arbres.add(root);

            //On efface le contenu du fichier
            PrintWriter pw = null; // >>>> on ajoutera après suppression de ce qui existait éventuellement
            try {
                pw = new PrintWriter(new BufferedWriter
                        (new FileWriter("data.txt", false)));
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.print("");
            pw.close();
        }else {
            //On ajoute le root à la liste des arbres
            arbres.add(this.getMembers());
        }

        File fichier = new File("data.txt");
        ObjectOutputStream oos = null;
        try {
            // ouverture d'un flux de sortie sur data.txt
            oos = new ObjectOutputStream(new FileOutputStream(fichier));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //sérialization de l'objet et sauvegarde dans le fichier data.txt
        try {
            oos.writeObject(arbres);
            oos.close();
            if(exist)
                Fonctionnalite.affichage("Sauvegarde de l'Arbre....ok\n");
            else {
                Fonctionnalite.affichage("Création de l'arbre....ok\n");
            }

        } catch (IOException e) {
            Fonctionnalite.affichage("Erreur dans la sauvegarde de l'arbre\n");
            e.printStackTrace();
        }

    }

    public static LinkedList<Personne> getTrees(){
        File fichier =  new File("data.txt");
        LinkedList<Personne> arbre = new LinkedList<>();
        try {
            // ouverture d'un flux d'entrée sur data.txt
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fichier));
            try {
                //On recupère les arbres
                arbre =  (LinkedList<Personne>) ois.readObject();
                arbres = arbre;
            }catch (Exception e){
                System.out.print("Aucun objet");
            }
        }catch (Exception e){
            System.out.print("Aucun objet");
        }
        return arbre;
    }
}
