package com.sisst.barbearia.domain.agendamento.service;

import com.sisst.barbearia.domain.agendamento.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
}
