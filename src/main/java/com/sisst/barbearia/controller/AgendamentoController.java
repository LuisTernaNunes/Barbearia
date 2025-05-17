package com.sisst.barbearia.controller;


import com.sisst.barbearia.domain.agendamento.Agendamento;
import com.sisst.barbearia.domain.agendamento.DadosAgendamento;
import com.sisst.barbearia.domain.agendamento.ExibeDadosAgendamento;
import com.sisst.barbearia.domain.agendamento.service.AgendamentoRepository;
import com.sisst.barbearia.domain.agendamento.service.AgendamentoService;
import com.sisst.barbearia.domain.barbeiro.DadosBarbeiro;
import com.sisst.barbearia.domain.carrinhoCompras.CarrinhoCompras;
import com.sisst.barbearia.domain.carrinhoCompras.CarrinhoRepository;
import com.sisst.barbearia.domain.cliente.Cliente;
import com.sisst.barbearia.domain.cliente.ClienteService;
import com.sisst.barbearia.domain.cliente.DadosAgendamentoCliente;
import com.sisst.barbearia.domain.produto.DadosProduto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/agendamento")
public class AgendamentoController {
    @Autowired
    AgendamentoService agendamentoService;
    @Autowired
    ClienteService clienteService;
    @Autowired
    CarrinhoRepository carrinhoRepository;
    @Autowired
    AgendamentoRepository agendamentoRepository;

    @PostMapping
    public ResponseEntity agendarCorte(@RequestBody @Valid DadosAgendamento dados){
        var produto = agendamentoService.buscaProduto(dados.idProduto());
        var barbeiro = agendamentoService.buscaBarbeiro(dados.idBarbeiro());
        var cliente = clienteService.existeCliente(dados);
        Agendamento agendamento = new Agendamento(dados,produto,barbeiro,cliente);
        CarrinhoCompras carrinho = new CarrinhoCompras(agendamento);
        System.out.println(agendamento.getCliente().getIdCliente());
        agendamentoRepository.save(agendamento);
        carrinhoRepository.save(carrinho);
        return ResponseEntity.ok(new ExibeDadosAgendamento(agendamento));
    }
}

