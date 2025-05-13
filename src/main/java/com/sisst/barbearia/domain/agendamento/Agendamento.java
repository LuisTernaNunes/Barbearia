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
    private Cliente cliente;
    private LocalDateTime horario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_barbeiro")
    private Barbeiro barbeiro;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    private Boolean ativo;
    @OneToOne(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private CarrinhoCompras carrinhoCompras;
}
