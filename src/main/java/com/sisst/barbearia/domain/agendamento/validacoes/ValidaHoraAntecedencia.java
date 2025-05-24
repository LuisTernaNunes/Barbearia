package com.sisst.barbearia.domain.agendamento.validacoes;

import com.sisst.barbearia.domain.agendamento.DadosAgendamento;
import com.sisst.barbearia.exception.ValidacaoException;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.time.LocalDateTime;
@Component
public class ValidaHoraAntecedencia implements ValidadorAgendamento {

    @Override
    public void valida(DadosAgendamento dados) {
        var horario = dados.horario();
        var horaAtual = LocalDateTime.now();

        boolean mesmoDia = horario.toLocalDate().isEqual(horaAtual.toLocalDate());
        boolean antecedencia = Duration.between(horaAtual,horario).toHours() < 2;
        if(mesmoDia) {
            if (antecedencia) {
                return;
            } else {
                throw new ValidacaoException("Agendamento somente com 2 horas de antecedencia");
            }
        }else {
            return;
        }
    }
}
