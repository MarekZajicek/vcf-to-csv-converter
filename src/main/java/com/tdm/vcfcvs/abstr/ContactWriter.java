package com.tdm.vcfcvs.abstr;

import com.tdm.vcfcvs.dto.Contact;

import java.io.IOException;

/**
 * Created by Taras on 07/12/2014.
 */
public interface ContactWriter {
    public void writeContact(Contact contact) throws IOException;

}
