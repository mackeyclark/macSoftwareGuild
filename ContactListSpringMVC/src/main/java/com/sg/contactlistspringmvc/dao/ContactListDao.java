/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.sg.contactlistspringmvc.dao;

import com.sg.contactlistspringmvc.model.Contact;
import java.util.List;
import java.util.Map;

/**
 *
 * @author macam
 */
public interface ContactListDao {
    //add the given contact to the data store
    public Contact addContact(Contact contact);
    
    //remove the contact with the given id from the data store
    public void removeContact(long contactId);
    
    //update the given contact on the data store
    public void updateContact(Contact contact);
    
    //retrive all contacts from the data store
    public List<Contact> getAllContacts();
    
    //retrive the contact with the given id from the data store
    public Contact getContactById(long contactId);
    
    //search for the contact with the given search criteria values
    public List<Contact> searchContacts(Map<SearchTerm, String> criteria);
}
