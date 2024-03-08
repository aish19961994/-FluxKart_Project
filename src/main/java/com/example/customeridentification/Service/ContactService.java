package com.example.customeridentification.Service;

import com.example.customeridentification.Entity.Contact;

public interface ContactService {
    Contact identifyContact(String email, String phoneNumber);
}
