package com.company;

import java.util.ArrayList;

public class Pilot {

    Print print = new Print();
    cLector teclat = new cLector();
    Logic logic = new Logic();
    Collisio collisio = new Collisio();

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
                    avio = rumb(avio);
                    break;
                case 6:
                    avio = trenAterratge(avio);
                    break;
                case 7:
                    print.infoAvio(avio);
                    break;
                case 8:
                    if (deCombat) {
                        avio = iniciarOperacio(avio, avions);
                    } else {
                        print.blocked();
                    }
                    break;
                case 9:
                    if (deCombat) {
                        avio = finalitzarOperacio(avio);
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

    private Avio rumb(Avio avio) {

        print.escollirRumb();

        Coordenada posicioRumb = avio.getPosicioRumb();

        switch (teclat.llegirEnter("On vols anar? ")) {
            case 1:

                posicioRumb.setDireccio(Direccio.AMUNT);
                avio.setPosicioRumb(posicioRumb);

                break;
            case 2:

                posicioRumb.setDireccio(Direccio.AVALL);
                avio.setPosicioRumb(posicioRumb);

                break;
            case 3:

                posicioRumb.setDireccio(Direccio.ESQUERRA);
                avio.setPosicioRumb(posicioRumb);

                break;
            case 4:

                posicioRumb.setDireccio(Direccio.DRETA);
                avio.setPosicioRumb(posicioRumb);

                break;
            default:
                print.printNoOpcioSwitch();
        }

        print.rumbCanviat();

        return avio;
    }

    private Avio iniciarOperacio(Avio avio, ArrayList<Avio> avions) {

        ArrayList<Avio> avionsFiltre;
        ArrayList<Misil> misils;
        Avio avioComercial;
        Logic logic;
        int posicio;

        if (avio instanceof AvioCombat) {

            if (((AvioCombat) avio).getMisils().size() > 0) {

                print.operativaBegin();

                Collisio objCollisio;

                misils = ((AvioCombat) avio).getMisils();

                objCollisio = collisio.logicaCollisio(avio, avions, avio.getPosicioRumb(), misils.get(0).getDistanciaDispar());

                avionsFiltre = print.llistaAvions(objCollisio.getAvionsEnRang(), Filtre.TOTS, 4);

                if (avionsFiltre.size() > 0) {
                    logic = this.logic.trobar(avionsFiltre);

                    if (logic.isSeleccionat()) {

                        ((AvioCombat) avio).setEnMissio(true);

                        posicio = logic.getPosicio();

                        avioComercial = avionsFiltre.get(posicio);

                        misils.remove(misils.size() - 1);

                        ((AvioCombat) avio).setMisils(misils);

                        logic.eliminarAvio(avioComercial, avions);

                        print.avioDestruit();

                    } else {
                        print.YareYareDaze();
                    }
                }
            } else {

            }
        }

        return avio;
    }

    private Avio finalitzarOperacio(Avio avio) {

        if (avio instanceof AvioCombat) {

            if (((AvioCombat) avio).isEnMissio()) {
                ((AvioCombat) avio).setEnMissio(false);
                print.operativaEnd();
            } else {
                print.operativaDesc();
            }

        }

        return avio;
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

                    avio = logic.eliminarAvio(avio, avions);
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

                if (avio.getPosicioRumb().getZ() > 0) {
                    avio.moviment(desti, avions);
                } else {
                    print.terra();
                    avio = alcada(avio, new Coordenada(avio.getPosicioRumb().getX(), avio.getPosicioRumb().getY(), avio.getPosicioRumb().getZ()), avions);
                }
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
