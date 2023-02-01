package com.tdm.converter;

import com.tdm.converter.VcfToCsvConverter;
import org.testng.annotations.Test;

import java.io.IOException;

public class VcfToCsvConverterTest {

    @Test(expectedExceptions = IllegalArgumentException.class)
    public void testConvert_file_instead_folder() throws IOException {
        String folderPath = getClass().getClassLoader().getResource("test").getPath();

        new VcfToCsvConverter(folderPath, "target/test").convert();

    }

    @Test
    public void testConvert() throws IOException {
        String folderPath = getClass().getClassLoader().getResource("contacts").getPath();

        VcfToCsvConverter vcfToCsvConverter = new VcfToCsvConverter(folderPath, "target/test");

        vcfToCsvConverter.convert();

    }
}