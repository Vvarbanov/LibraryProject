package com.uni.library.repository;

import com.uni.library.model.Newspaper;
import org.springframework.data.repository.CrudRepository;

public interface NewspaperRepository extends CrudRepository<Newspaper,Long> {
}
