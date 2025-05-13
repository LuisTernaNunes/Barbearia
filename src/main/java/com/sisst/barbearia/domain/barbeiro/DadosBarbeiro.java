package com.sisst.barbearia.domain.barbeiro;

public record DadosBarbeiro(String nome,String telefone,String email) {
    public DadosBarbeiro(Barbeiro barbeiro) {
        this(barbeiro.getNomeBarbeiro(),barbeiro.getTelefone(), barbeiro.getEmail());
    }
}
