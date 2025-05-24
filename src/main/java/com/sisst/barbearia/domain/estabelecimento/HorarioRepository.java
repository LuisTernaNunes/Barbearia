package com.sisst.barbearia.domain.estabelecimento;

import org.springframework.data.jpa.repository.JpaRepository;

import java.time.DayOfWeek;

public interface HorarioRepository extends JpaRepository<HorarioFuncionamento,Long> {
    HorarioFuncionamento findAllByDia(DayOfWeek hoje);
}
