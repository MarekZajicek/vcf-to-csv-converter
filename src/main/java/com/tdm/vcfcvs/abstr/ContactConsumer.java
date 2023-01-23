package com.tdm.vcfcvs.abstr;

import com.tdm.vcfcvs.impl.Contact;

public interface ContactConsumer {
    public void onContactRead(Contact contact);
}
