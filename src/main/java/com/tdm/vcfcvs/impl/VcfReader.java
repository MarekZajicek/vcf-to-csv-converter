package com.tdm.vcfcvs.impl;

import com.tdm.vcfcvs.abstr.ContactConsumer;
import com.tdm.vcfcvs.abstr.ContactReader;
import com.tdm.vcfcvs.dto.Contact;
import com.tdm.vcfcvs.exception.VcfReaderException;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Scanner;

public class VcfReader implements ContactReader {
    private final File file;

    public VcfReader(String filePath) {
        this.file = new File(filePath);
    }

    private String getVcfValue(String line) {
        return line.split(":")[1];
    }

    @Override
    public void readContact(ContactConsumer consumer) throws IOException {

        try (Scanner scanner = new Scanner(Files.newInputStream(file.toPath()))) {

            String name = null;
            String phone = null;
            String birthDay = null;

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    System.out.println(line);
                }
                if (line.equals("END:VCARD")) {
                    System.out.println();
                }
                if (line.startsWith("N:")) {
                    name = getVcfValue(line);
                } else if (line.startsWith("TEL")) {
                    phone = getVcfValue(line);
                }
            }

            if (name == null) {
                throw new VcfReaderException("Name value 'N' is mandatory item");
            }

            consumer.onContactRead(new Contact(name, phone, birthDay));
        }
    }

}
