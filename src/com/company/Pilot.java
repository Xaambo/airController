package com.company;

public class Pilot {

    Print print = new Print();
    cLector teclat = new cLector();

    public void controlAvio(Avio avio) {

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
                    if (avio.getMotor()) {
                        avio.apagarMotor();
                    } else {
                        avio.encendreMotor();
                    }
                    break;
                case 2:

                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                case 6:

                    break;
                case 7:

                    break;
                case 8:
                    if (avio.getTrenAterratge()) {
                        avio.pujarTren();
                    } else {
                        avio.baixarTren();
                    }
                    break;
                case 9:

                    break;
                case 10:
                    if (deCombat) {

                    } else {
                        print.blocked();
                    }
                    break;
                case 11:
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
}
