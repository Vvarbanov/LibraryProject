package com.uni.library.controller;

import com.uni.library.dto.ChapterDTO;
import com.uni.library.model.Chapter;
import com.uni.library.service.ChapterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/chapters")
@RestController
public class ChapterController {

    private final ChapterService chapterService;

    @Autowired
    public ChapterController(ChapterService chapterService) {
        this.chapterService = chapterService;
    }

    @GetMapping
    public List<Chapter> getAllChapters() {
        return chapterService.getAllChapters();
    }

    @GetMapping("/{id}")
    public Chapter getChapterById(@PathVariable Long id) {
        return chapterService.getChapterById(id);
    }

    @PostMapping
    public ResponseEntity insertChapter(@NonNull @Valid @RequestBody ChapterDTO chapterDTO) {
        return ResponseEntity.ok(chapterService.insertChapter(chapterDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateChapterById(@PathVariable Long id, @Valid @NonNull @RequestBody ChapterDTO updateChapter) {
        return ResponseEntity.ok(chapterService.updateChapterById(id, updateChapter));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteChapterById(@PathVariable Long id) {
        return ResponseEntity.ok(chapterService.deleteChapterById(id));
    }
}
