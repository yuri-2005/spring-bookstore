package com.yuri.cadastro_livros.controllers;

import java.net.URI;
import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.yuri.cadastro_livros.entities.Livro;
import com.yuri.cadastro_livros.services.LivroService;

@RestController
@RequestMapping("/livros")
public class LivroController {

	private final LivroService service;

	public LivroController(LivroService service) {
		this.service = service;
	}

	@GetMapping
	public ResponseEntity<List<Livro>> findAll() {
		List<Livro> list = service.findAll();
		return ResponseEntity.ok(list);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<Livro> findById(@PathVariable Long id) {
		Livro obj = service.findById(id);
		return ResponseEntity.ok(obj);
	}
	
	@GetMapping("/searchByTitulo")
	public ResponseEntity<List<Livro>> findByTitulo(@RequestParam String titulo){
		List<Livro> list = service.findByTitulo(titulo);
		return ResponseEntity.ok(list);
		
	}
	
	@GetMapping("/searchByAutor")
	public ResponseEntity<List<Livro>> findByAutor(@RequestParam String autor){
		List<Livro> list = service.findByAutor(autor);
		return ResponseEntity.ok(list);
		
	}
	
	@PostMapping
	public ResponseEntity<Livro> insert(@RequestBody Livro obj){
		obj = service.insert(obj);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(obj.getId()).toUri();
		return ResponseEntity.created(uri).body(obj);
	}
	
	@PutMapping(value = "/{id}")
	public ResponseEntity<Livro> update(@PathVariable Long id, @RequestBody Livro obj){
		obj = service.update(id, obj);
		return ResponseEntity.ok().body(obj);
	}
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Livro> delete(@PathVariable Long id){
		service.remove(id);
		return ResponseEntity.noContent().build();
		
	}
}
