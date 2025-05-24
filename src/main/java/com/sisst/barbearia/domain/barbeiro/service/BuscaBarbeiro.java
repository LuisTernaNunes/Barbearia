package com.sisst.barbearia.domain.barbeiro.service;

import com.sisst.barbearia.domain.barbeiro.Barbeiro;
import com.sisst.barbearia.domain.barbeiro.RepositoryBarbeiro;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BuscaBarbeiro {
    @Autowired
    RepositoryBarbeiro repositoryBarbeiro;
    public Barbeiro buscaBarbeiro(Long idbarbeiro){
        return repositoryBarbeiro.getReferenceById(idbarbeiro);
    }
}
