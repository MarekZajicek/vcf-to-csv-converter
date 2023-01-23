package com.tdm.vcfcvs.abstr;

import java.io.IOException;

/**
 * Created by Taras on 07/12/2014.
 */
public interface ContactReader {
    public void readContact(ContactConsumer consumer) throws IOException;
}
