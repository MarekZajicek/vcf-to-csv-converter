package com.tdm.vcfcvs.impl;

import com.tdm.vcfcvs.abstr.ContactConsumer;
import com.tdm.vcfcvs.abstr.ContactReader;

import java.io.File;
import java.io.IOException;

public class VcfFolderReader implements ContactReader {
    private File file;

    public VcfFolderReader(File file) {
        this.file = file;
        if (!file.isDirectory())
            throw new IllegalArgumentException("Argument should be a directory");
    }

    @Override
    public void readContact(ContactConsumer consumer) throws IOException {
        String[] vcfFiles = file.list((dir, name) -> name.toLowerCase().endsWith(".vcf"));

        for (String fileName : vcfFiles) {
            new VcfReader(file.getAbsolutePath() + File.separator + fileName).readContact(consumer::onContactRead);
        }
    }
}
