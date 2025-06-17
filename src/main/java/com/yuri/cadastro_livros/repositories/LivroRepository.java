package com.yuri.cadastro_livros.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuri.cadastro_livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {
	
	List<Livro> findByTituloContainingIgnoreCase(String titulo);
	List<Livro> findByAutorContainingIgnoreCase(String autor);
}
