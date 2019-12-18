package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Criptologia {

    Print print = new Print();

    public Avio xifrar(Avio avio) {

        String criptat;
        String arxiu = avio.getMatricula() + ".hash";

        criptat = Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8));

        try {
            FileWriter fw = new FileWriter(arxiu, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);

            out.println(criptat);

        } catch (IOException e) {
            //exception handling left as an exercise for the reader
        }

        // mantenir la matricula igual pero hashear tot lo altre pero guardant la matricula en el hash

        avio.setMarca(Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8)));
        avio.setModel(Base64.getEncoder().encodeToString(avio.getModel().getBytes(StandardCharsets.UTF_8)));
        avio.setXifrat(true);

        return avio;
    }

    public Avio desXifrar(Avio avio) throws IOException {

        String comparacio;
        String hash = "";

        try {
            hash = new String(Files.readAllBytes(Paths.get(avio.getMatricula() + ".hash")));
        } catch (FileNotFoundException e) {
            print.fitxerNoTrobat();
        }

        comparacio = Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8));

        if (hash.equals(comparacio)) {
            byte[] decodeMarca = Base64.getDecoder().decode(avio.getMarca().getBytes());
            byte[] decodeModel = Base64.getDecoder().decode(avio.getModel().getBytes());

            avio.setMarca(new String(decodeMarca, StandardCharsets.UTF_8));
            avio.setModel(new String(decodeModel, StandardCharsets.UTF_8));

            avio.setXifrat(false);

        } else {

            print.blocked();

        }

        // agafar la matricula hashearla i compararla, si son iguals es desxifra tot lo altre

        return avio;
    }
}
