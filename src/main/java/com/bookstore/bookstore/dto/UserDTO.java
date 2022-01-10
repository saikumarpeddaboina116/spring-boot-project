package com.bookstore.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class UserDTO {
    private String username;

    private String password;

    private int enabled;

    private String email;

    private Long phoneNumber;
}
