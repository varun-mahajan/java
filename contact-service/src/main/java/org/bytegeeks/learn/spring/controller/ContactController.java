package org.bytegeeks.learn.spring.controller;

import java.util.List;

import org.bytegeeks.learn.spring.api.Contact;
import org.bytegeeks.learn.spring.api.IContactService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.wordnik.swagger.annotations.ApiOperation;

@Controller
public class ContactController {

    @Autowired
    private IContactService contactService;

    private static final Logger LOG = LoggerFactory.getLogger(ContactController.class);

    @ApiOperation(notes = "Get Contacts", value = "List all contacts or with a search criteria")
    @RequestMapping(value = "/contact", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<List<Contact>> getContact(@RequestParam(required = false, value = "q") String q) {
        ResponseEntity<List<Contact>> returnValue = new ResponseEntity<List<Contact>>(contactService.getContact(q),
                HttpStatus.OK);
        LOG.info("total contacts returned: {}", returnValue.getBody().size());
        return returnValue;
    }

    @RequestMapping(value = "/contact/{id}", method = RequestMethod.DELETE, produces = { "application/json" })
    public ResponseEntity<String> deleteContact(@PathVariable String id) {
        boolean result = contactService.deleteContact(id);
        if (result)
            return new ResponseEntity<String>("Success", HttpStatus.OK);
        else
            return new ResponseEntity<String>("Contact with id: " + id + " not found", HttpStatus.NOT_FOUND);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.POST, produces = { "application/json" }, consumes = {
            "application/json" })
    public ResponseEntity<HttpStatus> addContact(@RequestBody Contact contact) {
        boolean result = contactService.addContact(contact);
        if (result)
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        else
            return new ResponseEntity<HttpStatus>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @RequestMapping(value = "/contact", method = RequestMethod.PUT, produces = { "application/json" }, consumes = {
            "application/json" })
    public ResponseEntity<HttpStatus> updateContact(@RequestBody Contact contact) {
        boolean result = contactService.updateContact(contact);
        if (result)
            return new ResponseEntity<HttpStatus>(HttpStatus.OK);
        else
            return new ResponseEntity<HttpStatus>(HttpStatus.NOT_FOUND);
    }

    @ApiOperation(notes = "Get Contacts", value = "List all contacts or with a search criteria")
    @RequestMapping(value = "/contact/test", method = RequestMethod.GET, produces = { "application/json" })
    public ResponseEntity<String> test() {
        LOG.info("All OK");
        String str = contactService.generateRandomData();
        return new ResponseEntity<String>(str, HttpStatus.OK);
    }

}
