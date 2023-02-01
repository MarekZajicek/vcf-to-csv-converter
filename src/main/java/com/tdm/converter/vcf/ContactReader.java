package com.tdm.converter.vcf;

import com.tdm.converter.csv.ContactConsumer;

import java.io.IOException;

/**
 * Created by Taras on 07/12/2014.
 */
public interface ContactReader {

    void readContact(ContactConsumer consumer) throws IOException;

}
