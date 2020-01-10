package com.uni.library.service;

import com.uni.library.dto.ItemDTO;
import com.uni.library.model.Item;
import com.uni.library.repository.ItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;
    private final CatalogueService catalogueService;

    @Autowired
    public ItemService(ItemRepository itemRepository, CatalogueService catalogueService) {
        this.itemRepository = itemRepository;
        this.catalogueService = catalogueService;
    }

    public List<Item> getAllItems() {
        return (List<Item>) itemRepository.findAll();
    }

    public Item getItemByID(Long id) {
        if (itemRepository.findById(id).isPresent())
            return itemRepository.findById(id).get();
        return null;
    }

    public void deleteItemById(Long id) {
        itemRepository.deleteById(id);
    }

    @Transactional
    public Long insertItem(ItemDTO itemDTO) {
        Long id = null;

        if (itemDTO != null){
            Item newItem = new Item();

            newItem.setTitle(itemDTO.getTitle());
            newItem.setPrice(itemDTO.getPrice());
            newItem.setManufacturer(itemDTO.getManufacturer());
            newItem.setCatalogue(catalogueService.getCatalogueById(itemDTO.getCatalogue_id()));

            id = itemRepository.save(newItem).getId();
        }
        return id;
    }

    @Transactional
    public Long updateItemByID(Long id, ItemDTO updateItem) {
        if (itemRepository.findById(id).isPresent() && updateItem != null){
            Item newItem = new Item();

            newItem.setId(id);
            newItem.setTitle(updateItem.getTitle());
            newItem.setPrice(updateItem.getPrice());
            newItem.setManufacturer(updateItem.getManufacturer());
            newItem.setCatalogue(catalogueService.getCatalogueById(updateItem.getCatalogue_id()));

            return itemRepository.save(newItem).getId();
        }
        return null;
    }
}
