package com.bookstore.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="order_details")
@NoArgsConstructor
@Setter
@Getter
@AllArgsConstructor
public class OrderDetails {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    @Column(name="book_id")
    int bookId;
    @Column(name="username")
    String username;


}
