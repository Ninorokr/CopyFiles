package com.alvarogiron;

import java.io.*;

public class Main {

    public static void main(String[] args) {

        final File folder = new File("Z:\\Alvaro Giron\\Bases contrastes\\Contrastes\\SETIEMBRE\\2006618");
        listFilesForFolder(folder);
    }

    public static void copyFile(File input){
        File output = new File("Z:\\Alvaro Giron\\Bases contrastes\\Contrastes\\SETIEMBRE\\2006621\\2006621"+input.getName().substring(7,17));
        try(BufferedInputStream bis = new BufferedInputStream(new FileInputStream(input));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(output))){
            bos.write(bis.readAllBytes());
        } catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    public static void listFilesForFolder(final File folder) throws NullPointerException {
        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isDirectory()) {
                listFilesForFolder(fileEntry);
            } else {
                copyFile(fileEntry);
            }
        }
    }

}
