package com.company;

enum Direccio {
    AMUNT,
    AVALL,
    ESQUERRA,
    DRETA
}

public class Coordenada  {

    private int x;
    private int y;
    private int z;
    private String direccio;

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public int getZ() {
        return z;
    }

    public void setZ(int z) {
        this.z = z;
    }

    public String getDireccio() {
        return direccio;
    }

    public void setDireccio(Direccio direccio) {
        switch (direccio) {
            case AMUNT:
                this.direccio = "amunt";
                break;
            case AVALL:
                this.direccio = "avall";
                break;
            case DRETA:
                this.direccio = "dreta";
                break;
            case ESQUERRA:
                this.direccio = "esquerre";
                break;
        }
    }
}
