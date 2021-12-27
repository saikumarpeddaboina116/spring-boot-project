package com.bookstore.bookstore.DAO;
import com.bookstore.bookstore.Entity.Book;
import com.bookstore.bookstore.Entity.OrderDetails;
import com.bookstore.bookstore.inter.BookDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.websocket.Session;
import java.util.List;
@Repository
 class DAOImpl implements BookDAO {

    @Autowired
    private EntityManager entityManager;
    @Override
    public void saveBook(Book book) {
        System.out.println("/////////////////////////////////////////////////////////////");
        System.out.println(book.getId());
        Book theBook = entityManager.merge(book);
      //  book.setId(theBook.getId());
      }
    @Override
    public Book getBook(int id) {
        Book book=entityManager.find(Book.class,id);
        return book;
    }

    @Override
    public List<Book> getBooks() {
        List<Book> book=entityManager.createQuery("from Book ",Book.class).getResultList();
        return book;
    }

    @Override
    public void delete(int id) {
        Query theQuery=entityManager.createQuery("delete from Book where id= :id")
                .setParameter("id",id);
        theQuery.executeUpdate();
    }

    @Override
    public void saveOrder(OrderDetails order) {

           OrderDetails theOrder=entityManager.merge(order);
//           order.setBook_id(theOrder.getBook_id());
    }


}
