package com.bookstore.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bookstore.Entity.Book;
import com.bookstore.Service.BookService;
import com.bookstore.Service.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/admin")
public class AdminController {
	
	@Autowired
	private BookService bookService;
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/books")
	public Book createBook(@Valid @RequestBody Book book) {
		return bookService.saveBook(book);
	}
	
	@PutMapping("/books/{bookId}")
	public Book updateBook(@PathVariable Long bookId, @Valid @RequestBody Book book) {
		return bookService.updateBook(bookId, book);
	}
	
	@DeleteMapping("/books/{bookId}")
	public void deleteBook(@PathVariable Long bookId) {
		bookService.deleteBook(bookId);
	}
	
	@DeleteMapping("/books/{userId}")
	public void deleteUser(@PathVariable Long userId) {
		userService.deleteUser(userId);
	}

}
