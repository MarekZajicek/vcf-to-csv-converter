package com.tdm.converter.csv;

import com.tdm.converter.dto.ContactDto;

import java.io.IOException;

/**
 * Created by Taras on 07/12/2014.
 */
public interface ContactWriter {

    void writeContact(ContactDto contactDto) throws IOException;

}
