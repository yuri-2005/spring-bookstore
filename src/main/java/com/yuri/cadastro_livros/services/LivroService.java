package com.yuri.cadastro_livros.services;

import java.util.List;


import org.springframework.stereotype.Service;

import com.yuri.cadastro_livros.entities.Livro;
import com.yuri.cadastro_livros.repositories.LivroRepository;

@Service
public class LivroService {
	
	private final LivroRepository repository;
	
	public LivroService(LivroRepository repository) {
		this.repository = repository;
	}
	
	public List<Livro> findAll(){
		return repository.findAll();
	}
	
	public Livro findById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Livro não encontrado"));
	}

}
