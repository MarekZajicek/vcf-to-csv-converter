package com.tdm.converter.csv;

import com.tdm.converter.dto.ContactDto;
import com.tdm.converter.exception.CsvWriterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;

public class CsvContactWriter implements ContactWriter, AutoCloseable {

    private static final Logger LOG = LoggerFactory.getLogger(CsvContactWriter.class);

    public static final String CSV_EXTENSION = ".csv";
    private static final String CSV_HEADER = "First Name,Last Name,E-mail Address,Primary Phone";
    public static final String CSV_DELIMITER = ",";

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
        String csvLine = contactDto.toCsv();
        LOG.debug("Writing to file '{}' \nCSV line: {}\n", file.getName(), csvLine);
        writer.println(csvLine);
        writer.flush();
    }

    public ContactConsumer getConsumer() {
        return contactDto -> {
            try {
                writeContact(contactDto);
            } catch (Exception e) {
                LOG.error("CSV writer error", e);
                throw new CsvWriterException(e);
            }
        };
    }

    @Override
    public void close() {
        writer.close();
    }
}
