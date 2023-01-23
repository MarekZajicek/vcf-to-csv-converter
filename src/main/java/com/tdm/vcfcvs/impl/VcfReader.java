package com.tdm.vcfcvs.impl;

import com.tdm.vcfcvs.abstr.ContactConsumer;
import com.tdm.vcfcvs.abstr.ContactReader;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Scanner;

public class VcfReader implements ContactReader {
    private File file;

    public VcfReader(String filePath) {
        this.file = new File(filePath);
    }

    private String getVcfValue(String line) {
        return line.split(":")[1];
    }

    @Override
    public void readContact(ContactConsumer consumer) throws IOException {
        FileInputStream in = new FileInputStream(file);
        Scanner scanner = new Scanner(in);

        String name = null;
        String phone = null;

        while (scanner.hasNext()) {
            String line = scanner.nextLine();
            if (line.startsWith("N;CHARSET")) {
                name = getVcfValue(line);
            } else if (line.startsWith("TEL")) {
                phone = getVcfValue(line);
            }
        }

        if (phone != null && phone.startsWith("+38")) {
            phone = phone.substring(3);
        }

        if (name == null) {
            String nameWithExt = file.getName();
            //get rid of file extension
            name = nameWithExt.substring(0, nameWithExt.length() - 4);
        }

        consumer.onContactRead(new Contact(name, phone));
        in.close();
    }
}
