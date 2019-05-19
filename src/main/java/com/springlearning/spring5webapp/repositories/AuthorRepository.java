package com.springlearning.spring5webapp.repositories;

import com.springlearning.spring5webapp.com.springlearning.spring5webapp.model.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author,Long> {
}
