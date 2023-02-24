package com.itproger.blog.repo;

import com.itproger.blog.models.Post;
import org.springframework.data.repository.CrudRepository;

public interface PeopleRepository extends CrudRepository<Post, Long> {
}
