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

    public void alcada(Coordenada desti, ArrayList<Avio> avions) {

        if (!controlCollisio(avions, desti)) {
            posicioRumb.setY(desti.getY());
        }
    }

    public void moviment(Coordenada desti, ArrayList<Avio> avions) {

        if (!controlCollisio(avions , desti)) {
            posicioRumb = desti;
        }
    }

    public boolean controlCollisio(ArrayList<Avio> avions, Coordenada desti) {

        boolean collisio = false;

        int x = desti.getX();
        int xBase;
        int y = desti.getY();
        int yBase;
        int z = desti.getZ();
        int zBase;

        double distancia;
        double distanciaTemp;

        Coordenada coordAvioIterant = avions.get(0).getPosicioRumb();

        xBase = coordAvioIterant.getX();
        yBase = coordAvioIterant.getY();
        zBase = coordAvioIterant.getZ();

        distancia = Math.sqrt(Math.pow((xBase - x), 2) + Math.pow((yBase - y), 2) + Math.pow((zBase - z), 2));

        for (int i = 0; i < avions.size(); i++) {

            coordAvioIterant = avions.get(i).getPosicioRumb();

            xBase = coordAvioIterant.getX();
            yBase = coordAvioIterant.getY();
            zBase = coordAvioIterant.getZ();

            distanciaTemp = Math.sqrt(Math.pow((xBase - x), 2) + Math.pow((yBase - y), 2) + Math.pow((zBase - z), 2));

            if (distanciaTemp < distancia) {
                distancia = distanciaTemp;
            }
        }

        /*for (xBase = (x-1); (xBase <= (x+1)) && !collisio; xBase++) {
            for (yBase = (y-1); (yBase <= (y+1)) && !collisio; yBase++) {
                for (zBase = (z-1); (zBase <= (z+1)) && !collisio; zBase++) {
                    for (int i = 0; (i < avions.size()) && !collisio; i++) {

                        Coordenada coordAvioIterant = avions.get(i).getPosicioRumb();

                        if (coordAvioIterant.getX() == xBase && coordAvioIterant.getY() == yBase && coordAvioIterant.getZ() == zBase) {
                            collisio = true;
                        }
                    }
                }
            }
        }*/

        return collisio;
    }
}
