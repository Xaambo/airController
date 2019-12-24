package com.company;

public class Misil {

    private String nom;
    private int dany;
    private int radiExplosio;
    private int distanciaDispar;
    private int tempsDesplegament;

    public Misil(String nom, int dany, int radiExplosio, int distanciaDispar, int tempsDesplegament) {
        this.nom = nom;
        this.dany = dany;
        this.radiExplosio = radiExplosio;
        this.distanciaDispar = distanciaDispar;
        this.tempsDesplegament = tempsDesplegament;
    }

    public int getDistanciaDispar() {
        return distanciaDispar;
    }

    public String getNom() {
        return nom;
    }
}
