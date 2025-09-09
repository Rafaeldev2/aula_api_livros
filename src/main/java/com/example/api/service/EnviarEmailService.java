package com.example.api.service;

import com.example.api.entity.EmailLivroDTO;
import com.example.api.entity.Livro;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class EnviarEmailService {

    public boolean enviarEmail(Livro livro){
        try{
            if(livro.getTitulo().isEmpty())
                return false;

            RestTemplate restTemplate = new RestTemplate();

            EmailLivroDTO emailLivroDTO = new EmailLivroDTO();
            emailLivroDTO.setLivro(livro.getTitulo());
            emailLivroDTO.setMensagem("um novo livro foi cadastrado!");

            String url ="https://webhook.site/d371b365-788b-4684-8f38-4223e9d4f739";
            restTemplate.postForEntity(url, emailLivroDTO, EmailLivroDTO.class);
            return true;
        }catch (Exception ex){
            System.out.println("Erro:");
            return false;
        }
    }

}
