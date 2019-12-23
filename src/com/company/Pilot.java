package com.company;

import java.util.ArrayList;

public class Pilot {

    Print print = new Print();
    cLector teclat = new cLector();
    Logic logic = new Logic();

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
                    avio = motor(avio, avions);
                    break;
                case 2:
                    avio = velocitat(avio, avions);
                    break;
                case 3:
                    avio = alcada(avio, new Coordenada(), avions);
                    break;
                case 4:
                    avio = moviment(avio, new Coordenada(), avions);
                    break;
                case 5:

                    break;
                case 6:
                    avio = trenAterratge(avio);
                    break;
                case 7:
                    print.infoAvio(avio);
                    break;
                case 8:
                    if (deCombat) {

                    } else {
                        print.blocked();
                    }
                    break;
                case 9:
                    if (deCombat) {

                    } else {
                        print.blocked();
                    }
                    break;
                default:
                    print.printNoOpcioSwitch();
            }

            if (avio.isDestruit()) {

                opcio = 0;

            } else {

                if (!deCombat) {
                    print.printControladorAvio();
                } else {
                    print.printControladorAvioCombat();
                }

                opcio = teclat.llegirEnter("Què vols fer? ");

            }
        }

        print.YareYareDaze();
    }

    public Avio motor(Avio avio, ArrayList<Avio> avions) {

        boolean motor = avio.getMotor();

        print.gestioMotor(motor);

        if (teclat.llegirEnter() == 2) {

            if (avio.getVelocitat() > 0) {
                print.errorPilot();
            } else {
                avio.apagarMotor();
                print.motorApagat();
            }

        } else {
            avio.encendreMotor();
            print.motorEnces();

            if (avio.getPosicioRumb().getZ() == 0) {
                print.volsEnlairar();

                if (teclat.llegirEnter("Vols enlairar-te? ") == 1) {

                    avio = avio.enlairarse(avio, avions);
                }
            }
        }

        return avio;
    }

    public Avio velocitat(Avio avio, ArrayList<Avio> avions) {

        int novaVelocitat;

        if (avio.getMotor()) {

            novaVelocitat = teclat.llegirEnter("Velocitat desitjada?");

            while (novaVelocitat < 0) {
                novaVelocitat = teclat.llegirEnter("Velocitat desitjada?");
            }

            if (novaVelocitat == 0) {
                if (avio.getPosicioRumb().getZ() > 0) {
                    print.errorPilot();
                } else {
                    avio.setVelocitat(novaVelocitat);
                }
            } else {
                avio.setVelocitat(novaVelocitat);
            }
        } else {
            print.noMotor();
            motor(avio, avions);
            /*avio = velocitat(avio, avions);*/
        }

        return avio;
    }

    public Avio alcada(Avio avio, Coordenada desti, ArrayList<Avio> avions) {

        if (avio.getMotor()) {

            if (avio.getVelocitat() >= 150) {

                int zNew = teclat.llegirEnter("A quina alçada vols anar? ");

                while (zNew < 0) {
                    zNew = teclat.llegirEnter("A quina alçada vols anar? ");
                }

                if (avio.getTrenAterratge() && zNew > 500) {

                    print.alturaTren();
                    /*avio = trenAterratge(avio);*/
                    /*avio = alcada(avio, new Coordenada(avio.getPosicioRumb().getX(), avio.getPosicioRumb().getY(), avio.getPosicioRumb().getZ()), avions);*/

                } else if (zNew == 0 && avio.getPosicioRumb().getX() != 100 && (avio.getPosicioRumb().getY() < 100 || avio.getPosicioRumb().getY() > 120)) {

                    avio = logic.eliminarAvio(avio);
                    print.avioDestruit();

                } else {

                    desti.setZ(zNew);
                    avio = avio.alcada(desti, avions);
                }

            } else {
                print.noMinimVel();
                avio = velocitat(avio, avions);
                /*avio = alcada(avio, new Coordenada(avio.getPosicioRumb().getX(), avio.getPosicioRumb().getY(), avio.getPosicioRumb().getZ()), avions);*/
            }

        } else {
            print.noMotor();
            motor(avio, avions);
            /*avio = alcada(avio, new Coordenada(avio.getPosicioRumb().getX(), avio.getPosicioRumb().getY(), avio.getPosicioRumb().getZ()), avions);*/
        }

        return avio;
    }

    public Avio moviment(Avio avio, Coordenada desti, ArrayList<Avio> avions) {

        if (avio.getMotor()) {

            if (avio.getVelocitat() >= 150) {
                avio.moviment(desti, avions);
            } else {
                print.noMinimVel();
                avio = velocitat(avio, avions);
                /*avio = moviment(avio, desti, avions);*/
            }

        } else {
            print.noMotor();
            avio = motor(avio, avions);
            /*avio = moviment(avio, desti, avions);*/
        }

        return avio;
    }

    public Avio trenAterratge(Avio avio) {

        if (avio.getTrenAterratge()) {

            if (avio.getPosicioRumb().getZ() != 0) {

                avio.pujarTren();
                print.trenAterratgePujat();

            } else {
                print.terra();
            }

        } else {

            if (avio.getPosicioRumb().getZ() < 500) {

                if (avio.getVelocitat() < 300) {

                    avio.baixarTren();
                    print.trenAterratgeBaixat();

                } else {
                    print.massaVelocitat();
                }

            } else {
                print.massaAltura();
            }
        }

        return avio;
    }
}
