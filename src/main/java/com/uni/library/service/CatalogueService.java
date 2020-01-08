package com.uni.library.service;

import com.uni.library.model.Catalogue;
import com.uni.library.repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatalogueService {

    private final CatalogueRepository catalogueRepository;

    @Autowired
    public CatalogueService(CatalogueRepository catalogueRepository) {
        this.catalogueRepository = catalogueRepository;
    }

    public List<Catalogue> getAllCatlogues() {
        return (List<Catalogue>) catalogueRepository.findAll();
    }

    public Catalogue getCatalogueById(Long id) {
        if (catalogueRepository.findById(id).isPresent())
            return catalogueRepository.findById(id).get();
        return null;
    }

    public void deleteCatalogueById(Long id) {
        catalogueRepository.deleteById(id);
    }

    public void insertCatalogue(Catalogue catalogue) {
        catalogueRepository.save(catalogue);
    }

    public void updateCatalogueById(Long id, Catalogue updateCatalogue) {
        if (catalogueRepository.findById(id).isPresent()){
            updateCatalogue.setId(id);
            catalogueRepository.save(updateCatalogue);
        }
    }
}
