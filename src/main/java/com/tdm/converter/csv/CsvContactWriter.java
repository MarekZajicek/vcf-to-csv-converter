package com.tdm.converter.csv;

import com.tdm.converter.dto.ContactDto;

import java.io.*;
import java.nio.file.Files;

public class CsvContactWriter implements ContactWriter, AutoCloseable {
    public static final String CSV_EXTENSION = ".csv";
    private static final String CSV_HEADER = "First Name,Last Name,E-mail Address,Primary Phone";

    private final File file;
    private PrintWriter writer;

    public CsvContactWriter(String cvsFile) throws IOException {
        if (!cvsFile.endsWith(CSV_EXTENSION)) {
            cvsFile += CSV_EXTENSION;
        }
        this.file = new File(cvsFile);

        createNewCsv();
    }

    private void createNewCsv() throws IOException {
        writer = new PrintWriter(Files.newOutputStream(file.toPath()));
        writer.println(CSV_HEADER);
        writer.flush();
    }

    @Override
    public void writeContact(ContactDto contactDto) throws IOException {
        writer.println(contactDto.toCsv());
        writer.flush();
    }

    public ContactConsumer getConsumer() {
        return contactDto -> {
            try {
                writeContact(contactDto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }

    @Override
    public void close() {
        writer.close();
    }
}
