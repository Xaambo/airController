package com.company;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Base64;

public class Criptologia {

    public Avio xifrar(Avio avio) {

        String criptat;

        criptat = Base64.getEncoder().encodeToString(avio.getMarca().getBytes(StandardCharsets.UTF_8));

        // mantenir la matricula igual pero hashear tot lo altre pero guardant la matricula en el hash

        return avio;
    }

    public Avio desXifrar(Avio avio) throws IOException {

        String decriptat;
        String hash;

        hash = new String(Files.readAllBytes(Paths.get("matricula.hash")));

        // agafar la matricula hashearla i compararla, si son iguals es dexifra tot lo altre

        byte[] decode = Base64.getDecoder().decode(hash.getBytes());

        decriptat = new String(decode, StandardCharsets.UTF_8);

        return avio;
    }

    private static String encriptar(String s) throws UnsupportedEncodingException {
        return Base64.getEncoder().encodeToString(s.getBytes("utf-8"));
    }
    private static String desencriptar(String s) throws UnsupportedEncodingException{
        byte[] decode = Base64.getDecoder().decode(s.getBytes());
        return new String(decode, StandardCharsets.UTF_8);
    }
}
