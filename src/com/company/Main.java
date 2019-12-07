package com.company;

public class Main {

    ControladorAeri controladorAeri = new ControladorAeri();

    public static void main(String[] args) {
	// write your code here
        Main programa = new Main();
        programa.inici();
    }

    public void inici() {

        controladorAeri.controlAeri();

    }
}
