package com.company;

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
                case 1://crear avio
                    pistaLliure = radar.pistaEstaLliure(pistaLliure);

                    if (pistaLliure) {
                        afegirAvio();
                    } else {
                        print.pistaNoLliure();
                    }
                    break;
                case 2://gestionar els avions i tot el que poden fer
                    gestionarAvions();
                    break;
                case 3://estat actual dels avions
                    mostrarRadar();
                    break;
                case 4://xifrar avions
                    xifrarAvions();
                    break;
                case 5://desxifrar avions
                    desxifrarAvions();
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
                        opcio = 0;
                        break;
                    default:
                        print.printNoOpcioSwitch();

                        opcio = teclat.llegirEnter("Quin vols crear? ");
                }
            }
            print.YareYareDaze();

        } else {
            print.maxAvions();
        }
    }

    private ArrayList<Avio> avio(int avio, ArrayList<Avio> avions) {

        String dades, matricula, marca, model;
        int dadesInt, tripulacio, maxPassatgers = 0;
        boolean avioCorrecte = false, correcte, amic;
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

                    if (logic.existeix(avions, dades)) {

                        print.avioJaExisteix();
                        dades = teclat.llegirString("Matrícula? ");

                    } else {

                        matricula = dades;
                        correcte = true;

                    }
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

            posicioRumb.setX(100);
            posicioRumb.setY(100);
            posicioRumb.setZ(0);
            posicioRumb.setDireccio(Direccio.AVALL);

            if (avio == 1) {
                avions.add(/*avions.lastIndexOf(null),*/ new AvioComercial(matricula, marca, model, tripulacio, posicioRumb, maxPassatgers, false));
            } else {
                print.bandol();

                dadesInt = teclat.llegirEnter("Amic o enemic? ");

                while (true) {
                    if (dadesInt == 1) {
                        amic = true;
                        break;
                    } else if (dadesInt == 2) {
                        amic = false;
                        break;
                    } else {
                        dadesInt = teclat.llegirEnter("Amic o enemic? ");
                    }
                }

                avions.add(/*avions.lastIndexOf(null),*/ new AvioCombat(matricula, marca, model, tripulacio, posicioRumb, misils, true, amic));
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
        ArrayList<Avio> avionsFiltre;
        Logic logic;
        Avio avio;
        int posicio;

        avionsFiltre = print.llistaAvions(avions, Filtre.noXIFRATS, 1);

        if (avionsFiltre.size() > 0) {

            logic = this.logic.trobar(avionsFiltre);

            if (logic.isSeleccionat()) {

                posicio = logic.getPosicio();

                avio = avionsFiltre.get(posicio);

                pilot.controlAvio(avio, avions);
            }
        } else {
            print.YareYareDaze();
        }
    }

    private void mostrarRadar() {
        radar.resumSituacio();
    }

    public void xifrarAvions() {

        ArrayList<Avio> avions = radar.getAvions();
        ArrayList<Avio> avionsFiltre;
        Logic logic;
        Avio avio;
        int posicio;

        avionsFiltre = print.llistaAvions(avions, Filtre.deCOMBAT_noXIFRATS, 2);

        if (avionsFiltre.size() > 0) {
            logic = this.logic.trobar(avionsFiltre);

            if (logic.isSeleccionat()) {

                posicio = logic.getPosicio();

                avio = avionsFiltre.get(posicio);

                criptologia.xifrar(avio);
            } else {
                print.YareYareDaze();
            }
        }
    }

    public void desxifrarAvions() {

        ArrayList<Avio> avions = radar.getAvions();
        ArrayList<Avio> avionsFiltre;
        Logic logic;
        Avio avio;
        int posicio;

        avionsFiltre = print.llistaAvions(avions, Filtre.deCOMBAT_XIFRATS, 3);

        if (avionsFiltre.size() > 0) {
            logic = this.logic.trobar(avionsFiltre);

            if (logic.isSeleccionat()) {

                posicio = logic.getPosicio();

                avio = avionsFiltre.get(posicio);

                criptologia.desXifrar(avio);
            } else {
                print.YareYareDaze();
            }
        }
    }
}
