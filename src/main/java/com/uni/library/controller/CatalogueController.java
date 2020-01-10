package com.uni.library.controller;

import com.uni.library.dto.CatalogueDTO;
import com.uni.library.model.Catalogue;
import com.uni.library.service.CatalogueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/catalogues")
@RestController
public class CatalogueController {

    private final CatalogueService catalogueService;

    @Autowired
    public CatalogueController(CatalogueService catalogueService) {
        this.catalogueService = catalogueService;
    }

    @GetMapping
    public List<Catalogue> getAllCatalogues() {
        return catalogueService.getAllCatlogues();
    }
    @GetMapping("/{id}")

    public Catalogue getCatalogueById(@PathVariable Long id) {
        return catalogueService.getCatalogueById(id);
    }

    @PostMapping
    public ResponseEntity insertCatalogue(@NonNull @Valid @RequestBody CatalogueDTO catalogueDTO) {
        return ResponseEntity.ok(catalogueService.insertCatalogue(catalogueDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateCatalogueById(@PathVariable Long id, @Valid @NonNull @RequestBody CatalogueDTO updateCatalogue) {
        return ResponseEntity.ok(catalogueService.updateCatalogueById(id, updateCatalogue));
    }

    @DeleteMapping("/{id}")
    public void deleteCatalogueById(@PathVariable Long id) {
        catalogueService.deleteCatalogueById(id);
    }
}
