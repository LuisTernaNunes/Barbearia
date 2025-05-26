package com.sisst.barbearia.controller;

import com.sisst.barbearia.domain.carrinhoCompras.CarrinhoRepository;
import com.sisst.barbearia.domain.carrinhoCompras.DadosAddProduto;
import com.sisst.barbearia.domain.itemProduto.ItemProduto;
import com.sisst.barbearia.domain.produto.ProdutoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/carrinho")
public class CarrinhoController {
    @Autowired
    CarrinhoRepository repository;

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    CarrinhoRepository carrinhoRepository;

    @PostMapping
    public ResponseEntity addProdutoCarrinho(@RequestBody @Valid DadosAddProduto dados){
        var produto = produtoRepository.findById(dados.idProduto()).get();
        var carrinho = carrinhoRepository.findById(dados.idCarrinho()).get();
        ItemProduto itens = new ItemProduto(produto,carrinho, dados.quantidade());
        carrinho.addProdutos(itens);
        carrinhoRepository.save(carrinho);
        return ResponseEntity.ok("Item adicionado");
    }
}
