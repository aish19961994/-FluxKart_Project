package com.example.customeridentification.DTO;

import lombok.Data;

@Data
public class IdentifyRequest {
    private String email;
    private String phoneNumber;
}
