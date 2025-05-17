package com.sisst.barbearia.domain.itemProduto;

import com.sisst.barbearia.domain.agendamento.Agendamento;
import com.sisst.barbearia.domain.carrinhoCompras.CarrinhoCompras;
import com.sisst.barbearia.domain.produto.Produto;
import jakarta.persistence.*;

@Entity
public class ItemProduto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "produto_id", nullable = false)
    private Produto produto;
    private int quantidade;
    @ManyToOne
    @JoinColumn(name = "carrinho_id", nullable = false)
    private CarrinhoCompras carrinho;
}
