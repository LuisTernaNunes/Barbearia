package com.sisst.barbearia.domain.agendamento;

import com.sisst.barbearia.domain.carrinhoCompras.CarrinhoCompras;
import com.sisst.barbearia.domain.cliente.Cliente;
import com.sisst.barbearia.domain.barbeiro.Barbeiro;
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
public class Agendamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;
    @OneToOne
    private Cliente nomeCliente;
    private LocalDateTime horario;
    @ManyToOne
    private Barbeiro barbeiro;
    @ManyToOne(optional = false)
    @JoinColumn(name = "produto_id")
    private Produto produto;
    private Boolean ativo;
    @OneToOne(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private CarrinhoCompras carrinhoCompras;
}
