package org.bytegeeks.learn.spring.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Logger;

import org.bytegeeks.learn.spring.api.Contact;
import org.bytegeeks.learn.spring.api.IContactService;
import org.bytegeeks.learn.spring.api.PhoneNumber;
import org.bytegeeks.learn.spring.api.PhoneNumber.Type;
import org.springframework.stereotype.Component;

@Component
public class ContactService implements IContactService {

    //Map to store Contact.toString and corresponding Contact 
    private Map<String, Contact> mapUUIDToContact = new HashMap<String, Contact>();

    private static final Logger LOG = Logger.getLogger(ContactService.class.getName());

    /* (non-Javadoc)
     * @see org.bytegeeks.learn.spring.service.IContactService#getContact(java.lang.String)
     */
    public List<Contact> getContact(String matchExpr) {
        List<Contact> contacts = new ArrayList<Contact>();
        LOG.info("Going to fetch contacts with expression: " + matchExpr);

        if (matchExpr == null) {
            contacts.addAll(mapUUIDToContact.values());
        } else {
            Iterator<Contact> itr = mapUUIDToContact.values().iterator();
            while (itr.hasNext()) {
                Contact contact = itr.next();
                LOG.info("Checking if " + contact + " contains " + matchExpr);
                if (contact.toString().contains(matchExpr)) {
                    contacts.add(contact);
                }
            }
        }

        return contacts;
    }

    /* (non-Javadoc)
     * @see org.bytegeeks.learn.spring.service.IContactService#addContact(org.bytegeeks.learn.spring.api.Contact)
     */
    public boolean addContact(Contact contact) {
        boolean result = false;
        if (contact.getUUID() == null) {
            UUID uuid = UUID.randomUUID();
            contact.setUUID(uuid);
        }
        mapUUIDToContact.put(contact.getUUID().toString(), contact);
        result = true;
        LOG.info("Successfully added contact: " + contact);

        return result;
    }

    /* (non-Javadoc)
     * @see org.bytegeeks.learn.spring.service.IContactService#deleteContact(java.lang.String)
     */
    public boolean deleteContact(String uuid) {
        boolean result = false;
        Contact deletedContact = mapUUIDToContact.remove(uuid);
        if (deletedContact != null) {
            LOG.info("Successfully deleted contact: " + deletedContact);
            result = true;
        } else {
            LOG.severe("Contact with UUID: " + uuid + " doesn't exist");
            result = false;
        }
        return result;
    }

    /* (non-Javadoc)
     * @see org.bytegeeks.learn.spring.service.IContactService#updateContact(org.bytegeeks.learn.spring.api.Contact)
     */
    public boolean updateContact(Contact contact) {
        boolean result = false;
        mapUUIDToContact.put(contact.getUUID().toString(), contact);
        LOG.info("Successfully updated contact: " + contact);
        return result;
    }

    /* (non-Javadoc)
     * @see org.bytegeeks.learn.spring.service.IContactService#generateRandomData()
     */
    public String generateRandomData() {
        Random random = new Random();
        int totalCount = random.nextInt(500);
        
        if (totalCount == 0) {
            random = new Random();
            totalCount = random.nextInt(500);
        }

        for (int i = 0; i < totalCount; i++) {
            Random randomizer = new Random();
            Contact c = new Contact();
            
            int firstNameLength = randomizer.nextInt(5) + 5;
            String firstName = "";
            for(int j=0;j<firstNameLength;j++) {
                Random r = new Random();
                int tempChar = r.nextInt(26) + 65;
                firstName = firstName + "" + (char) tempChar;
            }
            
            int lastNameLength = randomizer.nextInt(5) + 5;
            String lastName = "";
            for (int j = 0; j < lastNameLength; j++) {
                Random r = new Random();
                int tempChar = r.nextInt(26) + 65;
                lastName = lastName + "" + (char) tempChar;
            }

            c.setFirstName(firstName);
            c.setLastName(lastName);

            int countryCode = randomizer.nextInt(999);
            int areaCode = randomizer.nextInt(999);
            
            String str = String.valueOf(randomizer.nextLong());
            long number = Long.valueOf(str.substring(str.length() - 10));
            System.out.println(number);

            int type = randomizer.nextInt(3);
            Type phoneType = Type.values()[type];
            PhoneNumber pNumber = new PhoneNumber(countryCode, areaCode, number);
            pNumber.setType(phoneType);
            c.addPhoneNumber(pNumber);

            addContact(c);
        }


        String str = "Generated " + totalCount + " random contacts";
        LOG.info(str);

        return str;
    }
}
