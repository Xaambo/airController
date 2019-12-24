package com.company;

import java.util.ArrayList;

enum Filtre {

    noXIFRATS {
        @Override
        ArrayList<Avio> filtrar(ArrayList<Avio> avions, ArrayList<Avio> avionsFiltrats) {

            for (int i = 0; i < avions.size(); i++) {

                Avio avio = avions.get(i);

                if (avio instanceof AvioCombat) {

                    if (!avio.isXifrat() && ((AvioCombat) avio).getAmic()) {
                        avionsFiltrats.add(avio);
                    }
                } else if (avio != null && !avio.isXifrat()) {
                    avionsFiltrats.add(avio);
                }
            }

            return avionsFiltrats;
        }
    },

    TOTS {
        @Override
        ArrayList<Avio> filtrar(ArrayList<Avio> avions, ArrayList<Avio> avionsFiltrats) {

            for (int i = 0; i < avions.size(); i++) {

                Avio avio = avions.get(i);

                if (avio != null) {
                    avionsFiltrats.add(avio);
                }
            }

            return avionsFiltrats;
        }
    },

    deCOMBAT_XIFRATS {
        @Override
        ArrayList<Avio> filtrar(ArrayList<Avio> avions, ArrayList<Avio> avionsFiltrats) {

            for (int i = 0; i < avions.size(); i++) {

                Avio avio = avions.get(i);

                if (avio instanceof AvioCombat) {

                    if (avio.isXifrat() && ((AvioCombat) avio).getAmic()) {
                        avionsFiltrats.add(avio);
                    }
                }
            }

            return avionsFiltrats;
        }
    },

    deCOMBAT_noXIFRATS {
        @Override
        ArrayList<Avio> filtrar(ArrayList<Avio> avions, ArrayList<Avio> avionsFiltrats) {

            for (int i = 0; i < avions.size(); i++) {

                Avio avio = avions.get(i);

                if (avio instanceof AvioCombat) {

                    if (!avio.isXifrat() && ((AvioCombat) avio).getAmic()) {
                        avionsFiltrats.add(avio);
                    }
                }
            }

            return avionsFiltrats;
        }
    };

    abstract ArrayList<Avio> filtrar(ArrayList<Avio> avions, ArrayList<Avio> avionsFiltrats);
}

public class Print {

    public void printControladorAeri() {
        System.out.print("" +
                "\nCONTROLATOR 5000 ON\n" +
                "===================\n" +
                "1- Afegir un avió al espai aeri.\n" +
                "2- Gestionar un dels avions que tenim al radar.\n" +
                "3- Mostrar radar.\n" +
                "4- Xifrar avions de combat.\n" +
                "5- Desxifrar avions de combat.\n" +
                "0- Sortir.\n");
    }

    public void printControladorAvio() {
        System.out.print("" +
                "\nCONTROLATOR 5000 ON\n" +
                "===================\n" +
                "1- Encendre/Apagar Motor.\n" +
                "2- Accelerar/Frenar Avió.\n" +
                "3- Pujar/Baixar alçada.\n" +
                "4- Establir 'X' i 'Y'.\n" +
                "5- Establir rumb.\n" +
                "6- Pujar/Baixar Tren aterratge.\n" +
                "7- Info Avió.\n" +
                "0- Sortir.\n");
    }

    public void printControladorAvioCombat() {
        System.out.print("" +
                "\nCONTROLATOR 5000 ON\n" +
                "===================\n" +
                "1- Encendre/Apagar Motor.\n" +
                "2- Accelerar/Frenar Avió.\n" +
                "3- Pujar/Baixar alçada.\n" +
                "4- Establir 'X' i 'Y'.\n" +
                "5- Establir rumb.\n" +
                "6- Pujar/Baixar Tren aterratge.\n" +
                "7- Info Avió.\n" +
                "8- Acció preventiva (DEFCON 3).\n" +
                "9- End Of Mission (DEFCON 5)\n" +
                "0- Sortir.\n");
    }

    public void blocked() {
        System.out.print("· B · L · O · C · K · E · D ·");
    }

    public void printNoOpcioSwitch() {
        System.out.print("\nAixò no és una opció.\n");
    }

    public void YareYareDaze() {
        System.out.print("\nYare Yare Daze\n");
    }

    public void creacioAvio() {
        System.out.print("" +
                "\nCREACIÓ D'AVIONS\n" +
                "================\n" +
                "Abans de procedir amb les dades s'hauria d'informar si es vol afegir un avió comercial o un de combat.\n" +
                "\n" +
                "1- Comercial\n" +
                "2- Combat\n" +
                "0- Sortir\n");
    }

