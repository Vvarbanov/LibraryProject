package com.uni.library.controller;

import com.uni.library.model.Newspaper;
import com.uni.library.service.NewspaperService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
