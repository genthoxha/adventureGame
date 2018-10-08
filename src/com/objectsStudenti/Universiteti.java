package com.objectsStudenti;

import java.io.*;

public class Universiteti {

    private Fakulteti fakulteti = null;

    public Universiteti() {

    }

    public Universiteti(String emriFakultetit, int nrStudenteve)throws UniException {
        fakulteti = new Fakulteti(emriFakultetit, nrStudenteve);
    }

    public void shtoStudentin(int id, String emri)throws UniException{
        fakulteti.shtoStudentin(new Studenti(id,emri));
    }

    public void printFakultetin() {
        System.out.println(fakulteti);
    }

    public void ndryshoStudentin(int id, String emriRi) throws UniException{
        fakulteti.ndryshoEmrinStudentit(id, emriRi);
    }

    public void shkruajFakultetin()  {
        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("D:/test.txt"));
            objectOutputStream.writeObject(fakulteti);
            objectOutputStream.flush();
            System.out.println("Fakulteti u shkrua me sukses");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void lexoFakultetin()throws IOException {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("D:/test.txt"))) {
            try {
                fakulteti = (Fakulteti) objectInputStream.readObject();
            } catch (ClassNotFoundException ex) {
                throw new IOException(ex);
            }
        }
    }

    public static void main(String[] args) {
        String op = "R";
        try {
            if (op.equals("W")) {
                Universiteti universiteti = new Universiteti("SHK", 10);
                universiteti.shtoStudentin(12345, "Filani");
                universiteti.shtoStudentin(12346, "Filanja");
                universiteti.printFakultetin();
                universiteti.ndryshoStudentin(12345, "Filan Fisteku");
                universiteti.printFakultetin();
                universiteti.shkruajFakultetin();
            } else if (op.equals("R")) {
                Universiteti universiteti = new Universiteti();
                universiteti.lexoFakultetin();
                universiteti.shtoStudentin(12347, "Deme Alia");
                universiteti.printFakultetin();
            } else {
                System.out.println(op + "nuk perkrahet");
            }
        } catch (UniException ex) {
            System.out.println(ex);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

}
