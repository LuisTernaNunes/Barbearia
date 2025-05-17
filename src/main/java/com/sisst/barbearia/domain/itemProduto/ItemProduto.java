package com.sisst.barbearia.domain.itemProduto;

import com.sisst.barbearia.domain.agendamento.Agendamento;
import com.sisst.barbearia.domain.carrinhoCompras.CarrinhoCompras;
import com.sisst.barbearia.domain.carrinhoCompras.DadosAddProduto;
import com.sisst.barbearia.domain.produto.Produto;
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
@Table(name = "item_carrinho")
public class ItemProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "id_produto", nullable = false)
    private Produto produto;
    private long quantidade;
    @ManyToOne
    @JoinColumn(name = "id_carrinho", nullable = false)
    private CarrinhoCompras carrinho;
    private double valorUnitario;

    public ItemProduto(@Valid Produto produto, CarrinhoCompras carrinho, Long quantidade ) {
        this.carrinho = carrinho;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valorUnitario = produto.getValorVenda();
    }
}
