package com.company;

public abstract class Avio {

    private String matricula;
    private String marca;
    private String model;
    private int tripulacio;
    private Coordenada posicioRumb;
    private int autonomia = 3000;
    private boolean motor = false;
    private boolean trenAterratge = true;
    private boolean deCombat;

    public Avio(String matricula, String marca, String model, int tripulacio, Coordenada posicioRumb, boolean deCombat) {
        this.matricula = matricula;
        this.marca = marca;
        this.model = model;
        this.tripulacio = tripulacio;
        this.posicioRumb = posicioRumb;
        this.deCombat = deCombat;
    }

    public String getMatricula() {
        return matricula;
    }

    public String getMarca() {
        return marca;
    }

    public String getModel() {
        return model;
    }

    public int getTripulacio() {
        return tripulacio;
    }

    public Coordenada getPosicioRumb() {
        return posicioRumb;
    }

    public int getAutonomia() {
        return autonomia;
    }

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

    public boolean getDeCombat() {
        return deCombat;
    }

    public void setDeCombat(boolean deCombat) {
        this.deCombat = deCombat;
    }

    public abstract void enlairarse();
}
