package com.company;

import java.io.File;

public class Main {

    ControladorAeri controladorAeri = new ControladorAeri();

    public static void main(String[] args) {
	// write your code here
        Main programa = new Main();
        programa.inici();
    }

    public void inici() {

        File directori = new File("hashes");

        if (!directori.exists()) {
            directori.mkdir();
        } else {
            File[] files = directori.listFiles();

            for (File file : files) {
                file.delete();
            }
        }

        controladorAeri.controlAeri();

    }
}