    public void gestioMotor(boolean motor) {

        String estat;

        if (motor) {
            estat = "encès";
        } else {
            estat = "apagat";
        }

        System.out.print("" +
                "\nGESTIÓ MOTOR\n" +
                "============\n" +
                "1- Encendre\n" +
                "2- Apagar\n" +
                "Tens el motor " + estat + " què vols fer? ");
    }

    public void bandol() {
        System.out.println("" +
                "\nBÀNDOL\n" +
                "======\n" +
                "1- Amic\n" +
                "2- Enemic");
    }

    public void creacioAvioComercial() {
        System.out.print("" +
                "\nCREACIÓ D'UN AVIÓ COMERCIAL\n" +
                "===========================\n" +
                "Per crear-lo necessitem que s'omplenin les dades que es demanen a continuació.\n");
    }

    public void fitxerNoTrobat() {
        System.out.print("" +
                "\nERROR\n" +
                "=====\n" +
                "El fitxer no ha estat trobat.\n");
    }

    public void pistaNoLliure() {
        System.out.print("" +
                "\nERROR\n" +
                "=====\n" +
                "Ja hi ha un avió a la pista, fins que aquest no s'enlairi no se'n pot col·locar un de nou.\n");
    }

    public void matriculaErronia() {
        System.out.print("" +
                "\nERROR\n" +
                "=====\n" +
                "La matrícula ha de tenir 7 caràcters obligatoriament.\n");
    }

    public void avioJaExisteix() {
        System.out.print("" +
                "\nERROR\n" +
                "=====\n" +
                "L'avió que intentas crear ja existeix.\n");
    }

    public void maxAvions() {
        System.out.print("" +
                "\nERROR\n" +
                "=====\n" +
                "S'ha arribat a la capacitat màxima d'avions que es poden control·lar.\n");
    }

    public void liniaBlanca() {
        System.out.println();
    }

    public void errorPilot() {
        System.out.println("" +
                "\nERROR\n" +
                "=====\n" +
                "No pots fer això, sería catastròfic.");
    }

    public ArrayList<Avio> llistaAvions(ArrayList<Avio> avions, Filtre filtre, int titol) {

        ArrayList<Avio> avionsFiltre = new ArrayList<>();

        switch (titol) {
            case 1:
                llistaGestio();
                break;
            case 2:
                llistaXifrar();
                break;
            case 3:
                llistaDesXifrar();
                break;
            case 4:
                llistaDisparar();
        }

        if (avions.size() > 0) {

            avionsFiltre = filtre.filtrar(avions, avionsFiltre);

            if (avionsFiltre.size() > 0) {

                for (int i = 0; i < avionsFiltre.size(); i++) {

                    Avio avio = avionsFiltre.get(i);

                    if (avio instanceof AvioCombat) {
                        System.out.println("- Matrícula: " + avio.getMatricula() + " | Marca: " + avio.getMarca() + " | Model: " + avio.getModel() + " | Amic: " + ((AvioCombat) avio).getAmic());
                    } else {
                        System.out.println("- Matrícula: " + avio.getMatricula() + " | Marca: " + avio.getMarca() + " | Model: " + avio.getModel());
                    }
                }
                liniaBlanca();
            } else {
                noAvions();
            }

        } else {
            noAvions();
        }

        return avionsFiltre;
    }

    public void infoAvio(Avio avio) {

        Coordenada posicioRumb = avio.getPosicioRumb();

        System.out.print("" +
                "\nINFO AVIÓ " + avio.getMatricula().toUpperCase() + "\n" +
                "- Matrícula:  " + avio.getMatricula() + "\n" +
                "- Marca:      " + avio.getMarca() + "\n" +
                "- Model:      " + avio.getModel() + "\n" +
                "- Posició X:  " + posicioRumb.getX() + "\n" +
                "- Posició Y:  " + posicioRumb.getY() + "\n" +
                "- Posició Z:  " + posicioRumb.getZ() + "\n" +
                "- Velocitat:  " + avio.getVelocitat() + "\n" +
                "- Tripulació: " + avio.getTripulacio() + "\n");
    }

    public void noAvions() {
        System.out.print("" +
                "\nERROR\n" +
                "=====\n" +
                "No hi ha avions creats\n");
    }

    public void unknown() {
        System.out.print("" +
                "\nERROR\n" +
                "=====\n" +
                "Error desconegut contacti amb l'adminstrador.\n");
    }

    public void noMotor() {
        System.out.print("" +
                "\nWARNING\n" +
                "=====\n" +
                "Motors apagats\n");
    }

    public void volsEnlairar() {
        System.out.print("" +
                "\nWARNING\n" +
                "=======\n" +
                "Estas aterrat\n" +
                "1- Si\n" +
                "2- No\n");
    }

