package com.sisst.barbearia.domain.barbeiro;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "barbeiro")
public class Barbeiro {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBarbeiro;
    private String nomeBarbeiro;
    private String telefone;
    private Boolean ativo;
    private String senha;
    private String foto;
    private String email;

    public Barbeiro(@Valid DadosCadBarbeiro dadosBarbeiro) {
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        nomeBarbeiro = dadosBarbeiro.nome();
        telefone = dadosBarbeiro.telefone();
        senha = encoder.encode(dadosBarbeiro.senha());
        ativo = true;
    }
}
