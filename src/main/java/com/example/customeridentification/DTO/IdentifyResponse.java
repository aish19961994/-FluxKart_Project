package com.example.customeridentification.DTO;

import com.example.customeridentification.Entity.Contact;
import lombok.Data;

@Data
public class IdentifyResponse {
    private Contact contact;
}
