package com.sisst.barbearia.domain.barbeiro;

public record DadosBarbeiro(String nome,String telefone) {
    public DadosBarbeiro(Barbeiro barbeiro) {
        this(barbeiro.getNomeBarbeiro(),barbeiro.getTelefone());
    }
}
