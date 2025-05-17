package com.sisst.barbearia.domain.agendamento;

import com.sisst.barbearia.domain.barbeiro.Barbeiro;
import com.sisst.barbearia.domain.barbeiro.DadosAgendamentoBarbeiro;
import com.sisst.barbearia.domain.cliente.Cliente;
import com.sisst.barbearia.domain.cliente.DadosAgendamentoCliente;
import com.sisst.barbearia.domain.produto.DadosAgendamentoProduto;
import com.sisst.barbearia.domain.produto.Produto;

import java.time.LocalDateTime;

public record DadosAgendamento(DadosAgendamentoCliente cliente, LocalDateTime horario,Long idBarbeiro, Long idProduto) {
}
