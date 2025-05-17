package com.sisst.barbearia.domain.cliente;


import com.sisst.barbearia.domain.agendamento.DadosAgendamento;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "cliente")
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCliente;
    @Column(name = "nome_cliente")
    private String nome;
    @Column(name = "telefone_cliente")
    private String telefone;

    public Cliente(DadosAgendamento dados) {
        this.nome = dados.cliente().nome();
        this.telefone =  dados.cliente().telefone();
    }
}
