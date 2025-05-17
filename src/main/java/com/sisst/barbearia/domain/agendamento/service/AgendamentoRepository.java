package com.sisst.barbearia.domain.agendamento.service;

import com.sisst.barbearia.domain.agendamento.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
}
