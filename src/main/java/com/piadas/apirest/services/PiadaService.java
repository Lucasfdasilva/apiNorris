package com.piadas.apirest.services;

import com.piadas.apirest.models.Piada;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class PiadaService {


    public Piada buscarPiada(){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();


        return restTemplate.getForObject("https://api.chucknorris.io/jokes/random",Piada.class);
    }

    public Piada buscarCategoria(String categoria){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();


        return restTemplate.getForObject("https://api.chucknorris.io/jokes/random?category="+categoria,Piada.class);
    }

    public String[] categorias(){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();


        return restTemplate.getForObject("https://api.chucknorris.io/jokes/categories",String[].class);
    }

    public Piada buscarPalavra(String palavra){
        RestTemplate restTemplate = new RestTemplate();
        RestTemplateBuilder restTemplateBuilder = new RestTemplateBuilder();
        restTemplate = restTemplateBuilder.build();


        return restTemplate.getForObject("https://api.chucknorris.io/jokes/search?query="+palavra,Piada.class);
    }

}
