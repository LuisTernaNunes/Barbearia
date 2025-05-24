package com.sisst.barbearia.domain.agendamento.validacoes;

import com.sisst.barbearia.domain.agendamento.DadosAgendamento;
import com.sisst.barbearia.domain.estabelecimento.HorarioFuncionamento;
import com.sisst.barbearia.domain.estabelecimento.HorarioRepository;
import com.sisst.barbearia.exception.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
@Component
public class ValidaHorarioAtendimento implements ValidadorAgendamento{

    @Autowired
    HorarioRepository repository;

    @Override
    public void valida(DadosAgendamento dados) {
        var horario = dados.horario();
        var funcionamentoDia = repository.findAllByDia(horario.getDayOfWeek());
        if(horario.getHour() >= funcionamentoDia.getHoraAbertura()
                && horario.getHour() < funcionamentoDia.getHoraFechamento() - 1){
            return;
        }else {
            throw new ValidacaoException("Fora do horario de funcionamento");
        }

    }
}
