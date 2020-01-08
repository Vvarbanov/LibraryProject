package com.uni.library.repository;

import com.uni.library.model.Catalogue;
import org.springframework.data.repository.CrudRepository;

public interface CatalogueRepository extends CrudRepository<Catalogue, Long> {
}
