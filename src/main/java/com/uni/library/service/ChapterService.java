package com.uni.library.service;

import com.uni.library.model.Chapter;
import com.uni.library.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository) {
        this.chapterRepository = chapterRepository;
    }

    public List<Chapter> getAllChapters() {
        return (List<Chapter>) chapterRepository.findAll();
    }

    public Chapter getChapterById(Long id) {
        if (chapterRepository.findById(id).isPresent())
            return chapterRepository.findById(id).get();
        return null;
    }

    public void deleteChapterById(Long id) {
        chapterRepository.deleteById(id);
    }

    public void insertChapter(Chapter chapter) {
        chapterRepository.save(chapter);
    }

    public void updateChapterById(Long id, Chapter updateChapter) {
        if (chapterRepository.findById(id).isPresent()){
            updateChapter.setId(id);
            chapterRepository.save(updateChapter);
        }
    }
}
