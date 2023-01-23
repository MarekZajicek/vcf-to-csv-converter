package com.tdm.vcfcvs.impl;

public class Contact {
    public String name;
    public String mobile;

    public Contact(String name, String mobile) {
        this.name = name;
        this.mobile = mobile;
    }

    public String toCsv() {
        return name + ";; " + mobile+";";
    }

    @Override
    public String toString() {
        return toCsv();
    }
}
