package com.company;

import java.io.IOException;
import java.util.ArrayList;

public class ControladorAeri {

    Print print = new Print();
    cLector teclat = new cLector();
    Radar radar = new Radar();
    Criptologia criptologia = new Criptologia();
    Logic logic = new Logic();
    Pilot pilot = new Pilot();

    public void controlAeri() {

        int opcio;
        boolean pistaLliure = false;

        print.printControladorAeri();

        opcio = teclat.llegirEnter("Què vols fer? ");
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    pistaLliure = radar.pistaEstaLliure(pistaLliure);

                    if (pistaLliure) {
                        afegirAvio();
                    } else {
                        print.pistaNoLliure();
                    }
                    break;
                case 2:
                    gestionarAvions();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                default:
                    print.printNoOpcioSwitch();
            }
            print.printControladorAeri();
            opcio = teclat.llegirEnter("Què vols fer? ");
        }

        print.YareYareDaze();
    }

    private void afegirAvio() {
        ArrayList<Avio> avions = radar.getAvions();
        int opcio;
        int avio;

        if (avions.size() < 10) {

            print.creacioAvio();

            opcio = teclat.llegirEnter("Quin vols crear? ");

            while (opcio != 0) {
                switch (opcio) {
                    case 1:
                    case 2:
                        avio = opcio;
                        avio(avio, avions);
                        break;
                    default:
                        print.printNoOpcioSwitch();
                }
                print.creacioAvio();
                opcio = teclat.llegirEnter("Quin vols crear? ");
            }
            print.YareYareDaze();

        } else {
            print.maxAvions();
        }
    }

    private void eliminarAvio() {

        ArrayList<Avio> avions = radar.getAvions();
        int posicio;
        boolean algunAvio;

        algunAvio = print.llistaAvions(avions);

        if (algunAvio) {
            posicio = logic.trobar(avions);

            avions.remove(posicio);

            print.avioEliminat();
        }
    }

    private ArrayList<Avio> avio(int avio, ArrayList<Avio> avions) {

        String dades, matricula, marca, model;
        int dadesInt, tripulacio, maxPassatgers = 0;
        boolean avioCorrecte = false, correcte;
        Coordenada posicioRumb = new Coordenada();
        ArrayList<Misil> misils = new ArrayList<>();

        print.creacioAvioComercial();

        while (!avioCorrecte) {

            dades = teclat.llegirString("Matrícula? ");

            matricula = dades;

            correcte = false;

            while (!correcte) {
                if (dades.length() != 7) {
                    print.matriculaErronia();
                    dades = teclat.llegirString("Matrícula? ");
                } else {
                    matricula = dades;
                    correcte = true;
                }
            }

            dades = teclat.llegirString("Marca? ");

            marca = dades;

            dades = teclat.llegirString("Model? ");

            model = dades;

            dadesInt = teclat.llegirEnter("Tripulació? ");

            tripulacio = dadesInt;

            if (avio == 1) {
                maxPassatgers = avioComercial();
            } else {
                misils = avioCombat(misils);
            }

            dadesInt = teclat.llegirEnter("Coordenada X? ");

            correcte = false;

            while (!correcte) {
                if (dadesInt != 100) {
                    print.avioForaPista();
                    dadesInt = teclat.llegirEnter("Coordenada X? ");
                } else {
                    posicioRumb.setX(dadesInt);
                    correcte = true;
                }
            }

            dadesInt = teclat.llegirEnter("Coordenada Y? ");

            correcte = false;

            while (!correcte) {
                if (dadesInt < 100 || dadesInt > 120) {
                    print.avioForaPista();
                    dadesInt = teclat.llegirEnter("Coordenada Y? ");
                } else {
                    posicioRumb.setY(dadesInt);
                    posicioRumb.setZ(0);
                    posicioRumb.setDireccio(Direccio.AVALL);
                    correcte = true;
                }
            }

            if (avio == 1) {
                avions.add(/*avions.lastIndexOf(null),*/ new AvioComercial(matricula, marca, model, tripulacio, posicioRumb, maxPassatgers, false));
            } else {
                avions.add(/*avions.lastIndexOf(null),*/ new AvioCombat(matricula, marca, model, tripulacio, posicioRumb, misils, true, true));
            }
            avioCorrecte = true;

            print.avioCreat();
        }

        return avions;
    }

    private int avioComercial() {

        int dadesInt, maxPassatgers;

        dadesInt = teclat.llegirEnter("Capacitat màxima de passatgers? ");

        maxPassatgers = dadesInt;

        return maxPassatgers;
    }

    private ArrayList<Misil> avioCombat(ArrayList<Misil> misils) {

        int opcio;
        boolean escollit = false;

        print.printMisils();

        opcio = teclat.llegirEnter("Quina classe de mísils vols equipar? ");

        while (opcio != 0 && !escollit) {
            switch (opcio) {
                case 1:
                    for (int i = 0; i < 10; i++) {
                        misils.add(new Misil("A-A Llarga distància", 100, 5, 150, 10));
                        escollit = true;
                    }
                    break;
                case 2:
                    for (int i = 0; i < 10; i++) {
                        misils.add(new Misil("A-A Curta distància", 80, 3, 85, 4));
                        escollit = true;
                    }
                    break;
                case 3:
                    for (int i = 0; i < 10; i++) {
                        misils.add(new Misil("A-T", 150, 10, 100, 10));
                        escollit = true;
                    }
                    break;
                default:
                    print.printNoOpcioSwitch();

                    print.creacioAvio();
                    opcio = teclat.llegirEnter("Quina classe de mísils vols equipar? ");
            }
        }

        return misils;
    }

    private void gestionarAvions() {

        ArrayList<Avio> avions = radar.getAvions();
        Avio avio;
        int posicio;
        boolean algunAvio;

        algunAvio = print.llistaAvions(avions);

        if (algunAvio) {
            posicio = logic.trobar(avions);

            avio = avions.get(posicio);

            pilot.controlAvio(avio, avions);
        }
    }

    private void mostrarRadar() {
        radar.resumSituacio();
    }

    public void xifrarAvions(Avio avio) {
        criptologia.xifrar(avio);
    }

    public void desxifrarAvions(Avio avio) throws IOException {
        criptologia.desXifrar(avio);
    }
}
