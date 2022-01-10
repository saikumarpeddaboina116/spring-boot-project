package com.bookstore.bookstore.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BookDTO {

    private int id;
    private String title;
    @NotEmpty(message = "Price Should Be Entered")
    private double price;
    private int noOfCopies;

}
