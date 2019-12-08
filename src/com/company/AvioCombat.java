package com.company;

import java.util.ArrayList;

public class AvioCombat extends Avio {

    private ArrayList<Misil> misils;
    boolean amic;

    public AvioCombat(String matricula, String marca, String model, int tripulacio, Coordenada posicioRumb, ArrayList<Misil> misils, boolean deCombat, boolean amic) {
        super(matricula, marca, model, tripulacio, posicioRumb, deCombat);

        this.misils = misils;
        this.amic = amic;
    }

    public ArrayList<Misil> getMisils() {
        return misils;
    }

    public boolean getAmic() {
        return amic;
    }

    @Override
    public void enlairarse() {

    }
}
