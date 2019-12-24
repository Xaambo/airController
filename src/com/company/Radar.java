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

        TableList tl = new TableList(13, "Matrícula", "Marca", "Model", "Posició X", "Posició Y", "Posició Z", "Avió de combat", "Aliat", "Armament", "Velocitat", "Autonomía", "Motor", "Tren Aterratge").sortBy(0).withUnicode(true);

        for (Avio avio : avions) {

            if (avio.isXifrat()) {

                String s = "B L O C K E D";
                
                tl.addRow(
                        s,
                        s,
                        s,
                        s,
                        s,
                        s,
                        s,
                        s,
                        s,
                        s,
                        s,
                        s,
                        s);

            } else {

                if (avio instanceof AvioCombat) {

                    tl.addRow(
                            avio.getMatricula(),
                            avio.getMarca(),
                            avio.getModel(),
                            String.valueOf(avio.getPosicioRumb().getX()),
                            String.valueOf(avio.getPosicioRumb().getY()),
                            String.valueOf(avio.getPosicioRumb().getZ()),
                            String.valueOf(avio.getDeCombat()),
                            String.valueOf(((AvioCombat) avio).getAmic()),
                            ((AvioCombat) avio).getMisils().get(0).getNom(),
                            String.valueOf(avio.getVelocitat()),
                            String.valueOf(avio.getAutonomia()),
                            String.valueOf(avio.getMotor()),
                            String.valueOf(avio.getTrenAterratge()));
                } else {

                    tl.addRow(
                            avio.getMatricula(),
                            avio.getMarca(),
                            avio.getModel(),
                            String.valueOf(avio.getPosicioRumb().getX()),
                            String.valueOf(avio.getPosicioRumb().getY()),
                            String.valueOf(avio.getPosicioRumb().getZ()),
                            String.valueOf(avio.getDeCombat()),
                            "null",
                            "null",
                            String.valueOf(avio.getVelocitat()),
                            String.valueOf(avio.getAutonomia()),
                            String.valueOf(avio.getMotor()),
                            String.valueOf(avio.getTrenAterratge()));
                }
            }
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
