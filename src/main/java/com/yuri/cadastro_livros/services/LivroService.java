package com.yuri.cadastro_livros.services;

import java.util.List;

import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.yuri.cadastro_livros.entities.Livro;
import com.yuri.cadastro_livros.repositories.LivroRepository;
import com.yuri.cadastro_livros.services.exceptions.ResourceNotFoundException;

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
	
	public Livro insert(Livro obj) {
		return repository.save(obj);
	}
	
	public Livro update(Long id, Livro obj) {
		Livro entity = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(id));
		updateDate(entity, obj);
		return repository.save(entity);
		
	}
	
	private void updateDate(Livro entity, Livro obj) {
		entity.setTitulo(obj.getTitulo());
		entity.setAutor(obj.getAutor());
		entity.setAnoPublicacao(obj.getAnoPublicacao());
		entity.setIsbn(obj.getIsbn());
		
	}
	
	public void remove(Long id) {
		try {
			repository.deleteById(id);
		}catch(EmptyResultDataAccessException e) {
			 throw new ResourceNotFoundException(id);
		}
	}
	
	public List<Livro> findByTitulo(String titulo){
		return repository.findByTituloContainingIgnoreCase(titulo);
	}
	
	public List<Livro> findByAutor(String autor){
		return repository.findByAutorContainingIgnoreCase(autor);
	}
}
