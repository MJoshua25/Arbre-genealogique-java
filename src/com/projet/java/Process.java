package com.projet.java;

import java.util.LinkedList;
import java.util.Scanner;

public class Process {
    private static Scanner clavier;

    ArbreGenealogique arbreGenealogique = null;
    Personne focus = null;


    //METHODE STATIQUE POUR AFFICHER UNE LES DONNÉES D'UNE LISTE
    private static void afficherListe(LinkedList<Personne> liste, int num, String msg_error, String mode){
        if ("Suivi".equals(mode)) {
            if (!liste.isEmpty()) {
                affichage(num + " - Resultat:\n\n");
                liste.forEach(element -> {
                    if (element != liste.getLast())
                        affichage(element + " -> ");
                    else {
                        affichage(element + "\n\n");
                    }
                });
                affichage("Appuyez sur une touche pour quitter.... ");
                new Scanner(System.in).nextLine();
            } else {
                //Sinon
                affichage(num + " - Resultat:\n\n");
                affichage(msg_error + "\n\n");
                affichage("Appuyez sur une entrer pour quitter.... ");
                new Scanner(System.in).nextLine();
            }
        } else {
            if (!liste.isEmpty()) {
                affichage(num + " - Resultat:\n\n");
                liste.forEach(element -> {
                    affichage("\t" + element + "\n\n");
                });
                affichage("Appuyez sur une touche pour quitter.... ");
                new Scanner(System.in).nextLine();
            } else {
                //Sinon
                affichage(num + " - Resultat:\n\n");
                affichage(msg_error + "\n\n");
                affichage("Appuyez sur une entrer pour quitter.... ");
                new Scanner(System.in).nextLine();
            }
        }
        //On vérifie que la liste n'est pas vide

    }

    public static void affichage(Object obj){
        System.out.print(obj);
    }


    public void setTree(ArbreGenealogique arb){
        this.arbreGenealogique = arb;
        this.menuGestionFamille();
    }

    public void mainMenu(){
        int repeter = 1;
        do {
            affichage("  Menu  Principale\n\n");
            affichage(" 1 - Creer un arbre \n");
            affichage(" 2 - Choisir un arbre existant \n");
            affichage(" 0 - Quitter \n\n");
            affichage("Choisissez une option... ");
            String option = new Scanner(System.in).next();
            switch (option) {
                case "1":
                    this.arbreGenealogique = new ArbreGenealogique(new Personne("New"));
                    break;
                case "2":
                    affichage("en cours");
                    break;
                case "0":
                    repeter = 0;
                    break;
                default:
                    break;
            }
        }while (repeter!=0);
    }

    public void menuGestionFamille(){

    }
}
