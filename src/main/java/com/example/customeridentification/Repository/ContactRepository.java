package com.example.customeridentification.Repository;


import com.example.customeridentification.Entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<Contact, Long> {

    Contact findByEmailOrPhoneNumber(String email, String phoneNumber);
}
