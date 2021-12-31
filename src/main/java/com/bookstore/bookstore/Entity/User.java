package com.bookstore.bookstore.Entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @Column(name = "username")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="enabled")
    private int enabled;
    @Column(name="email")
    private  String email;
    @Column(name="phone_number")
    private Long phoneNumber;


}
