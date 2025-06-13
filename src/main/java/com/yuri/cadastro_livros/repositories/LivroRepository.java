package com.yuri.cadastro_livros.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.yuri.cadastro_livros.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
