package com.company;

public class AvioComercial extends Avio {

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
    public Avio enlairarse(Avio avio) {

        float velocitat;

        print.velocitatEnlairar();
        velocitat = teclat.llegirFloat("Velociat desitjada? ");

        if (velocitat == 0) {
            print.YareYareDaze();
        } else if (velocitat < 180) {
            print.noMinimVel();
            avio = enlairarse(this);
        } else {
            avio.setVelocitat((int)velocitat);
            avio.setPosicioRumb(new Coordenada(getPosicioRumb().getX(), 150, 200));
        }

        return avio;
    }
}
