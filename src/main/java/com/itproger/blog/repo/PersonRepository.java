package com.itproger.blog.repo;

import com.itproger.blog.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonRepository extends CrudRepository<Person, Long> {
}
