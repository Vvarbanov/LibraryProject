package com.uni.library.service;

import com.uni.library.dto.CatalogueDTO;
import com.uni.library.model.Catalogue;
import com.uni.library.repository.CatalogueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.CustomAutowireConfigurer;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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

    @Transactional
    public Long insertCatalogue(CatalogueDTO catalogueDTO) {
        Long id = null;

        if (catalogueDTO != null){
            Catalogue newCatalogue = new Catalogue();

            newCatalogue.setName(catalogueDTO.getName());
            newCatalogue.setDate(catalogueDTO.getDate());

            id = catalogueRepository.save(newCatalogue).getId();
        }
        return id;
    }

    @Transactional
    public Long updateCatalogueById(Long id, CatalogueDTO updateCatalogue) {
        if (catalogueRepository.findById(id).isPresent() && updateCatalogue != null){
            Catalogue newCatalogue = new Catalogue();

            newCatalogue.setId(id);
            newCatalogue.setName(updateCatalogue.getName());
            newCatalogue.setDate(updateCatalogue.getDate());

            return catalogueRepository.save(newCatalogue).getId();
        }
        return null;
    }
}
