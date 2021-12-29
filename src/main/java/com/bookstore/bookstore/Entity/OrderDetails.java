package com.bookstore.bookstore.Entity;

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
//    @ManyToOne(cascade = {CascadeType.PERSIST,
//            CascadeType.MERGE,
//            CascadeType.DETACH,
//            CascadeType.REFRESH})
//    @JoinColumn(name = "")
//    private User user;


}
