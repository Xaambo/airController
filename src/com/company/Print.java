package com.company;

import java.util.ArrayList;

enum Filtre {

    noXIFRATS {
        @Override
        ArrayList<Avio> filtrar(ArrayList<Avio> avions, ArrayList<Avio> avionsFiltrats) {

            for (int i = 0; i < avions.size(); i++) {

                Avio avio = avions.get(i);

                if (avio != null && !avio.isXifrat()) {
                    avionsFiltrats.add(avio);
                }
            }

            return avionsFiltrats;
        }
    },

    XIFRATS {
        @Override
        ArrayList<Avio> filtrar(ArrayList<Avio> avions, ArrayList<Avio> avionsFiltrats) {

            for (int i = 0; i < avions.size(); i++) {

                Avio avio = avions.get(i);

                if (avio != null && avio.isXifrat()) {
                    avionsFiltrats.add(avio);
                }
            }

            return avionsFiltrats;
        }
    },

    deCOMBAT {
        @Override
        ArrayList<Avio> filtrar(ArrayList<Avio> avions, ArrayList<Avio> avionsFiltrats) {

            for (int i = 0; i < avions.size(); i++) {

                Avio avio = avions.get(i);

                if (avio != null && avio.getDeCombat()) {
                    avionsFiltrats.add(avio);
                }
            }

            return null;
        }
    };

    abstract ArrayList<Avio> filtrar(ArrayList<Avio> avions, ArrayList<Avio> avionsFiltrats);
}

public class Print {

    public void printControladorAeri() {
        System.out.println("" +
                "CONTROLATOR 5000 ON\n" +
                "\n" +
                "1- Afegir un avió al espai aeri.\n" +
                "2- Gestionar un dels avions que tenim al radar.\n" +
                "3- Mostrar radar.\n" +
                "4- Xifrar avions de combat.\n" +
                "5- Desxifrar avions de combat.\n" +
                "0- Sortir.\n");
    }

    public void printControladorAvio() {
        System.out.println("" +
                "CONTROLATOR 5000 ON\n" +
                "\n" +
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
        System.out.println("" +
                "CONTROLATOR 5000 ON\n" +
                "\n" +
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
        System.out.println("· B · L · O · C · K · E · D ·");
    }

    public void printNoOpcioSwitch() {
        System.out.println("Això no és una opció.\n" +
                "\n");
    }

    public void YareYareDaze() {
        System.out.println("Yare Yare Daze");
    }

    public void creacioAvio() {
        System.out.println("" +
                "CREACIÓ D'AVIONS\n" +
                "================\n" +
                "\n" +
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
                "GESTIÓ MOTOR\n" +
                "================\n" +
                "1- Encendre\n" +
                "2- Apagar\n" +
                "Tens el motor " + estat + " què vols fer? ");
    }

    public void creacioAvioComercial() {
        System.out.println("" +
                "CREACIÓ D'UN AVIÓ COMERCIAL\n" +
                "===========================\n" +
                "Per crear-lo necessitem que s'omplenin les dades que es demanen a continuació.\n" +
                "\n");
    }

    public void fitxerNoTrobat() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "El fitxer no ha estat trobat.\n" +
                "\n");
    }

    public void pistaNoLliure() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "Ja hi ha un avió a la pista, fins que aquest no s'enlairi no se'n pot col·locar un de nou." +
                "\n");
    }

    public void matriculaErronia() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "La matrícula ha de tenir 7 caràcters obligatoriament.\n" +
                "\n");
    }

    public void avioForaPista() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "L'avió ha d'estar dintre la pista.\n" +
                "\n");
    }

    public void maxAvions() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "S'ha arribat a la capacitat màxima d'avions que es poden control·lar.\n" +
                "\n");
    }

    public void liniaBlanca() {
        System.out.println();
    }

    public void errorPilot() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "No pots fer això, sería catastròfic.\n" +
                "\n");
    }

    public ArrayList<Avio> llistaAvions(ArrayList<Avio> avions, Filtre filtre) {

        boolean algunAvio = false;
        ArrayList<Avio> avionsFiltre = new ArrayList<>();

        if (avions.size() > 0) {

            algunAvio = true;

            avionsFiltre = filtre.filtrar(avions, avionsFiltre);

            if (avionsFiltre.size() > 0) {

                for (int i = 0; i < avionsFiltre.size(); i++) {

                    Avio avio = avionsFiltre.get(i);

                    System.out.println("- Matrícula: " + avio.getMatricula() + " | Marca: " + avio.getMarca() + " | Model: " + avio.getModel());
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

    public void noAvions() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "No hi ha avions creats\n" +
                "\n");
    }

    public void unknown() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "Error desconegut contacti amb l'adminstrador.\n" +
                "\n");
    }

    public void noMotor() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "Motors apagats\n" +
                "\n");
    }

    public void volsEnlairar() {
        System.out.println("" +
                "WARNING\n" +
                "=======\n" +
                "Estas aterrat vols enlairar-te?\n" +
                "1- Si\n" +
                "2- No\n" +
                "\n");
    }

    public void velocitatEnlairar() {
        System.out.println("" +
                "Per enlairarte has de pujar la velocitat a un mínim de 180.\n");
    }

    public void noMinimVel() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "La velocitat mínima és de 180\n" +
                "\n");
    }

    public void motorEnces() {
        System.out.println("" +
                "\n" +
                "=============================\n" +
                "Motor encès satifactoriament!\n" +
                "=============================" +
                "\n");
    }

    public void motorApagat() {
        System.out.println("" +
                "\n" +
                "==============================\n" +
                "Motor apagat satifactoriament!\n" +
                "==============================" +
                "\n");
    }

    public void avioCreat() {
        System.out.println("" +
                "\n" +
                "============================\n" +
                "Avió creat satifactoriament!\n" +
                "============================" +
                "\n");
    }

    public void avioEliminat() {
        System.out.println("" +
                "\n" +
                "===============================\n" +
                "Avió eliminat satifactoriament!\n" +
                "===============================" +
                "\n");
    }

    public void printMisils() {
        System.out.println("" +
                "Mísils disponibles\n" +
                "==================\n" +
                "\n" +
                "1- A-A Llarga distància\n" +
                "2- A-A Curta distància\n" +
                "3- A-T\n" +
                "0- Sortir\n");
    }
}
