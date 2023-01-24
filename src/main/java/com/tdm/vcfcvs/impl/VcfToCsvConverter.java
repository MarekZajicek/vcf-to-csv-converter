package com.tdm.vcfcvs.impl;

import java.io.File;
import java.io.IOException;

/**
 * Created by Taras on 07/12/2014.
 */
public class VcfToCsvConverter {
    private final String vcfFilesPath;
    private final String cvsFile;

    public VcfToCsvConverter(String vcfFilesPath, String cvsFile) {
        this.vcfFilesPath = vcfFilesPath;
        this.cvsFile = cvsFile;
    }

    public void convert() throws IOException {
        VcfFolderReader reader = new VcfFolderReader(new File(vcfFilesPath));
        CsvContactWriter writer = new CsvContactWriter(cvsFile);
        reader.readContact(writer.getConsumer());
        writer.close();
    }
}
