package com.company;

import java.util.ArrayList;

public class Logic {

    cLector teclat = new cLector();

    public int trobar(ArrayList<Avio> avions) {

        boolean seleccionat = false;
        String opcio;
        int posicio = 0;

        opcio = teclat.llegirString("Quin avió vols? (Matrícula) ");

        while (!seleccionat) {
            for (int i = 0; i < avions.size() && !seleccionat; i++) {
                if (opcio.equals(avions.get(i).getMatricula())) {
                    posicio = i;
                    seleccionat = true;
                }
            }
            if (!seleccionat) {

                opcio = teclat.llegirString("Quin avió vols? (Matrícula) ");
            }

        }

        return posicio;
    }
}
