package com.sisst.barbearia.domain.carrinhoCompras;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public record ExibeCarrinho(String nome, LocalDateTime horario,Double valor, String nomeBarbeiro) {

}
