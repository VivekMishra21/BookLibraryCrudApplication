package com.vivek.BookLibraryCrudApplication.service;


import com.vivek.BookLibraryCrudApplication.entity.Book;
import com.vivek.BookLibraryCrudApplication.repository.BookRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;



    public List<Book> getAllBook(){
        return bookRepository.findAll();
    }

    public Book getBookById(Integer id){
    Optional o= bookRepository.findById(id);
    if(o.isPresent()){
        Book book= (Book) o.get();
        return book;

    }else{
        return null;
    }
    }

    public List<Book>getBookByAuthor(String author){
        return bookRepository.findByAuthor(author);

    }
      public Book saveBook(Book book){
        return (Book) bookRepository.save(book);

      }


      public Book update(Integer id,Book book){
        Book b= (Book) bookRepository.findById(id).orElseThrow();
        b.setName(book.getName());
        b.setAuthor(book.getAuthor());
        return (Book) bookRepository.save(book);
      }

      public void deleteBook(Integer id){
        bookRepository.deleteById(id);
      }



}