    public void avioPerdut() {
        System.out.print("" +
                "\nWARNING\n" +
                "=======\n" +
                "L'avió ha sortit del nostre rang d'acció i n'em perdut la pista.\n");
    }

    public void avioDestruit() {
        System.out.print("" +
                "\nWARNING\n" +
                "=======\n" +
                "L'avió ha sigut destruit.\n");
    }

    public void operativaDesc() {
        System.out.print("" +
                "\nWARNING\n" +
                "=======\n" +
                "No hi ha cap operativa en actiu.\n");
    }

    public void operativaEnd() {
        System.out.print("" +
                "\nWARNING\n" +
                "=======\n" +
                "Operativa finalitzada amb exit. (DEFCON 5)\n");
    }

    public void operativaBegin() {
        System.out.print("" +
                "\nWARNING\n" +
                "=======\n" +
                "Començem operativa. (DEFCON 3)\n");
    }

    public void velocitatEnlairar() {
        System.out.print("" +
                "Per enlairar-te has de pujar la velocitat a un mínim de 180.\n");
    }

    public void velocitatEnlairarAvioCombat() {
        System.out.print("" +
                "Per enlairar un avió de combat has de pujar la velocitat a un mínim de 150.\n");
    }

    public void noMinimVel() {
        System.out.print("" +
                "\nWARNING\n" +
                "=======\n" +
                "No vas a la velocitat mínima requerida\n");
    }

    public void massaAltura() {
        System.out.print("" +
                "\nWARNING\n" +
                "=======\n" +
                "Estas a massa altura, descendeix per sota dels 500 per fer això\n");
    }

    public void massaVelocitat() {
        System.out.print("" +
                "\nWARNING\n" +
                "=======\n" +
                "Vas massa ràpid, desaccelera per sota dels 300 per fer això\n");
    }

    public void terra() {
        System.out.print("" +
                "\nWARNING\n" +
                "=====\n" +
                "A terra no pots fer això\n");
    }

    public void alturaTren() {
        System.out.print("" +
                "\nWARNING\n" +
                "=====\n" +
                "No pots pujar tant amb el tren baixat.\n");
    }

    public void motorEnces() {
        System.out.print("" +
                "\n" +
                "=============================\n" +
                "Motor encès satifactoriament!\n" +
                "=============================" +
                "\n");
    }

    public void motorApagat() {
        System.out.print("" +
                "\n" +
                "==============================\n" +
                "Motor apagat satifactoriament!\n" +
                "==============================" +
                "\n");
    }

    public void avioCreat() {
        System.out.print("" +
                "\n" +
                "============================\n" +
                "Avió creat satifactoriament!\n" +
                "============================" +
                "\n");
    }

    public void avioEliminat() {
        System.out.print("" +
                "\n" +
                "===============================\n" +
                "Avió eliminat satifactoriament!\n" +
                "===============================" +
                "\n");
    }

    public void llistaGestio() {
        System.out.println("" +
                "\nAVIONS CONTROLATS\n" +
                "=================");
    }

    public void llistaXifrar() {
        System.out.println("" +
                "\nAVIONS A XIFRAR\n" +
                "===============");
    }

    public void llistaDesXifrar() {
        System.out.println("" +
                "\nAVIONS A DESXIFRAR\n" +
                "==================");
    }

    public void llistaDisparar() {
        System.out.println("" +
                "\nAVIONS EN RANG DE TIR\n" +
                "=====================");
    }

    public void alcadaDone() {
        System.out.print("" +
                "\n" +
                "===================================\n" +
                "Alçada conseguida satifactoriament!\n" +
                "===================================" +
                "\n");
    }

    public void movimentDone() {
        System.out.print("" +
                "\n" +
                "===================================\n" +
                "Moviment efectuat satifactoriament!\n" +
                "===================================" +
                "\n");
    }

    public void trenAterratgePujat() {
        System.out.print("" +
                "\n" +
                "========================================\n" +
                "Tren d'aterratge pujat satifactoriament!\n" +
                "========================================" +
                "\n");
    }

    public void trenAterratgeBaixat() {
        System.out.print("" +
                "\n" +
                "=========================================\n" +
                "Tren d'aterratge baixat satifactoriament!\n" +
                "=========================================" +
                "\n");
    }

    public void printMisils() {
        System.out.print("" +
                "\nMísils disponibles\n" +
                "==================\n" +
                "\n" +
                "1- A-A Llarga distància\n" +
                "2- A-A Curta distància\n" +
                "3- A-T\n" +
                "0- Sortir\n");
    }
}
