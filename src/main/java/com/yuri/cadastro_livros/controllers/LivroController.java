package com.yuri.cadastro_livros.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}
