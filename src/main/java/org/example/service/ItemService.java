package org.example.service;

import org.example.entity.Item;
import org.example.repository.ItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ItemService {

    private ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository){
        this.itemRepository = itemRepository;
    }

    public List<Item> findAll(){
        return (List<Item>) itemRepository.findAll();
    }

    public Item findById(Integer id){
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            return item.get();
        }
        return null;
    }

    public Item save(Item item){
        return itemRepository.save(item);
    }

    public Item update(Integer id, Item item){
        Optional<Item> itemDb = itemRepository.findById(id);
        if(itemDb.isPresent()){
            item.setIdItem(id); // garante que atualiza o registro certo
            return itemRepository.save(item);
        }
        return null;
    }

    public void deleteItem(Integer id){
        Optional<Item> item = itemRepository.findById(id);
        if(item.isPresent()){
            itemRepository.deleteById(id);
        }
    }
}
