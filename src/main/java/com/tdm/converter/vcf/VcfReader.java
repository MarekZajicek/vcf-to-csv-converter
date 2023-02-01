package com.tdm.converter.vcf;

import com.tdm.converter.csv.ContactConsumer;
import com.tdm.converter.dto.ContactDto;
import com.tdm.converter.dto.NameDto;
import com.tdm.converter.exception.VcfReaderException;

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

            String name = "";
            String surname = "";
            String phone = "";
            String email = "";

            while (scanner.hasNext()) {
                String line = scanner.nextLine();
                if (!line.isEmpty()) {
                    System.out.println(line);
                }
                if (line.equals("END:VCARD")) {
                    System.out.println();
                }
                if (line.startsWith("N:")) {
                    String[] nameArray = getVcfValue(line).split(";");
                    surname = nameArray[0];
                    name = nameArray[1];
                } else if (line.contains("TEL:")) {
                    phone = getVcfValue(line);
                } else if (line.contains("EMAIL;")) {
                    email = getVcfValue(line);
                }
            }

            if (name == null) {
                throw new VcfReaderException("Name value 'N' is mandatory item");
            }

            consumer.onContactRead(new ContactDto(new NameDto(name, surname), phone, email));
        }
    }

}
