package org.bytegeeks.learn.spring.api;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class Contact {

    private UUID uuid = null;
    private String firstName = null;
    private String lastName = null;
    private List<PhoneNumber> listPhoneNumber = null;
    private String emailAddress;

    public Contact() {
        uuid = UUID.randomUUID();
    }

    public UUID getUUID() {
        return uuid;
    }

    public void setUUID(UUID uuid) {
        this.uuid = uuid;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<PhoneNumber> getListPhoneNumber() {
        return listPhoneNumber;
    }

    public void addPhoneNumber(PhoneNumber number) {
        if (listPhoneNumber == null) {
            listPhoneNumber = new ArrayList<PhoneNumber>();
        }
        listPhoneNumber.add(number);
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Override
    public String toString() {
        return firstName + "," + lastName + "," + listPhoneNumber + "," + emailAddress;
    }

}
