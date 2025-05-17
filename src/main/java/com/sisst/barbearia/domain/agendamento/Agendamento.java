package com.sisst.barbearia.domain.agendamento;

import com.sisst.barbearia.domain.carrinhoCompras.CarrinhoCompras;
import com.sisst.barbearia.domain.cliente.Cliente;
import com.sisst.barbearia.domain.barbeiro.Barbeiro;
import com.sisst.barbearia.domain.produto.Produto;
import jakarta.persistence.*;
import jakarta.validation.Valid;
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
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;
    private LocalDateTime horario;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_barbeiro")
    private Barbeiro barbeiro;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;
    private Boolean ativo;
    @OneToOne(mappedBy = "agendamento", cascade = CascadeType.ALL, orphanRemoval = true)
    private CarrinhoCompras carrinhoCompras;

    public Agendamento(@Valid DadosAgendamento dados, Produto produto, Barbeiro barbeiro,Cliente cliente) {
        this.ativo = true;
        this.cliente = cliente;
        this.barbeiro = barbeiro;
        this.produto = produto;
        this.horario = dados.horario();
    }
}
