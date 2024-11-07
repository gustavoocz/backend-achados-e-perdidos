package com.sesi.achadoseperdidos.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sesi.achadoseperdidos.models.Item;
import com.sesi.achadoseperdidos.repositories.ItemRepository;

@Service
public class ItemService {
		
	@Autowired
	ItemRepository repository;
	
	public List <Item> todosItens(){
		return repository.findAll();
	}
	
	public Item itemPorId(Long id) {
		return repository.findById(id)
				.orElseThrow(()-> new RuntimeException("Item não encontrado"));
	}
	
	public Item cadastro(Item item) {
		return repository.save(item);
	}
}
