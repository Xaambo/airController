package com.company;

import java.util.ArrayList;

public class Radar {

    private ArrayList<Avio> avions = new ArrayList<Avio>();

    public ArrayList<Avio> getAvions() {
        return avions;
    }

    public void setAvions(ArrayList<Avio> avions) {
        this.avions = avions;
    }

    protected void resumSituacio() {

    }

    protected boolean pistaEstaLliure(boolean pistaLliure) {

        pistaLliure = false;

        for (int i = 0; i < avions.size() && !pistaLliure; i++) {
            if (avions.get(i).getPosicioRumb().getX() == 100 && (avions.get(i).getPosicioRumb().getY() >= 100 || avions.get(i).getPosicioRumb().getY() <= 120)) {
                pistaLliure = true;
            }
        }

        if (avions.size() == 0) {
            return true;
        } else {
            return pistaLliure;
        }
    }
}
