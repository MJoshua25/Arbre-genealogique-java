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

}
