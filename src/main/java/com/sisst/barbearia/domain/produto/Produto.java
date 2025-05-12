package com.sisst.barbearia.domain.produto;

import com.sisst.barbearia.domain.agendamento.Agendamento;
import jakarta.persistence.*;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "produtos")
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProduto;
    private String nomePorduto;
    private Double valorVenda;
    private Double valorCusto;
    private String enderecoImagem;
    private Boolean ativo;
    private Long online;
}
