package com.vivek.BookLibraryCrudApplication.repository;

import com.vivek.BookLibraryCrudApplication.entity.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface BookRepository extends JpaRepository<Book,Integer> {

    public List<Book> findByAuthor(String author);


}
