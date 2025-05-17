package com.sisst.barbearia.domain.carrinhoCompras;

import com.sisst.barbearia.domain.agendamento.Agendamento;
import com.sisst.barbearia.domain.pagamento.Pagamento;
import com.sisst.barbearia.domain.itemProduto.ItemProduto;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

@ToString
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Entity
@Table(name = "carrinho_compras")
public class CarrinhoCompras {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<ItemProduto> produtos;
    @OneToOne(optional = false)
    @JoinColumn(name = "idAgendamento", nullable = false, unique = true)
    private Agendamento agendamento;
    private Double valorTotal;
    private LocalDateTime abertura;
    @Enumerated(EnumType.STRING)
    private Status status;
    @Enumerated(EnumType.STRING)
    private Pagamento pagamento;

    public CarrinhoCompras(Agendamento agendamento) {
        this.agendamento = agendamento;
        this.abertura = LocalDateTime.now();
        this.status = Status.ABERTO;
        this.valorTotal = agendamento.getProduto().getValorVenda();
        this.pagamento= Pagamento.NAOPAGO;
    }

    public void addProdutos(ItemProduto itens) {
        produtos.add(itens);
        this.valorTotal = this.valorTotal + itens.getValorUnitario() * itens.getQuantidade();
    }
}
