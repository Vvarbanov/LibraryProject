package com.uni.library.repository;

import com.uni.library.model.Chapter;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ChapterRepository extends CrudRepository<Chapter, Long> {
    List<Chapter> getAllChaptersByBookId(Long id);
}
