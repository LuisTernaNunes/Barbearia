package com.sisst.barbearia.domain.agendamento.service;

import com.sisst.barbearia.domain.barbeiro.Barbeiro;
import com.sisst.barbearia.domain.barbeiro.RepositoryBarbeiro;
import com.sisst.barbearia.domain.produto.Produto;
import com.sisst.barbearia.domain.produto.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendamentoService {
    @Autowired
    ProdutoRepository repositoryProduto;
    @Autowired
    RepositoryBarbeiro repositoryBarbeiro;
    public Produto buscaProduto(Long idProduto){
         return repositoryProduto.getReferenceById(idProduto);
    }
    public Barbeiro buscaBarbeiro(Long idbarbeiro){
        return repositoryBarbeiro.getReferenceById(idbarbeiro);
    }
}
