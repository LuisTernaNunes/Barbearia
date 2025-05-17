package com.sisst.barbearia.domain.cliente;

import com.sisst.barbearia.domain.agendamento.DadosAgendamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ClienteService {
    @Autowired
    ClienteRepository repository;
    public Cliente existeCliente(DadosAgendamento dados){
        var optionalCliente = repository.findByTelefone(dados.cliente().telefone());
        if(optionalCliente.isPresent()){
            return optionalCliente.get();
        }else {
            Cliente cliente = new Cliente(dados);
            repository.save(cliente);
            return cliente;
        }
    }
}
