package com.bookstore.bookstore.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="users")
@Getter
@Setter
@NoArgsConstructor
public class User {

    @Column(name = "username")
    @Id
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="enabled")
    private int enabled;
    @Column(name="email")
    private  String email;
    @Column(name="phone_number")
    private Long phoneNumber;

//    @OneToMany(fetch = FetchType.LAZY,mappedBy = "Users",cascade ={CascadeType.PERSIST,
//            CascadeType.MERGE,
//            CascadeType.DETACH,
//            CascadeType.REFRESH})
 //  private List<Order> orders;
//    public void add(Order temporaryOrder)
  //  {      if(temporaryOrder==null)
//        {
//            orders=new ArrayList<Order>();
//        }
//        orders.add(temporaryOrder);
//        temporaryOrder.setUser(this);
//    }
//    @ManyToMany(fetch = FetchType.LAZY,
//            cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
//    @JoinTable(
//            name = "order",
//            joinColumns = @JoinColumn(name = "username"),
//            inverseJoinColumns = @JoinColumn(name = "book_id")
//    )
//   private List<Book> books;
//    public void addBook(Book temporaryOrder)
//      {      if(temporaryOrder==null)
//        {
//            books= new ArrayList<>();
//
//        }
//          System.out.println("********************************** In add Book Order");
//        books.add(temporaryOrder);
//
//      }

}
