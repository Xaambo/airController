package com.company;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.FileAlreadyExistsException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Criptologia {

    Print print = new Print();

    public Avio xifrar(Avio avio) {

        String criptat;
        String arxiu = "hashes/" + avio.getMatricula() + ".hash";

        criptat = Base64.getEncoder().encodeToString(avio.getMatricula().getBytes(StandardCharsets.UTF_8));

        try (FileWriter fw = new FileWriter(arxiu, true); BufferedWriter bw = new BufferedWriter(fw); PrintWriter out = new PrintWriter(bw)) {

            out.println(criptat);

        } catch (IOException e) {
            print.unknown();
        }

        //Mantenir la matricula igual pero hashear tot lo altre pero guardant la matricula en el hash

        avio.setMarca(Base64.getEncoder().encodeToString(avio.getMarca().getBytes(StandardCharsets.UTF_8)));
        avio.setModel(Base64.getEncoder().encodeToString(avio.getModel().getBytes(StandardCharsets.UTF_8)));
        avio.setXifrat(true);

        return avio;
    }

    public Avio desXifrar(Avio avio) {

        String comparacio;
        String hash = "";
        String arxiu = "hashes/" + avio.getMatricula() + ".hash";

        try {
            hash = new String(Files.readAllBytes(Paths.get(arxiu))); //new string pq retorna una array de bytes
            hash = hash.substring(0, hash.length() - 2);
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

        //Agafar la matricula hashearla i compararla, si son iguals es desxifra tot lo altre

        return avio;
    }
}
