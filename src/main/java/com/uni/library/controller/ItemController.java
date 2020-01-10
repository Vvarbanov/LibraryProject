package com.uni.library.controller;

import com.uni.library.dto.ItemDTO;
import com.uni.library.model.Item;
import com.uni.library.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("/items")
@RestController
public class ItemController {

    private final ItemService itemService;

    @Autowired
    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> getAllItems() {
        return itemService.getAllItems();
    }

    @GetMapping("/{id}")
    public Item getItemById(@PathVariable Long id) {
        return itemService.getItemByID(id);
    }

    @PostMapping
    public ResponseEntity insertItem(@NonNull @Valid @RequestBody ItemDTO itemDTO) {
        return ResponseEntity.ok(itemService.insertItem(itemDTO));
    }

    @PutMapping("/{id}")
    public ResponseEntity updateItemById(@PathVariable Long id, @Valid @NonNull @RequestBody ItemDTO updateItem) {
        return ResponseEntity.ok(itemService.updateItemByID(id, updateItem));
    }

    @DeleteMapping("/{id}")
    public void deleteItemById(@PathVariable Long id) {
        itemService.deleteItemById(id);
    }
}
