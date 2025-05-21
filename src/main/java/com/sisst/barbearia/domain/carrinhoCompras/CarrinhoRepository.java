package com.sisst.barbearia.domain.carrinhoCompras;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CarrinhoRepository extends JpaRepository<CarrinhoCompras,Long> {


    @Query("""
    SELECT new com.sisst.barbearia.domain.carrinhoCompras.ExibeCarrinho(
        cl.nome,
        a.horario,
        c.valorTotal,
        b.nomeBarbeiro
    )
    FROM CarrinhoCompras c
    JOIN c.agendamento a
    JOIN a.cliente cl
    JOIN a.barbeiro b
""")
    List<ExibeCarrinho> buscarResumoCarrinhos();
}
