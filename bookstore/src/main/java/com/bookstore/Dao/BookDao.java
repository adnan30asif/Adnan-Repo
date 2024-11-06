package com.bookstore.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookstore.Entity.Book;

public interface BookDao extends JpaRepository<Book, Long>{

}
