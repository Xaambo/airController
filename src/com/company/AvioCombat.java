package com.company;

import java.util.ArrayList;

public class AvioCombat extends Avio {

    Pilot pilot = new Pilot();

    private ArrayList<Misil> misils;
    private boolean amic;
    private boolean enMissio = false;

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

    public boolean isEnMissio() {
        return enMissio;
    }

    public void setEnMissio(boolean enMissio) {
        this.enMissio = enMissio;
    }

    @Override
    public Avio enlairarse(Avio avio, ArrayList<Avio> avions) {

        int velocitat;
        Coordenada posicioRumb;

        print.velocitatEnlairarAvioCombat();
        velocitat = pilot.velocitat(this, avions).getVelocitat();

        if (velocitat == 0) {

            print.YareYareDaze();

        } else if (velocitat < 150) {

            print.noMinimVel();
            avio = enlairarse(this, avions);

        } else {

            posicioRumb = avio.getPosicioRumb();
            avio = pilot.alcada(this, new Coordenada(posicioRumb.getX(), posicioRumb.getY(), posicioRumb.getZ()), avions);

            /* LA COORDENADA ACTUAL ÉS DIFERENT ARA DESPRES DENTRAR AL MÈTODE DE LA ALÇADA */
            avio = pilot.moviment(avio, new Coordenada(), avions);
        }

        return avio;
    }
}
