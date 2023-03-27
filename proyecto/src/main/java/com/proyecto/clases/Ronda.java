package com.proyecto.clases;
public class Ronda {
    private String nro;
    private Partido[] partidos;
    public Ronda(String nro, Partido[] partidos) {
        this.nro = nro;
        this.partidos = partidos;
    }

    public int puntos(String nro, Partido[] partidos){
        int p=0;
        /*
        for (int i=0; i< partidos.length;i++ ) {
            if (partidos[i] == nro){
                p++;
            }
        }*/
        return p;
    }

    public int puntos_v2(Partido[] partidos, Partido[] pronostico){
        int puntosAcierto=0;

        for (int i=0; i< partidos.length;i++ ) {
            if (partidos[i] == pronostico[i]){
                puntosAcierto++;
            }
        }
        return puntosAcierto;
    }

    //Metodos getter y setter
    public String getNro() {
        return nro;
    }
    public void setNro(String nro) {
        this.nro = nro;
    }
    public Partido[] getPartidos() {
        return partidos;
    }
    public void setPartidos(Partido[] partidos) {
        this.partidos = partidos;
    }
}
