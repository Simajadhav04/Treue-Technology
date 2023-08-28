package org.onlinebookstore.com.onlinebookstore.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;
@Data
@Builder
public class AddressDTO {
        private long userId;
        private String addressLine1;
        private String city;
        private String state;
        private String country;
        private int pinCode;
        private int mobileNumber;

    }

