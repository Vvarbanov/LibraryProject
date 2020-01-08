package com.uni.library.service;

import com.uni.library.model.Newspaper;
import com.uni.library.repository.NewspaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewspaperService {

    private final NewspaperRepository newspaperRepository;

    @Autowired
    public NewspaperService(NewspaperRepository newspaperRepository) {
        this.newspaperRepository = newspaperRepository;
    }

    public List<Newspaper> getAllNewspapers() {
        return (List<Newspaper>) newspaperRepository.findAll();
    }

    public Newspaper getNewspaperById(Long id) {
        if (newspaperRepository.findById(id).isPresent())
            return newspaperRepository.findById(id).get();
        return null;
    }

    public void deleteNewspaperById(Long id) {
        newspaperRepository.deleteById(id);
    }

    public void insertNewspaper(Newspaper newspaper) {
        newspaperRepository.save(newspaper);
    }

    public void updateNewspaperById(Long id, Newspaper updateNewspaper) {
        if (newspaperRepository.findById(id).isPresent()) {
            updateNewspaper.setId(id);
            newspaperRepository.save(updateNewspaper);
        }
    }
}
