package com.tuxhandbook.data;

import lombok.Data;

@Data
public class RegisterDTO {

    private String fullName;
    private String username;
    private String displayName;
    private String password;
    private String email;
    private String about;
}
