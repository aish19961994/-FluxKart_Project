package com.example.customeridentification.Controller;

import com.example.customeridentification.DTO.IdentifyRequest;
import com.example.customeridentification.DTO.IdentifyResponse;
import com.example.customeridentification.Entity.Contact;
import com.example.customeridentification.Service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/identify")
public class ContactController {

    @Autowired
    private ContactService contactService;

    @PostMapping
    public ResponseEntity<IdentifyResponse> identifyContact(@RequestBody IdentifyRequest request) {
        Contact contact = contactService.identifyContact(request.getEmail(), request.getPhoneNumber());

        IdentifyResponse response = new IdentifyResponse();
        response.setContact(contact);
        return new ResponseEntity<>(response, HttpStatus.OK);
    }
}
