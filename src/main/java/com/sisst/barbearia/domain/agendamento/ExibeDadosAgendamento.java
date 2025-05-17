package com.sisst.barbearia.domain.agendamento;

import com.sisst.barbearia.domain.barbeiro.Barbeiro;

import java.time.LocalDateTime;

public record ExibeDadosAgendamento(Long idAgendamento, String nomeBarbeiro, String nomeCliente, LocalDateTime horario) {
    public ExibeDadosAgendamento(Agendamento agendamento){
        this(agendamento.getIdAgendamento(),agendamento.getBarbeiro().getNomeBarbeiro(),agendamento.getCliente().getNome(),agendamento.getHorario());
    }
}
