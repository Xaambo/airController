package com.company;

import java.util.ArrayList;

public class Pilot {

    Print print = new Print();
    cLector teclat = new cLector();

    public void controlAvio(Avio avio, ArrayList<Avio> avions) {

        int opcio;
        boolean deCombat = avio.getDeCombat();

        if (!deCombat) {
            print.printControladorAvio();
        } else {
            print.printControladorAvioCombat();
        }

        opcio = teclat.llegirEnter("Què vols fer? ");
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    avio = motor(avio);
                    break;
                case 2:
                    avio = velocitat(avio);
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:
                    avio.moviment(200, avions);
                    break;
                case 6:

                    break;
                case 7:
                    if (avio.getTrenAterratge()) {
                        avio.pujarTren();
                    } else {
                        avio.baixarTren();
                    }
                    break;
                case 8:

                    break;
                case 9:
                    if (deCombat) {

                    } else {
                        print.blocked();
                    }
                    break;
                case 10:
                    if (deCombat) {

                    } else {
                        print.blocked();
                    }
                    break;
                default:
                    print.printNoOpcioSwitch();
            }

            if (!deCombat) {
                print.printControladorAvio();
            } else {
                print.printControladorAvioCombat();
            }

            opcio = teclat.llegirEnter("Què vols fer? ");
        }

        print.YareYareDaze();
    }

    public Avio motor(Avio avio) {

        if (avio.getMotor()) {
            if (avio.getVelocitat() > 0) {
                print.errorPilot();
            } else {
                avio.apagarMotor();
            }
        } else {
            avio.encendreMotor();
        }

        return avio;
    }

    public Avio velocitat(Avio avio) {

        int novaVelocitat;

        novaVelocitat = teclat.llegirEnter("Velocitat desitjada?");

        while (novaVelocitat < 0) {
            novaVelocitat = teclat.llegirEnter("Velocitat desitjada?");
        }

        if (novaVelocitat == 0) {
            if (avio.getPosicioRumb().getY() > 0) {
                print.errorPilot();
            } else {
                avio.setVelocitat(novaVelocitat);
            }
        } else {
            avio.setVelocitat(novaVelocitat);
        }

        return avio;
    }
}
