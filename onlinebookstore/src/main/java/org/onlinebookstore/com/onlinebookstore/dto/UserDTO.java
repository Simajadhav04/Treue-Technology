package org.onlinebookstore.com.onlinebookstore.dto;

import lombok.Builder;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
public class UserDTO {
    private long userId;
    private String userName;
    private String userType;
    private String mailId;


}
