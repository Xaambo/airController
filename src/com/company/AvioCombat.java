package com.company;

import java.util.ArrayList;

public class AvioCombat extends Avio {

    private ArrayList<Misil> misils;

    public AvioCombat(String matricula, String marca, String model, int tripulacio, Coordenada posicioRumb, ArrayList<Misil> misils, boolean deCombat) {
        super(matricula, marca, model, tripulacio, posicioRumb, deCombat);

        this.misils = misils;
    }

    public ArrayList<Misil> getMisils() {
        return misils;
    }

    @Override
    public void enlairarse() {

    }
}
