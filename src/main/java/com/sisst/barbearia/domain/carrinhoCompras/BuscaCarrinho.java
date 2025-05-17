package com.sisst.barbearia.domain.carrinhoCompras;

import org.springframework.stereotype.Service;

@Service
public class BuscaCarrinho {
    CarrinhoRepository repository;
    public CarrinhoCompras buscaCarriho(Long id){
        return repository.findById(id).get();
    }
}
