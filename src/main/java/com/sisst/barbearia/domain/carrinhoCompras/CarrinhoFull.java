package com.sisst.barbearia.domain.carrinhoCompras;

import com.sisst.barbearia.domain.itemProduto.ItensCarrinho;

import java.time.LocalDateTime;
import java.util.List;

public record CarrinhoFull(ExibeCarrinho exibeCarrinho,List<ItensCarrinho> itensCarrinho) {
}
