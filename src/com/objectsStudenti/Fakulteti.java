package com.objectsStudenti;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Objects;

public class Fakulteti implements Serializable {

    private String emri;
    private transient Studenti[] studentet;
    private int index;

    public Fakulteti(String emri, int nrStudenteve) throws UniException{
        if (Util.isEmpty(emri)) {
            throw new UniException("Mungon emri i fakultetit");
        }
        if (nrStudenteve < 5) {
            throw new UniException("Fakulteti duhet te pranoi se paku 5 studente");
        }
        this.emri = emri;
        studentet = new Studenti[nrStudenteve];
    }

    public void shtoStudentin(Studenti studenti) throws UniException {
        if (studenti == null) {
            throw new UniException("shtoStudentin: studenti eshte NULL");
        }
        if (index == studentet.length) {
            throw new UniException("Nuk ka vend te lire ne varg");
        }
        if (ekziston(studenti)) {
            throw new UniException("Studenti egziston ne varg");
        }
        studentet[index++] = studenti;
    }

    public boolean ekziston(Studenti studenti) {
        for (int i = 0; i < index; i++) {
            if (studentet[i].equals(studenti)) {
                return true;
            }
        }
        return false;
    }

    public void ndryshoEmrinStudentit(int id, String emriRi) throws UniException {
        for (int i = 0; i < index; i++) {
            if (studentet[i].getId() == id) {
                studentet[i].setEmri(emriRi);
                return;
            }
        }
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(emri).append("\n---------------------\n");
        if (studentet != null) {
            for (int i = 0; i < index; i++) {
                Studenti studenti = studentet[i];
                sb.append(studenti).append("\n\r");
            }
        } else {
            sb.append("VARGU ESHTE NULL");
        }
        return sb.toString();
    }

    @Override
    public boolean equals(Object obj) {

        if (obj instanceof Fakulteti) {
            final Fakulteti fakulteti = (Fakulteti) obj;
            return emri != null && Objects.equals(emri, fakulteti.emri);
        }
        return false;
    }

    private void writeObject(ObjectOutputStream objectOutputStream)throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeInt(studentet.length);
        for (int i = 0; i < index ; i++) {
            Studenti studenti = studentet[i];
            objectOutputStream.writeInt(studenti.getId());
            objectOutputStream.writeUTF(studenti.getEmri());
        }
    }

    private void readObject(ObjectInputStream objectInputStream)throws IOException,ClassNotFoundException {
        objectInputStream.defaultReadObject();
        int size = objectInputStream.readInt();
        studentet = new Studenti[size];
        for (int i = 0; i < index; i++) {
            int idS = objectInputStream.readInt();
            String emriS = objectInputStream.readUTF();
            try {
                studentet[i] = new Studenti(idS, emriS);
            } catch (UniException e) {
                throw new IOException(e);
            }
        }
    }

    }
