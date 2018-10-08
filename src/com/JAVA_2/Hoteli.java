package com.JAVA_2;

public class Hoteli {

    private String emri;
    private int kategoria;
    private boolean depo;

    public Hoteli(String emri, int kategoria, boolean depo) throws HoteliException {

        if (emri == null || emri.trim().isEmpty()) {
            throw new HoteliException("Emri nuk duhet te jete i zbrazet !");
        }
        if (kategoria < 1 || kategoria > 5) {
            throw new HoteliException("Vlera e kategorise duhet te jete ndermjet 1 dhe 5");
        }
        this.emri = emri;
        this.kategoria = kategoria;
        this.depo = depo;

    }


}
