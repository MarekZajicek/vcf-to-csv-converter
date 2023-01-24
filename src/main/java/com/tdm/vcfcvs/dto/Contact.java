package com.tdm.vcfcvs.dto;

public class Contact {

    private final String name;
    private final String mobile;
    private final String birthDay;

    public Contact(String name, String mobile, String birthDay) {
        this.name = name;
        this.mobile = mobile;
        this.birthDay = birthDay;
    }

    public String toCsv() {
        String csvLine = String.join(";", name, "", mobile)+";";
        System.out.println(csvLine);
        System.out.println();
        return csvLine;
    }

    @Override
    public String toString() {
        return toCsv();
    }
}
