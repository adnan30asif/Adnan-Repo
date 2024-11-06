package com.bookstore.Service;

import java.util.List;

import com.bookstore.Entity.Book;

public interface BookService {
	
	public List<Book> getBooks();
	
	public Book getBookById(Long bookId);
	
	public Book saveBook(Book book);
	
	public Book updateBook(Long bookId, Book bookDetails);
	
	public void deleteBook(Long bookId);

}
