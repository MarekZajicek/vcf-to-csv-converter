package com.tdm.converter.vcf;

import com.tdm.converter.csv.ContactConsumer;

import java.io.File;
import java.io.IOException;

public class VcfFolderReader implements ContactReader {

    private final File folder;

    public VcfFolderReader(File folder) {
        this.folder = folder;
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("First argument should be a directory");
        }
    }

    @Override
    public void readContact(ContactConsumer consumer) throws IOException {
        String[] vcfFiles = folder.list((dir, name) -> name.toLowerCase().endsWith(".vcf"));

        if (vcfFiles != null) {
            int processedVcfCount = 0;
            for (String fileName : vcfFiles) {
                new VcfReader(folder.getAbsolutePath() + File.separator + fileName)
                        .readContact(consumer);
                processedVcfCount++;
            }
            System.out.println("VCF files found: " + processedVcfCount);
        }
    }
}
