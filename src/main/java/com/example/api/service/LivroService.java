package com.example.api.service;

import com.example.api.entity.Livro;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LivroService {

    private EnviarEmailService enviarEmailService;

    public LivroService(EnviarEmailService enviarEmailService){
        this.enviarEmailService = enviarEmailService;
    }

    private List<Livro> livros = new ArrayList<>();

    public Livro criarLivro(Livro livro){
        livros.add(livro);
        enviarEmailService.enviarEmail(livro);
        return livro;
    }

    public List<Livro> buscarLivros(){
        return livros;
    }

}
