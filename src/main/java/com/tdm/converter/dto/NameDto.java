package com.tdm.converter.dto;

public class NameDto {

    private final String name;
    private final String surname;

    public NameDto(String name, String surname) {
        this.name = name;
        this.surname = surname;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }
}
