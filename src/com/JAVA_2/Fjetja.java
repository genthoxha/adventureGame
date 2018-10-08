package com.JAVA_2;

public class Fjetja extends Servisi {

    private int ditetEQendrimit;

    public Fjetja(int cmimi, int ditetEQendrimit)throws HoteliException {
        super(cmimi);
        if (ditetEQendrimit <= 0) {
            throw new HoteliException("Qendrimi duhet te zgjase se paku per 24h pagese !");
        }
        this.ditetEQendrimit = ditetEQendrimit;

    }

    @Override
    public int llogaritjaCmimit() {
        return ditetEQendrimit * cmimi;
    }
}
