package com.sisst.barbearia.domain.carrinhoCompras;

import com.sisst.barbearia.domain.agendamento.Agendamento;
import com.sisst.barbearia.domain.produto.Produto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "carrinho")
public class CarrinhoCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Produto produto;
    @OneToOne(optional = false)
    @JoinColumn(name = "idAgendamento", nullable = false, unique = true)
    private Agendamento agendamento;
    private Double valorTotal;
    private LocalDateTime abertura;
}
