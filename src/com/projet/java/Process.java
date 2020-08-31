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

    public static String setSpace(Integer nb){
        return new String(new char[nb]).replace("\0", " ");
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
                    this.setTree(new ArbreGenealogique(new Personne("New")));
                    break;
                case "2":
                    this.selectTree();
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
        int repeat = 1;
        do {
            affichage("**** - Arbre Généalogique de la famille "+this.arbreGenealogique.root.getNom()+" ****");
            affichage("\n\n  1 - ajouter un membre à la famille \n");
            affichage("  2 - Lister les membres de la famille\n" );
            affichage("  3 - Selectionner un membre de la famille\n" );
            affichage("  0 - Retour \n\n" );
            affichage("Veuillez choisir une option... ");

            String option = new Scanner(System.in).next();
            affichage("\n");
            switch (option) {
                case "1":
                    this.arbreGenealogique.addMember();
                    break;
                case "2":
                    this.arbreGenealogique.afficheArbre(this.arbreGenealogique.root, 0);
                    break;
                case "3":
                    this.focus = this.arbreGenealogique.getMember();
                    this.menuGestionPersonne();
                    break;
                case "0":
                    this.arbreGenealogique.saveTree();
                    repeat = 0;
                    break;

                default:
                    break;
            }
        }while (repeat!=0);
    }

    public void menuGestionPersonne(){
        int repeat = 1;
        do {
            affichage("**** - Arbre Généalogique de " + focus.getNom() + " " + focus.getPrenoms() + " ****");
            affichage("\n\n  1 - Modifier les informations" + "\n");
            affichage("  2 - Lister les enfants" + "\n");
            affichage("  3 - Lister les freres (ou soeurs)" + "\n");
            affichage("  4 - Lister les ascendants" + "\n\n");
            affichage("  5 - Ajouter un enfant \n" );

            if(focus.parent ==null) {
                affichage("  7 - Ajouter un parent \n");
            } else {
                affichage("  8 - Afficher le parent \n");
            }

            affichage("  0 - Retour \n\n");
            affichage("Veuillez choisir une option... ");
            String option = new Scanner(System.in).next();
            affichage("\n");

            switch (option){
                case"1":
                    this.focus.modifierInfo();
                    break;
                case"2":
                    //Afficher la liste des enfants
                    afficherListe(focus.enfants,2,"Aucun enfant enregistré","Suivi");
                case"3":
                    afficherListe(focus.freres,3,"Aucun frère enregistré","Normal");
                    break;
                case"4":
                    afficherListe(focus.getAscendant(),4,"Aucun acsendant enregistré","Normal");
                    break;
                case"5":
                    this.focus.setEnfants(new Personne("New"));
                    break;
                case"8":
                    Personne parent = new Personne("New");
                    this.arbreGenealogique.root.parent =parent;
                    this.arbreGenealogique.root = parent;
                    break;
                case "0":
                    repeat = 0;
                    break;
                default:
                    break;
            }
        }while (repeat!=0);
    }

    // METHODE STATIQUE PERMETTANT DE SELECTIONNER UN ARBRE PREALABLEMENT ENREGISTRÉ
    public void selectTree(){
        int repeter = 1;
        while(repeter!=0) {
            affichage("Liste des arbres");
            int i = 1;
            if (!(ArbreGenealogique.getTrees().isEmpty())){
                LinkedList<LinkedList<Personne>> arbres = ArbreGenealogique.getTrees();
                for (LinkedList<Personne> arbre: arbres
                ) {
                    affichage("\t"+i+" -"+arbre.get(0)+"\n");
                    i++;
                }
                affichage("\nVeuillez selectionner un Arbre (ou 0 pour annuler) ... ");
                String choix = new Scanner(System.in).nextLine();
                affichage("\n");
                try{
                    int choix1 = Integer.parseInt(choix);
                    if(choix1 < i && choix1!=0){
                        this.arbreGenealogique = new ArbreGenealogique(arbres.get(choix1-1));
                        this.menuGestionFamille();
                    }else if(choix1 == 0)
                        repeter = 0;
                    else {
                        affichage("Mauvais choix veuillez recommencer !\n");
                    }

                }catch (Exception e){
//                    e.printStackTrace();
                    affichage("Mauvaise saisie veuillez recommencer !\n");
                }

            }else {
                repeter = 0;
                affichage("Vous n'avez pas encore renseigné d'arbres!\n");
            }
        }
    }
}
