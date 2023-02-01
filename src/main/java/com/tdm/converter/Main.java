package com.tdm.converter;

public class Main {

    public static void main(String[] args) {
        String vcfFolderPath = args[0];
        String csvFileName = args[1];

        try {
            VcfToCsvConverter vcfToCsvConverter = new VcfToCsvConverter(vcfFolderPath, csvFileName);
            vcfToCsvConverter.convert();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
