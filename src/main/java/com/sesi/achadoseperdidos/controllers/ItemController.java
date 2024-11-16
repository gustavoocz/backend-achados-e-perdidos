package com.sesi.achadoseperdidos.controllers;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sesi.achadoseperdidos.models.Item;
import com.sesi.achadoseperdidos.services.ItemService;


@RestController
@RequestMapping("/item")
public class ItemController {
	
	@Autowired
	private ItemService service;
	
	@GetMapping(produces= MediaType.APPLICATION_JSON_VALUE)
	public List <Item> todosItens(){
		return service.todosItens();
	}
	
	@GetMapping(value= "/{id}",
			produces= MediaType.APPLICATION_JSON_VALUE)
	public Item itemPorId(@PathVariable(value= "id")Long id){
		return service.itemPorId(id);
	}
	
	@PostMapping(consumes= MediaType.APPLICATION_JSON_VALUE,
			produces= MediaType.APPLICATION_JSON_VALUE)
	public Item cadastro(@RequestBody Item item){
		return service.cadastro(item);				
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<?> deletar(@PathVariable(value = "id")Long id){
		service.deletar(id);
		return ResponseEntity.noContent().build();				
	}
}
