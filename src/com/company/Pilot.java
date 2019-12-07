package com.company;

public class Pilot {

    Print print = new Print();
    cLector teclat = new cLector();

    public void controlAvio(Avio avio) {

        int opcio;

        print.printControladorAeri();

        opcio = teclat.llegirEnter("Què vols fer? ");
        while (opcio != 0) {
            switch (opcio) {
                case 1:
                    avio.encendreMotor();
                    break;
                case 2:
                    avio.apagarMotor();
                    break;
                case 3:

                    break;
                case 4:

                    break;
                case 5:

                    break;
                default:
                    print.printNoOpcioSwitch();
            }
            print.printControladorAeri();
            opcio = teclat.llegirEnter("Què vols fer? ");
        }

        print.YareYareDaze();
    }
}
