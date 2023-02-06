package com.tdm.converter;

import com.tdm.converter.csv.CsvContactWriter;
import com.tdm.converter.exception.CsvWriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

    private static final Logger LOG = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) {
        String vcfFolderPath = args[0];
        String csvFileName = args[1];

        try {
            VcfToCsvConverter vcfToCsvConverter = new VcfToCsvConverter(vcfFolderPath, csvFileName);
            vcfToCsvConverter.convert();
        } catch (Exception e) {
            LOG.error("Converter error", e);
        }
    }
}
