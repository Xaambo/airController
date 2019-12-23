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

        TableList tl = new TableList(11, "Matrícula", "Marca", "Model", "X", "Y", "Z", "Avió de combat", "Velocitat", "Autonomía", "Motor", "Tren Aterratge").sortBy(0).withUnicode(true);

        for (Avio avio : avions) {
            tl.addRow(
                    avio.getMatricula(),
                    avio.getMarca(),
                    avio.getModel(),
                    String.valueOf(avio.getPosicioRumb().getX()),
                    String.valueOf(avio.getPosicioRumb().getY()),
                    String.valueOf(avio.getPosicioRumb().getZ()),
                    String.valueOf(avio.getDeCombat()),
                    String.valueOf(avio.getVelocitat()),
                    String.valueOf(avio.getAutonomia()),
                    String.valueOf(avio.getMotor()),
                    String.valueOf(avio.getTrenAterratge()));
        }



        tl.print();

    }

    protected boolean pistaEstaLliure(boolean pistaLliure) {

        pistaLliure = true;

        if (avions.size() == 0) {
            return true;
        }

        for (int i = 0; i < avions.size() && pistaLliure; i++) {
            if (avions.get(i).getPosicioRumb().getX() == 100 && (avions.get(i).getPosicioRumb().getY() >= 100 || avions.get(i).getPosicioRumb().getY() <= 120) && avions.get(i).getPosicioRumb().getZ() < 15) {
                pistaLliure = false;
            }
        }

        return pistaLliure;
    }
}
