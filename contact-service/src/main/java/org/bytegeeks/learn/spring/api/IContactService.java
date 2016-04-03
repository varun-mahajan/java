package org.bytegeeks.learn.spring.api;

import java.util.List;

public interface IContactService {

    List<Contact> getContact(String matchExpr);

    boolean addContact(Contact contact);

    boolean deleteContact(String uuid);

    boolean updateContact(Contact contact);

    String generateRandomData();

}