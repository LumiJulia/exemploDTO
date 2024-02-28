package com.prjexemploDTO.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.prjexemploDTO.entities.Livro;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
