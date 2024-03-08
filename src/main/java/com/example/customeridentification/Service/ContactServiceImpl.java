package com.example.customeridentification.Service;

import com.example.customeridentification.Entity.Contact;
import com.example.customeridentification.Enum.LinkPrecedence;
import com.example.customeridentification.Repository.ContactRepository;
import com.example.customeridentification.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;

@Service
public class ContactServiceImpl implements ContactService {

    @Autowired
    private ContactRepository contactRepository;

    @Override
    public Contact identifyContact(String email, String phoneNumber) {
        Contact existingContact = contactRepository.findByEmailOrPhoneNumber(email, phoneNumber);

        if (existingContact == null) {
            // If no existing contact found, create a new one
            Contact newContact = new Contact();
            newContact.setEmail(email);
            newContact.setPhoneNumber(phoneNumber);
            newContact.setLinkPrecedence(String.valueOf(LinkPrecedence.PRIMARY));
            newContact.setCreatedAt(LocalDateTime.now());
            newContact.setUpdatedAt(LocalDateTime.now());
            return contactRepository.save(newContact);
        } else {
            // If existing contact found, update it if necessary
            boolean updated = false;
            if (email != null && !email.equals(existingContact.getEmail())) {
                existingContact.setEmail(email);
                updated = true;
            }
            if (phoneNumber != null && !phoneNumber.equals(existingContact.getPhoneNumber())) {
                existingContact.setPhoneNumber(phoneNumber);
             //   existingContact.setlinkedId(existingContact.getlinkedId());
                updated = true;
            }
            if (updated) {
                existingContact.setUpdatedAt(LocalDateTime.now());
                 existingContact.setLinkPrecedence(String.valueOf(LinkPrecedence.SECONDARY));
                 existingContact.setLinkedId(existingContact.getId());
                return contactRepository.save(existingContact);
            } else {
                return existingContact;
            }
        }
    }
}
