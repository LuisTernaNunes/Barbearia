package com.sisst.barbearia.domain.produto.service;

import com.sisst.barbearia.domain.produto.Produto;
import com.sisst.barbearia.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaProduto {
    @Autowired
    ProdutoRepository repositoryProduto;

    public Produto buscaProduto(Long idProduto){
        return repositoryProduto.getReferenceById(idProduto);
    }
}
