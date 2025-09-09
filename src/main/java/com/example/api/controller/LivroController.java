package com.example.api.controller;

import com.example.api.entity.Livro;
import com.example.api.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/livro")
public class LivroController {

    private LivroService livroService;

    public LivroController(LivroService livroService){
        this.livroService = livroService;
    }

    @PostMapping("/add")
    public ResponseEntity<Livro> criarLivro(@RequestBody Livro livro){
        Livro livroSalvo = livroService.criarLivro(livro);
        return new ResponseEntity(livroSalvo, HttpStatusCode.valueOf(201));
    }

    @GetMapping("/listar")
    public ResponseEntity<List<Livro>> buscarLivros(){
        List<Livro> livros = livroService.buscarLivros();
        return new ResponseEntity(livros, HttpStatus.OK);
    }

    @DeleteMapping("/exclui/{codigo}")
    public ResponseEntity<String> excluirLivro(@PathVariable("codigo") Long codigo){
        return new ResponseEntity<>("Livro Excluído com Sucesso!", HttpStatus.OK);
    }

    @PutMapping("/alterar")
    public ResponseEntity<?> atualizarLivro(@RequestBody Livro livro){
        return new ResponseEntity<>(livro, HttpStatus.OK);
    }

}
