package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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

            fw.write(criptat);

        } catch (IOException e) {
            print.unknown();
        }

        // mantenir la matricula igual pero hashear tot lo altre pero guardant la matricula en el hash

        avio.setMarca(Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8)));
        avio.setModel(Base64.getEncoder().encodeToString(avio.getModel().getBytes(StandardCharsets.UTF_8)));
        avio.setXifrat(true);

        return avio;
    }

    public Avio desXifrar(Avio avio) {

        String comparacio;
        String hash = "";
        String arxiu = avio.getMatricula() + ".hash";

        try {
            hash = new String(Files.readAllBytes(Paths.get(arxiu)));
        } catch (Exception e) {
            print.fitxerNoTrobat();
        }

        comparacio = Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8));

        if (hash.equals(comparacio)) {
            byte[] decodeMarca = Base64.getDecoder().decode(avio.getMarca().getBytes());
            byte[] decodeModel = Base64.getDecoder().decode(avio.getModel().getBytes());

            avio.setMarca(new String(decodeMarca, StandardCharsets.UTF_8));
            avio.setModel(new String(decodeModel, StandardCharsets.UTF_8));

            avio.setXifrat(false);

            File file = new File(arxiu);

            file.delete();

        } else {

            print.blocked();

        }

        // agafar la matricula hashearla i compararla, si son iguals es desxifra tot lo altre

        return avio;
    }
}
