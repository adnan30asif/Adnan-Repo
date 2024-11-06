package com.bookstore.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.Entity.Book;
import com.bookstore.Service.BookService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/books")
public class BookController {
	
	@Autowired
	private BookService bookService;
	
	@GetMapping
	public List<Book> getBooks(){
		return bookService.getBooks();
	}
	
	@GetMapping("/{bookId}")
	public Book getBookById(@PathVariable Long bookId) {
		return bookService.getBookById(bookId);
		
	}
	
	@PostMapping
	public Book createBook(@Valid @RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@PutMapping("/{bookId")
	public Book updateBook(@PathVariable Long bookId, @Valid @RequestBody Book book) {
		return bookService.updateBook(bookId, book);
	}
	
	@DeleteMapping("/{bookId}")
	public void deleteBook(@PathVariable Long bookId) {
		bookService.deleteBook(bookId);
	}

}
