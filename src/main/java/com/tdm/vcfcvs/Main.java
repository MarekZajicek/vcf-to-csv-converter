package com.tdm.vcfcvs;

import com.tdm.vcfcvs.impl.CsvContactWriter;
import com.tdm.vcfcvs.impl.VcfToCsvConverter;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        String vcfPath = args[0];
        String csv = args[1] + CsvContactWriter.CSV_EXTENSION;

        try {
            new VcfToCsvConverter(vcfPath, csv).convert();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
