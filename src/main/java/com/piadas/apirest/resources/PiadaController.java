package com.piadas.apirest.resources;

import com.piadas.apirest.models.Piada;
import com.piadas.apirest.services.PiadaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class PiadaController {

    @Autowired
    PiadaService piadaService;

    @GetMapping ("/piada")
    public String piadaAleatoria(){


        Piada piada = piadaService.buscarPiada();
        return piada.getValue();

    }

    @GetMapping("/jokes/random")
    public String buscarCategoria(@RequestParam("category") String categoria){
    log.info("Buscando categoria da piada");
    Piada piada = piadaService.buscarCategoria(categoria);

        return piada.getValue();
    }

    @GetMapping("/jokes/palavras")
    public String buscarPalavras(@RequestParam("query") String palavra){
        log.info("Buscando palavra");
        Piada piada = piadaService.buscarCategoria(palavra);

        return piada.getValue();
    }

    @GetMapping("/jokes/categories")
    public String[] categoria(){

        String[] array = piadaService.categorias();
        return array;
    }


}
