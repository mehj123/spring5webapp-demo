package com.springlearning.spring5webapp.bootstrap;

import com.springlearning.spring5webapp.com.springlearning.spring5webapp.model.Author;
import com.springlearning.spring5webapp.com.springlearning.spring5webapp.model.Book;
import com.springlearning.spring5webapp.com.springlearning.spring5webapp.model.Publisher;
import com.springlearning.spring5webapp.repositories.PublisherRepository;
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
    private PublisherRepository publisherRepository;

    @Autowired
    public DemoBootStrap(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository){
        this.authRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }


    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        Publisher publisher1 = new Publisher();
        publisher1.setName("Publisher1");
        publisher1.setAddress("Publisher 1 - Address");

        publisherRepository.save(publisher1);

        Author anas = new Author("Anas","PM");
        Book book1 = new Book("My First Book - By Anas","1234",publisher1);
        anas.getBooks().add(book1);
        book1.getAuthors().add(anas);

        authRepository.save(anas);
        bookRepository.save(book1);

        Publisher publisher2 = new Publisher();
        publisher2.setName("Publisher2");
        publisher2.setAddress("Publisher 2 - Address");

        publisherRepository.save(publisher2);

        Author mehjabeen = new Author("Mehjabeen","Anas");
        Book book2 = new Book("My First Book - By Mehjabeen","6789", publisher2);
        mehjabeen.getBooks().add(book2);
        book2.getAuthors().add(mehjabeen);

        authRepository.save(mehjabeen);
        bookRepository.save(book2);
    }
}
