package com.uni.library.service;

import com.uni.library.model.Item;
import com.uni.library.repository.ItemRepository;
import org.aspectj.asm.IRelationshipMap;
import org.hibernate.sql.ordering.antlr.OrderByTemplateTokenTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.w3c.dom.ls.LSException;

import java.util.List;

@Service
public class ItemService {

    private final ItemRepository itemRepository;

    @Autowired
    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
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

    public void insertById(Item item) {
        itemRepository.save(item);
    }

    public void updateItemByID(Long id, Item updateItem) {
        if (itemRepository.findById(id).isPresent()){
            updateItem.setId(id);
            itemRepository.save(updateItem);
        }
    }
}
