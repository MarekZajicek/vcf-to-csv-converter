package com.tdm.converter.csv;

import com.tdm.converter.dto.ContactDto;

public interface ContactConsumer {

    void onContactRead(ContactDto contactDto);

}
