package com.projet.java;

import java.io.Serializable;
import java.util.LinkedList;
import java.util.Scanner;

public class ArbreGenealogique implements Serializable {
    Personne root;

    public ArbreGenealogique(Personne first){
        this.root = first;
    }

    public ArbreGenealogique() {

    }
}
