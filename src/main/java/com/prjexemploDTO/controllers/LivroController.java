package com.prjexemploDTO.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import com.prjexemploDTO.DTO.LivroDTO;
import com.prjexemploDTO.entities.Livro;
import com.prjexemploDTO.services.LivroService;

public class LivroController {
	
	private final LivroService livroService;
	
	@Autowired
	public LivroController(LivroService livroService) {
		this.livroService = livroService;
	}
	
	@PostMapping
	public ResponseEntity<LivroDTO> criar(@RequestBody Livro livro){
		LivroDTO salvarLivro = livroService.salvar(livro);
		return ResponseEntity.status(HttpStatus.CREATED).body(salvarLivro);
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<LivroDTO> alteraClienteControl(@PathVariable Long id, @RequestBody Livro livro){
		LivroDTO alteraLivroDTO = livroService.atualizar(id, livro);
		if(alteraLivroDTO !=null) {
			return ResponseEntity.ok(alteraLivroDTO);
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Livro> apagaClienteControl (@PathVariable Long id){
		boolean apagar = livroService.deletar(id);
		if(apagar) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Livro> buscarLivrosPorId(@PathVariable Long id){
		Livro livro = livroService.buscarPorId(id);
		if(livro != null){
			return ResponseEntity.ok(livro);
			}
		else {
			return ResponseEntity.notFound().build();
		}
	}
	
	@GetMapping
	public ResponseEntity<List<Livro>> buscaTodosLivro(){
		List<Livro> Livro = livroService.buscarTodos();
		return ResponseEntity.ok(Livro);
	}
	
}

