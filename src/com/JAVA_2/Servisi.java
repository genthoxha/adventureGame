package com.JAVA_2;

public abstract class Servisi {

    protected int cmimi;

    public Servisi(int cmimi) throws HoteliException {
        if (cmimi < 0) {
            throw new HoteliException("Cmimi duhet te jete vlere pozitive !");
        }
        this.cmimi = cmimi;
    }

    public abstract int llogaritjaCmimit();
}
