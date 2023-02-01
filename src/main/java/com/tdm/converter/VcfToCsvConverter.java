package com.tdm.converter;

import com.tdm.converter.csv.CsvContactWriter;
import com.tdm.converter.vcf.VcfFolderReader;

import java.io.File;
import java.io.IOException;

/**
 * Created by Taras on 07/12/2014.
 */
public class VcfToCsvConverter {
    private final String vcfFolderPath;
    private final String cvsFile;

    public VcfToCsvConverter(String vcfFolderPath, String cvsFile) {
        this.vcfFolderPath = vcfFolderPath;
        this.cvsFile = cvsFile;
    }

    public void convert() throws IOException {
        VcfFolderReader reader = new VcfFolderReader(new File(vcfFolderPath));
        try (CsvContactWriter writer = new CsvContactWriter(cvsFile)) {
            reader.readContact(writer.getConsumer());
        }
    }
}
