package com.tdm.vcfcvs.impl;

import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URL;

public class VcfToCsvConverterTest {


    @Test
    public void testConvert() throws IOException {
        String folderPath = getClass().getClassLoader().getResource("contacts").getPath();

        VcfToCsvConverter vcfToCsvConverter = new VcfToCsvConverter(folderPath, "target/test");

        vcfToCsvConverter.convert();

    }
}