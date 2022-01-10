package com.bookstore.bookstore.convertor;

import com.bookstore.bookstore.dto.BookDTO;
import com.bookstore.bookstore.entity.Book;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookConvertor {
    @Autowired
    private ModelMapper modelMapper;

    public BookDTO entityToDto(Book book) {
        return modelMapper.map(book, BookDTO.class);
    }

    public Book dtoToEntity(BookDTO book) {
        return modelMapper.map(book, Book.class);
    }

}
