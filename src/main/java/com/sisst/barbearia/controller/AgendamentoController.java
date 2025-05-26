package com.sisst.barbearia.controller;


import com.sisst.barbearia.domain.agendamento.Agendamento;
import com.sisst.barbearia.domain.agendamento.DadosAgendamento;
import com.sisst.barbearia.domain.agendamento.ExibeDadosAgendamento;
import com.sisst.barbearia.domain.agendamento.service.AgendamentoRepository;
import com.sisst.barbearia.domain.agendamento.service.AgendamentoService;
import com.sisst.barbearia.domain.agendamento.validacoes.ValidadorAgendamento;
import com.sisst.barbearia.domain.barbeiro.service.BuscaBarbeiro;
import com.sisst.barbearia.domain.carrinhoCompras.*;
import com.sisst.barbearia.domain.cliente.service.ClienteService;
import com.sisst.barbearia.domain.itemProduto.ItensCarrinho;
import com.sisst.barbearia.domain.produto.service.BuscaProduto;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

@Controller
@RequestMapping("/agendamentos")
public class AgendamentoController {
    @Autowired
    BuscaProduto buscaProduto;
    @Autowired
    BuscaBarbeiro buscaBarbeiro;
    @Autowired
    ClienteService clienteService;
    @Autowired
    CarrinhoRepository carrinhoRepository;
    @Autowired
    AgendamentoRepository agendamentoRepository;
    @Autowired
    List<ValidadorAgendamento> validador;
    @Autowired
    BuscaCarrinho buscaCarrinho;

    @PostMapping
    public ResponseEntity agendarCorte(@RequestBody @Valid DadosAgendamento dados){
        var corte = buscaProduto.buscaProduto(dados.idProduto());
        var barbeiro = buscaBarbeiro.buscaBarbeiro(dados.idBarbeiro());
        var cliente = clienteService.existeCliente(dados);
        validador.forEach(v-> v.valida(dados));
        Agendamento agendamento = new Agendamento(dados,corte,barbeiro,cliente);
        CarrinhoCompras carrinho = new CarrinhoCompras(agendamento);
        agendamentoRepository.save(agendamento);
        carrinhoRepository.save(carrinho);
        return ResponseEntity.ok(new ExibeDadosAgendamento(agendamento));
    }
    @GetMapping
    public String carregaAgendamento(Model model){
        List<CarrinhoFull> carrinho = buscaCarrinho.buscaCarriho();
        carrinho.forEach(System.out::println);
        model.addAttribute("carrinho", carrinho);
        return "agendamentos";
    }
}

