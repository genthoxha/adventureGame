package com.objectsStudenti;

public class Studenti {
    private int id;
    private String emri;

    public Studenti(int id, String emri) throws UniException {
        if (id <= 0) {
            throw new UniException("ID e studentit duhet te jete pozitiv");
        }
        if (Util.isEmpty(emri)) {
            throw new UniException("Mungon emri i studentit");
        }
        this.id = id;
        this.emri = emri;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmri() {
        return emri;
    }

    public void setEmri(String emri) {
        this.emri = emri;
    }

    public String toString() {
        return id + ": " + emri;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Studenti) {
            Studenti studenti = (Studenti) object;
            return id == studenti.getId();
        }
        return false;
    }

}
