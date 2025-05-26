package com.sisst.barbearia.domain.carrinhoCompras;

import com.sisst.barbearia.domain.itemProduto.ItensCarrinho;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

@Service
public class BuscaCarrinho {
    @Autowired
    CarrinhoRepository carrinhoRepository;
    public List<CarrinhoFull> buscaCarriho(){
        var inicioDia = LocalDate.now().atStartOfDay();
        var fimDia = LocalDate.now().atTime(LocalTime.MAX);

        List<ExibeCarrinho> carrinho = carrinhoRepository.buscarResumoCarrinhos(inicioDia,fimDia);

        List<CarrinhoFull> carrinhosComItens = carrinho.stream()
                .map(c -> {
                    List<ItensCarrinho> itensCarrinho = carrinhoRepository.buscaItensCarrinho(c.id());
                    return new CarrinhoFull(c, itensCarrinho);
                })
                .toList();
        return carrinhosComItens;
    }
}
