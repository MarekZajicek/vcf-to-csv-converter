package com.tdm.converter.dto;

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
        String csvLine = String.join(",", name.getName(), name.getSurname(), email, phone) + ";";
        System.out.println(csvLine);
        System.out.println();
        return csvLine;
    }

    @Override
    public String toString() {
        return toCsv();
    }
}
