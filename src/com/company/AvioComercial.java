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
    public void enlairarse() {



    }
}
