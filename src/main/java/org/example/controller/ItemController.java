package org.example.controller;

import org.apache.coyote.Response;
import org.example.entity.Item;
import org.example.service.ItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/itens")
public class ItemController {

    private ItemService itemService;

    public ItemController(ItemService itemService){
        this.itemService = itemService;
    }

    @GetMapping
    public List<Item> findAll(){
        return itemService.findAll();
    }

    @GetMapping("/{id}")
    public Item findById(@PathVariable Integer id){
        return itemService.findById(id);
    }

    @PostMapping
    public Item create(@RequestBody Item item){
        return itemService.save(item);
    }

    @PutMapping("/{id}")
    public Item update(@PathVariable Integer id, @RequestBody Item item){
        return itemService.update(id, item);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> excluirItem(@PathVariable Integer id){
        Item item = itemService.findById(id);
        if(item == null){
            return new ResponseEntity<>("Erro: Item não encontrado", HttpStatus.NOT_FOUND);
        }
        itemService.deleteItem(id);
        return new ResponseEntity<>(item, HttpStatus.OK);
    }
}
