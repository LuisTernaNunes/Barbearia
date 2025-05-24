package com.sisst.barbearia.domain.agendamento.service;

import com.sisst.barbearia.domain.agendamento.Agendamento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface AgendamentoRepository extends JpaRepository<Agendamento,Long> {
    @Query("""
    SELECT CASE WHEN COUNT(a) > 0 THEN true ELSE false END
    FROM Agendamento a
    WHERE a.barbeiro.id = :idBarbeiro
      AND a.horario = :horarioDesejado
    """)
    Boolean consultaHorario(@Param("idBarbeiro") Long idBarbeiro, @Param("horarioDesejado")LocalDateTime horarioDesejado);
}
