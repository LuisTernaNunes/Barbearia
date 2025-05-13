package com.sisst.barbearia.domain.produto;

public record DadosProduto(String nomeProduto, Double valorVenda) {
    public DadosProduto(Produto produto){
        this(produto.getNomeProduto(), produto.getValorVenda());
    }
}
