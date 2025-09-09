package com.example.api.controller;

import com.example.api.entity.Post;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/hello")
public class HelloController {

    List<Post> posts = new ArrayList<>();

    @GetMapping("")
    public String hello(){
        return "Olá Mundo!";
    }

    @GetMapping("/pagina")
    public String getPaginaInicial(){
        return "<html><h1>Pagina Inicial</h1></html>";
    }

    @PostMapping
    public String criarPost(@RequestBody Post post){
        posts.add(post);
        return "Deu Certo!";
    }

    @GetMapping("/posts")
    public List<Post> getPosts(){
        return posts;
    }



}
