package com.company;

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

        float velocitat;

        print.velocitatEnlairar();
        velocitat = teclat.llegirFloat("Velociat desitjada? ");

        if (velocitat == 0) {
            print.YareYareDaze();
        } else if (velocitat < 180) {
            print.noMinimVel();
            avio = enlairarse(this, avions);
        } else {
            avio.setVelocitat(pilot.velocitat(this, avions).getVelocitat());
            avio.setPosicioRumb(new Coordenada(getPosicioRumb().getX(), 150, 200));
        }

        return avio;
    }
}
