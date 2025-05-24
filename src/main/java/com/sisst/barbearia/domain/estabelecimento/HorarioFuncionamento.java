package com.sisst.barbearia.domain.estabelecimento;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "horario_funcionamento")
public class HorarioFuncionamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Enumerated(EnumType.STRING)
    private DayOfWeek dia;
    @Column(name = "abertura")
    private double horaAbertura;
    @Column(name = "fechamento")
    private double horaFechamento;
}
