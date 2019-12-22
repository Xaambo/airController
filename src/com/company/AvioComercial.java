package com.company;

import java.io.PipedOutputStream;
import java.util.ArrayList;

public class AvioComercial extends Avio {

    Pilot pilot = new Pilot();

    private int maxPassatgers;
    private String origen = "Barcelona";
    private String desti = "Amsterdam";

    public AvioComercial(String matricula, String marca, String model, int tripulacio, Coordenada posicioRumb, int maxPassatgers, boolean deCombat) {
        super(matricula, marca, model, tripulacio, posicioRumb, deCombat);

        this.maxPassatgers = maxPassatgers;
    }

    public int getMaxPassatgers() {
        return maxPassatgers;
    }

    public String getOrigen() {
        return origen;
    }

    public String getDesti() {
        return desti;
    }

    @Override
    public Avio enlairarse(Avio avio, ArrayList<Avio> avions) {

        int velocitat;
        Coordenada posicioRumb;

        print.velocitatEnlairar();
        velocitat = pilot.velocitat(this, avions).getVelocitat();

        if (velocitat == 0) {

            print.YareYareDaze();

        } else if (velocitat < 180) {

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
