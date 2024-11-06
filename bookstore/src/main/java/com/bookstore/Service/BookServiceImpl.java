package com.bookstore.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bookstore.Dao.BookDao;
import com.bookstore.Entity.Book;
import com.bookstore.Exception.ResourceNotFoundException;

@Service
public class BookServiceImpl implements BookService{
	
	@Autowired
	private BookDao bookDao;

	@Override
	public List<Book> getBooks() {
		// TODO Auto-generated method stub
		return bookDao.findAll();
	}

	@Override
	public Book getBookById(Long bookId) {
		// TODO Auto-generated method stub
		return bookDao.findById(bookId).orElseThrow(()-> new ResourceNotFoundException("Book not found with ID "+bookId));
	}

	@Override
	public Book saveBook(Book book) {
		// TODO Auto-generated method stub
		return bookDao.save(book);
	}

	@Override
	public Book updateBook(Long bookId, Book bookDetails) {
		// TODO Auto-generated method stub
		Book book = getBookById(bookId);
		book.setBookTitle(bookDetails.getBookTitle());
		book.setBookAuthor(bookDetails.getBookAuthor());
		book.setBookIsbn(bookDetails.getBookIsbn());
		book.setBookTitle(bookDetails.getBookTitle());
		return bookDao.save(book);
	}

	@Override
	public void deleteBook(Long bookId) {
		// TODO Auto-generated method stub
		bookDao.deleteById(bookId);
	}

}
