package com.kshrd.app.ka.services;

import java.util.List;

import com.kshrd.app.ka.entities.Book;

public interface BookService {
	
	public List<Book> list();
	public boolean addBook(Book b);
	public boolean deleteBook(int id);
	public boolean updateBook(Book b);

}
