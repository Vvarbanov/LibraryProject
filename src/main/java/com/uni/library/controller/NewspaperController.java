package com.uni.library.controller;

import com.uni.library.dto.NewspaperDTO;
import com.uni.library.model.Newspaper;
import com.uni.library.service.NewspaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/newspapers")
@RestController
public class NewspaperController {

    private final NewspaperService newspaperService;

    @Autowired
    public NewspaperController(NewspaperService newspaperService) {
        this.newspaperService = newspaperService;
    }

    @GetMapping
    public List<Newspaper> getAllNewspapers() {
        return newspaperService.getAllNewspapers();
    }

    @GetMapping("/{id}")
    public Newspaper getNewspaperById(@PathVariable Long id) {
        return newspaperService.getNewspaperById(id);
    }

    @PostMapping
    public ResponseEntity insertNewspaper(@NonNull @Valid @RequestBody NewspaperDTO newspaperDTO) {
        return ResponseEntity.ok(newspaperService.insertNewspaper(newspaperDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateNewspaperById(@PathVariable Long id, @Valid @NonNull @RequestBody NewspaperDTO updateNewspaper) {
        return ResponseEntity.ok(newspaperService.updateNewspaperById(id, updateNewspaper));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteNewspaperById(@PathVariable Long id) {
        return ResponseEntity.ok(newspaperService.deleteNewspaperById(id));
    }
}
