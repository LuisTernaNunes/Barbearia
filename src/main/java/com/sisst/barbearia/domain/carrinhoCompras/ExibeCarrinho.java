package com.sisst.barbearia.domain.carrinhoCompras;

import com.sisst.barbearia.domain.itemProduto.ItemProduto;
import com.sisst.barbearia.domain.itemProduto.ItensCarrinho;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

public record ExibeCarrinho(String nome, LocalDateTime horario,Double valorTotal, String nomeBarbeiro, String nomeProduto, Double valorVenda, Long id) {

}
