package com.bookstore.bookstore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookstoreApplication {
	static String[] args2;

	public static void main(String[] args) {
		args2=args;
		SpringApplication.run(BookstoreApplication.class, args);
	}

}
