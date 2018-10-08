package com.Skijatori;

import java.io.*;

public class CountFiles {

    private File folder = null;

    public CountFiles(String emri)throws IOException {
        folder = new File(emri);
        if (!folder.exists()) {
            throw new IOException("Emri nuk egziston!");
        }
        if (!folder.isDirectory()) {
            throw new IOException("Nuk eshte folder !");
        }
    }

    public void fileCount()throws IOException{

        File [] folders = folder.listFiles(
                new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        return pathname.getName().toUpperCase().endsWith("AT");
                    }
                }
        );
        File[] files = folder.listFiles(
                new FileFilter() {
                    @Override
                    public boolean accept(File pathname) {
                        if (pathname.isFile()) {
                            String emriFilet = pathname.getName();
                            int index = emriFilet.lastIndexOf(".");
                            if (index == -1) {
                                return emriFilet.toUpperCase().endsWith("AT");
                            }
                            return emriFilet.substring(index + 1).toUpperCase().endsWith("AT");
                        }
                        return false;
                    }
                }
        );

        try (PrintWriter pw = new PrintWriter(new FileWriter("F:/test.txt"))) {
            pw.println("Folderi " + folder.getName() + " ka:");
            pw.print("File " + files.length);
            pw.println("Folder " + folders.length);
        }

    }

    public static void main(String[] args) {
        try {
            CountFiles cf = new CountFiles("D:/test");
            cf.fileCount();
        } catch (IOException e) {
            System.out.println(e);

        }
    }

}
