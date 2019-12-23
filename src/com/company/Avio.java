package com.company;

import java.util.ArrayList;

public abstract class Avio {

    Print print = new Print();
    cLector teclat = new cLector();

    private static int DISTANCIASEGURETAT = 15;

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
    private boolean xifrat = false;

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

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getTripulacio() {
        return tripulacio;
    }

    public Coordenada getPosicioRumb() {
        return posicioRumb;
    }

    public void setPosicioRumb(Coordenada posicioRumb) {
        this.posicioRumb = posicioRumb;
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

    public boolean getMotor() {
        return motor;
    }

    public boolean getDeCombat() {
        return deCombat;
    }

    public boolean getTrenAterratge() {
        return trenAterratge;
    }

    public boolean isXifrat() {
        return xifrat;
    }

    public void setXifrat(boolean xifrat) {
        this.xifrat = xifrat;
    }

    /** METODES */

    public abstract Avio enlairarse(Avio avio, ArrayList<Avio> avions);

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

    public Avio alcada(Coordenada desti, ArrayList<Avio> avions) {

        desti.setX(posicioRumb.getX());
        desti.setY(posicioRumb.getY());

        if (!controlCollisio(avions, desti)) {
            posicioRumb.setZ(desti.getZ());
            print.alcadaDone();
        }

        return this;
    }

    public void moviment(Coordenada desti, ArrayList<Avio> avions) {

        int x = teclat.llegirEnter("On vols anar?(X) ");
        int y = teclat.llegirEnter("On vols anar?(Y) ");

        desti.setX(x);
        desti.setY(y);
        desti.setZ(posicioRumb.getZ());

        if (!controlCollisio(avions , desti)) {
            posicioRumb = desti;
            print.movimentDone();
        } else {
            print.errorPilot();
        }
    }

    public boolean controlCollisio(ArrayList<Avio> avions, Coordenada desti) {

        boolean collisio = false;

        int x = desti.getX();
        int xAvioIterant;
        int y = desti.getY();
        int yAvioIterant;
        int z = desti.getZ();
        int zAvioIterant;

        double distancia;
        double distanciaTemp;

        Coordenada coordAvioIterant = avions.get(0).getPosicioRumb();

        xAvioIterant = coordAvioIterant.getX();
        yAvioIterant = coordAvioIterant.getY();
        zAvioIterant = coordAvioIterant.getZ();

        distancia = Math.sqrt(Math.pow((xAvioIterant - x), 2) + Math.pow((yAvioIterant - y), 2) + Math.pow((zAvioIterant - z), 2));

        for (int i = 0; i < avions.size(); i++) {
            if (avions.get(i) != this) {
                coordAvioIterant = avions.get(i).getPosicioRumb();

                xAvioIterant = coordAvioIterant.getX();
                yAvioIterant = coordAvioIterant.getY();
                zAvioIterant = coordAvioIterant.getZ();

                distanciaTemp = Math.sqrt(Math.pow((xAvioIterant - x), 2) + Math.pow((yAvioIterant - y), 2) + Math.pow((zAvioIterant - z), 2));

                if (distanciaTemp <= distancia) {
                    distancia = distanciaTemp;
                }
            }
        }

        if (distancia < DISTANCIASEGURETAT) {
            collisio = true;
        }

        /*for (xAvioIterant = (x-1); (xAvioIterant <= (x+1)) && !collisio; xAvioIterant++) {
            for (yAvioIterant = (y-1); (yAvioIterant <= (y+1)) && !collisio; yAvioIterant++) {
                for (zAvioIterant = (z-1); (zAvioIterant <= (z+1)) && !collisio; zAvioIterant++) {
                    if (coordAvioMesProper.getX() == xAvioIterant && coordAvioMesProper.getY() == yAvioIterant && coordAvioMesProper.getZ() == zAvioIterant) {
                        collisio = true;
                    }
                }
            }
        }*/

        return collisio;
    }
}
