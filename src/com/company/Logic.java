package com.company;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Logic {

    cLector teclat = new cLector();

    private int posicio;
    private boolean seleccionat;

    public Logic() {

    }

    public Logic(int posicio, boolean seleccionat) {
        this.posicio = posicio;
        this.seleccionat = seleccionat;
    }

    /** GETTERS & SETTERS */

    public int getPosicio() {
        return posicio;
    }

    public void setPosicio(int posicio) {
        this.posicio = posicio;
    }

    public boolean isSeleccionat() {
        return seleccionat;
    }

    public void setSeleccionat(boolean seleccionat) {
        this.seleccionat = seleccionat;
    }

    /** MÈTODES */

    public Logic trobar(ArrayList<Avio> avions) {

        boolean seleccionat = false;
        String opcio;
        int posicio = 0;
        Logic logic = new Logic(posicio, seleccionat);

        opcio = teclat.llegirString("Quin avió vols? (Matrícula) ");

        while (!seleccionat && !opcio.equals("0")) {
            for (int i = 0; i < avions.size() && !seleccionat; i++) {
                if (opcio.equals(avions.get(i).getMatricula())) {
                    posicio = i;
                    seleccionat = true;

                    logic.setPosicio(posicio);
                    logic.setSeleccionat(seleccionat);
                }
            }
            if (!seleccionat) {
                opcio = teclat.llegirString("Quin avió vols? (Matrícula) ");
            }

        }

        return logic;
    }

    public Avio eliminarAvio(Avio avio) {

        avio.setDestruit(true);

        return avio;
    }

    public boolean existeix(ArrayList<Avio> avions, String matricula) {

        boolean existeix = false;

        for (int i = 0; i < avions.size() && !existeix; i++) {
            if (matricula.equals(avions.get(i).getMatricula())) {
                existeix = true;
            }
        }

        return existeix;
    }
}
