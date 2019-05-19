package com.springlearning.spring5webapp.bootstrap;

import com.springlearning.spring5webapp.com.springlearning.spring5webapp.model.Author;
import com.springlearning.spring5webapp.com.springlearning.spring5webapp.model.Book;
import com.springlearning.spring5webapp.repositories.AuthorRepository;
import com.springlearning.spring5webapp.repositories.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Component
public class DemoBootStrap implements ApplicationListener<ContextRefreshedEvent> {

    private AuthorRepository authRepository;
    private BookRepository bookRepository;

    @Autowired
    public DemoBootStrap(AuthorRepository authorRepository, BookRepository bookRepository){
        this.authRepository = authorRepository;
        this.bookRepository = bookRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){
        Author anas = new Author("Anas","PM");
        Book book1 = new Book("My First Book - By Anas","1234","Publisher1");
        anas.getBooks().add(book1);
        book1.getAuthors().add(anas);

        authRepository.save(anas);
        bookRepository.save(book1);

        Author mehjabeen = new Author("Mehjabeen","Anas");
        Book book2 = new Book("My First Book - By Mehjabeen","6789","Publisher2");
        mehjabeen.getBooks().add(book2);
        book2.getAuthors().add(mehjabeen);

        authRepository.save(mehjabeen);
        bookRepository.save(book2);
    }
}
