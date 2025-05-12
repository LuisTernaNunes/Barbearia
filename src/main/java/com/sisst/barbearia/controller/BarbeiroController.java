package com.sisst.barbearia.controller;

import com.sisst.barbearia.domain.barbeiro.Barbeiro;
import com.sisst.barbearia.domain.barbeiro.DadosBarbeiro;
import com.sisst.barbearia.domain.barbeiro.DadosCadBarbeiro;
import com.sisst.barbearia.domain.barbeiro.RepositoryBarbeiro;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.util.UriComponentsBuilder;

@Controller
@RequestMapping("/Barbeiro")
public class BarbeiroController {
    @Autowired
    RepositoryBarbeiro repository;
        @PostMapping
        @Transactional
        public ResponseEntity cadBarbeiro(@RequestBody @Valid DadosCadBarbeiro dadosBarbeiro, UriComponentsBuilder uriBuild){
            Barbeiro barbeiro = new Barbeiro(dadosBarbeiro);
            repository.save(barbeiro);
            return ResponseEntity.ok(new DadosBarbeiro(barbeiro));
        }
}
