package com.company;

import java.util.ArrayList;

public class Collisio {

    private double distancia;
    private ArrayList<Avio> avionsEnRang;

    public Collisio() {
    }

    public Collisio(double distancia, ArrayList<Avio> avionsEnRang) {
        this.distancia = distancia;
        this.avionsEnRang = avionsEnRang;
    }

    public double getDistancia() {
        return distancia;
    }

    public ArrayList<Avio> getAvionsEnRang() {
        return avionsEnRang;
    }

    public Collisio logicaCollisio(Avio avio, ArrayList<Avio> avions, Coordenada desti, int rang) {

        Collisio objCollisio;
        ArrayList<Avio> avionsEnRang = new ArrayList<>();

        int x = desti.getX();
        int xAvioIterant;
        int y = desti.getY();
        int yAvioIterant;
        int z = desti.getZ();
        int zAvioIterant;

        double distancia = rang;
        double distanciaTemp;

        Avio avioIterant;
        Coordenada coordAvioIterant;/* = avions.get(0).getPosicioRumb();

        xAvioIterant = coordAvioIterant.getX();
        yAvioIterant = coordAvioIterant.getY();
        zAvioIterant = coordAvioIterant.getZ();

        distancia = Math.sqrt(Math.pow((xAvioIterant - x), 2) + Math.pow((yAvioIterant - y), 2) + Math.pow((zAvioIterant - z), 2));*/

        for (int i = 0; i < avions.size(); i++) {
            if (avions.get(i) != avio) {

                avioIterant = avions.get(i);
                coordAvioIterant = avioIterant.getPosicioRumb();

                xAvioIterant = coordAvioIterant.getX();
                yAvioIterant = coordAvioIterant.getY();
                zAvioIterant = coordAvioIterant.getZ();

                distanciaTemp = Math.sqrt(Math.pow((xAvioIterant - x), 2) + Math.pow((yAvioIterant - y), 2) + Math.pow((zAvioIterant - z), 2));

                if (distanciaTemp <= rang) {
                    distancia = distanciaTemp;
                    avionsEnRang.add(avio);
                }
            }
        }

        objCollisio = new Collisio(distancia, avionsEnRang);

        return objCollisio;
    }
}
