package com.sisst.barbearia.domain.agendamento.validacoes;

import com.sisst.barbearia.domain.agendamento.DadosAgendamento;
import com.sisst.barbearia.domain.agendamento.service.AgendamentoRepository;
import com.sisst.barbearia.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidaHoraMarcada implements ValidadorAgendamento{
    @Autowired
    AgendamentoRepository repository;
    @Override
    public void valida(DadosAgendamento dados) {
        var horarioInicio = dados.horario();
        if(!repository.consultaHorario(dados.idBarbeiro(),horarioInicio)){
            return;
        }else {
            throw new ValidacaoException("Horario ja Marcado");
        }
    }
}
