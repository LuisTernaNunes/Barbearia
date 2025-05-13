package com.sisst.barbearia.controller;

import com.sisst.barbearia.domain.produto.DadosCadProduto;
import com.sisst.barbearia.domain.produto.DadosProduto;
import com.sisst.barbearia.domain.produto.Produto;
import com.sisst.barbearia.domain.produto.ProdutoRepository;
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
@RequestMapping("/Produto")
public class produtoController {

    @Autowired
    ProdutoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity cadProdutos(@RequestBody @Valid DadosCadProduto dados, UriComponentsBuilder uriBuild){
        Produto produto = new Produto(dados);
        repository.save(produto);
        return ResponseEntity.ok(new DadosProduto(produto));
    }
}
