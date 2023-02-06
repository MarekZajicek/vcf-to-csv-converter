package com.tdm.converter.dto;

import static com.tdm.converter.csv.CsvContactWriter.CSV_DELIMITER;

public class ContactDto {

    private final NameDto name;
    private final String phone;
    private final String email;

    public ContactDto(NameDto name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    public String toCsv() {
        return String.join(CSV_DELIMITER, name.getName(), name.getSurname(), email, phone) + ";";
    }

    @Override
    public String toString() {
        return toCsv();
    }
}
