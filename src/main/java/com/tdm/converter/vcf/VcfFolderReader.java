package com.tdm.converter.vcf;

import com.tdm.converter.csv.ContactConsumer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;

public class VcfFolderReader implements ContactReader {

    private static final Logger LOG = LoggerFactory.getLogger(VcfFolderReader.class);

    private final File folder;

    public VcfFolderReader(File folder) {
        this.folder = folder;
        if (!folder.isDirectory()) {
            throw new IllegalArgumentException("First argument should be a directory");
        }
    }

    @Override
    public void readContact(ContactConsumer consumer) throws IOException {
        LOG.info("Trying to find VCF files in directory '{}'", folder.getName());
        String[] vcfFiles = folder.list((dir, name) -> name.toLowerCase().endsWith(".vcf"));

        if (vcfFiles != null && vcfFiles.length > 0) {
            LOG.info("VCF files found: {}", vcfFiles.length);
            for (String fileName : vcfFiles) {
                new VcfReader(folder.getAbsolutePath() + File.separator + fileName)
                        .readContact(consumer);
            }
        } else {
            LOG.warn("No VCF file in '{}' folder", folder.getName());
        }
    }
}
