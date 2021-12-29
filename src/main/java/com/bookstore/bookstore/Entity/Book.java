package com.bookstore.bookstore.Entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="book_name")
    private String title;
    @Column(name="book_price")
    private double price;
    @Column(name="book_count")
    private int noOfCopies;

//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinTable(
//            name = "order",
//            joinColumns = @JoinColumn(name = "book_id"),
//            inverseJoinColumns = @JoinColumn(name = "username")
//    )
//    private List<User> users;
//public void addUser(User user)
//{
//    if(users==null)
//   users=new ArrayList<>();
//    users.add(user);
//}
}
