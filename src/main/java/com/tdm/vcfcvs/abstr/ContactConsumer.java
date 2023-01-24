package com.tdm.vcfcvs.abstr;

import com.tdm.vcfcvs.dto.Contact;

public interface ContactConsumer {

    public void onContactRead(Contact contact);

}
