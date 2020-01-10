package com.uni.library.service;

import com.uni.library.dto.NewspaperDTO;
import com.uni.library.model.Newspaper;
import com.uni.library.repository.NewspaperRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public Long insertNewspaper(NewspaperDTO newspaperDTO) {
        Long id = null;

        if (newspaperDTO != null){
            Newspaper newNewspaper = new Newspaper();

            newNewspaper.setName(newspaperDTO.getName());
            newNewspaper.setDate(newspaperDTO.getDate());

            id = newspaperRepository.save(newNewspaper).getId();
        }
        return id;
    }

    @Transactional
    public Long updateNewspaperById(Long id, NewspaperDTO updateNewspaper) {
        if (newspaperRepository.findById(id).isPresent() && updateNewspaper != null) {
            Newspaper newNewspaper = new Newspaper();

            newNewspaper.setId(id);
            newNewspaper.setName(updateNewspaper.getName());
            newNewspaper.setDate(updateNewspaper.getDate());

            return newspaperRepository.save(newNewspaper).getId();
        }
        return null;
    }
}
