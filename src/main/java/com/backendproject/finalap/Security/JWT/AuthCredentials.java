package com.backendproject.finalap.Security.JWT;

import lombok.Data;

@Data
public class AuthCredentials {
    private String user;
    private String password;
}
