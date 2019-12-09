package com.company;

import java.util.ArrayList;

public abstract class Avio {

    private String matricula;
    private String marca;
    private String model;
    private int tripulacio;
    private Coordenada posicioRumb;
    private int velocitat = 0;
    private int autonomia = 3000;
    private boolean motor = false;
    private boolean trenAterratge = true;
    private boolean deCombat;

    public Avio(String matricula, String marca, String model, int tripulacio, Coordenada posicioRumb, boolean deCombat) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.tripulacio = tripulacio;
        this.posicioRumb = posicioRumb;
        this.deCombat = deCombat;
    }

    /** GETTERS I SETTERS */

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public int getTripulacio() {
        return tripulacio;
    }

    public Coordenada getPosicioRumb() {
        return posicioRumb;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public int getAutonomia() {
        return autonomia;
    }

    /** METODES */

    public abstract void enlairarse();

    public boolean getMotor() {
        return motor;
    }

    public boolean getDeCombat() {
        return deCombat;
    }

    public boolean getTrenAterratge() {
        return trenAterratge;
    }

    public void encendreMotor() {
        this.motor = true;
    }

    public void apagarMotor() {
        this.motor = false;
    }

    public void baixarTren() {
        this.trenAterratge = true;
    }

    public void pujarTren() {
        this.trenAterratge = false;
    }

    public void alcada(int metres, ArrayList<Avio> avions) {

        if (!controlCollisio(avions)) {
            posicioRumb.setY(metres);
        }
    }

    public void moviment(int metres, ArrayList<Avio> avions) {

        if (!controlCollisio(avions)) {
            posicioRumb.setY(metres);
        }
    }

    public boolean controlCollisio(ArrayList<Avio> avions) {

        boolean collisio = false;



        return collisio;
    }
}
