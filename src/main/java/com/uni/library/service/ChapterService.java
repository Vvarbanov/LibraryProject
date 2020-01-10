package com.uni.library.service;

import com.uni.library.dto.ChapterDTO;
import com.uni.library.model.Book;
import com.uni.library.model.Chapter;
import com.uni.library.repository.ChapterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ChapterService {

    private final ChapterRepository chapterRepository;
    private final BookService bookService;

    @Autowired
    public ChapterService(ChapterRepository chapterRepository, BookService bookService) {
        this.chapterRepository = chapterRepository;
        this.bookService = bookService;
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

    @Transactional
    public Long insertChapter(ChapterDTO chapterDTO) {
        Long id = null;
        if(chapterDTO != null){
            Chapter newChapter = new Chapter();

            newChapter.setTitle(chapterDTO.getTitle());
            newChapter.setContent(chapterDTO.getContent());
            newChapter.setBook(bookService.getBookByID(chapterDTO.getBook_id()));

            id = chapterRepository.save(newChapter).getId();
        }
        return id;
    }

    public List<Chapter> getAllChaptersByBookId(Long bookId){
        return chapterRepository.getAllChaptersByBookId(bookId);
    }

    @Transactional
    public Long updateChapterById(Long id, ChapterDTO updateChapter) {
        if (chapterRepository.findById(id).isPresent() && updateChapter != null){
            Chapter newChapter = new Chapter();

            newChapter.setId(id);
            newChapter.setTitle(updateChapter.getTitle());
            newChapter.setContent(updateChapter.getContent());
            newChapter.setBook(bookService.getBookByID(updateChapter.getBook_id()));

            return chapterRepository.save(newChapter).getId();
        }
        return null;
    }
}
