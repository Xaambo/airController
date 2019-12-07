package com.company;

import java.util.ArrayList;
import java.util.jar.JarOutputStream;

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
                "3- Pujar/Baixar Tren aterratge.\n" +
                "4- Establir rumb.\n" +
                "5- Info Avió.\n" +
                "0- Sortir.\n");
    }

    public void printNoOpcioSwitch() {
        System.out.println("Això no és una opció.");
        System.out.println();
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

    public void creacioAvioComercial() {
        System.out.println("" +
                "CREACIÓ D'UN AVIÓ COMERCIAL\n" +
                "===========================\n" +
                "\n" +
                "Per crear-lo necessitem que s'omplenin les dades que es demanen a continuació.\n" +
                "\n");
    }

    public void pistaNoLliure() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "\n" +
                "Ja hi ha un avió a la pista, fins que aquest no s'enlairi no se'n pot col·locar un de nou." +
                "\n");
    }

    public void matriculaErronia() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "\n" +
                "La matrícula ha de tenir 7 caràcters obligatoriament.\n" +
                "\n");
    }

    public void avioForaPista() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "\n" +
                "L'avió ha d'estar dintre la pista.\n" +
                "\n");
    }

    public void maxAvions() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "\n" +
                "S'ha arribat a la capacitat màxima d'avions que es poden control·lar.\n" +
                "\n");
    }

    public void liniaBlanca() {
        System.out.println();
    }

    public boolean llistaAvions(ArrayList<Avio> avions) {

        boolean algunAvio = false;

        for (int i = 0; i < avions.size(); i++) {
            if (avions.get(i) != null) {
                System.out.println("- Matrícula: " + avions.get(i).getMatricula() + " | Marca: " + avions.get(i).getMarca() + " | Model: " + avions.get(i).getModel());
                algunAvio = true;
            }
        }
        liniaBlanca();

        if (!algunAvio) {
            noAvions();
        }

        return algunAvio;
    }

    public void noAvions() {
        System.out.println("" +
                "ERROR\n" +
                "=====\n" +
                "\n" +
                "No hi ha avions creats\n" +
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
