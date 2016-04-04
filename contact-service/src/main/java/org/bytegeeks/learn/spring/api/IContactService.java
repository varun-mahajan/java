package org.bytegeeks.learn.spring.api;

import java.util.List;

public interface IContactService {

    public List<Contact> getContact(String matchExpr);

    public boolean addContact(Contact contact);

    public boolean deleteContact(String uuid);

    public boolean updateContact(Contact contact);

    public String generateRandomData();

}