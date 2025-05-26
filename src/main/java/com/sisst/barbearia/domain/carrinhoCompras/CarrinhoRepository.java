package com.sisst.barbearia.domain.carrinhoCompras;

import com.sisst.barbearia.domain.itemProduto.ItensCarrinho;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface CarrinhoRepository extends JpaRepository<CarrinhoCompras,Long> {


    @Query("""
    SELECT new com.sisst.barbearia.domain.carrinhoCompras.ExibeCarrinho(
        cl.nome,
        a.horario,
        c.valorTotal,
        b.nomeBarbeiro,
        p.nomeProduto,
        p.valorVenda,
        c.id
    )
    FROM CarrinhoCompras c
    JOIN c.agendamento a
    JOIN a.cliente cl
    JOIN a.barbeiro b
    JOIN a.produto p
    WHERE a.horario BETWEEN :inicioDia AND :fimDia
""")
    List<ExibeCarrinho> buscarResumoCarrinhos(LocalDateTime inicioDia, LocalDateTime fimDia);

    @Query("""
    SELECT new com.sisst.barbearia.domain.itemProduto.ItensCarrinho(
        p.nomeProduto,
        i.quantidade,
        p.valorVenda
    )
    FROM ItemProduto i
    JOIN i.produto p
    WHERE i.carrinho.id = :id
""")
    List<ItensCarrinho> buscaItensCarrinho(@Param("id") Long id);
}
