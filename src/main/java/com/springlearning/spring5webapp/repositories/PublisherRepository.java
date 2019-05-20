package com.springlearning.spring5webapp.repositories;

import com.springlearning.spring5webapp.com.springlearning.spring5webapp.model.Publisher;
import org.springframework.data.repository.CrudRepository;

public interface PublisherRepository extends CrudRepository<Publisher,Long> {
}
