package com.sisst.barbearia.domain.produto;

import com.sisst.barbearia.domain.agendamento.Agendamento;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long produtoId;
    private String nomeProduto;
    private Double valorVenda;
    private Double valorCusto;
    private String enderecoImagem;
    private Boolean ativo;
    private Boolean online;

    public Produto(@Valid DadosCadProduto dados) {
        this.nomeProduto = dados.nomeProduto();
        this.valorVenda = dados.valorVenda();
        this.valorCusto = dados.valorCusto();
        this.ativo = true;
        this.online = dados.online();
    }
}
