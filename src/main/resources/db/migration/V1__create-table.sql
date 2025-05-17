-- Criação da tabela Produto
CREATE TABLE produto (
    produto_id BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_produto VARCHAR(255) NOT NULL,
    valor_venda DOUBLE NOT NULL,
    valor_custo DOUBLE NOT NULL,
    endereco_imagem VARCHAR(255),
    ativo BOOLEAN NOT NULL,
    online BOOLEAN NOT NULL
);

-- Criação da tabela Barbeiro
CREATE TABLE barbeiro (
    id_barbeiro BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_barbeiro VARCHAR(255) NOT NULL,
    telefone VARCHAR(20),
    ativo BOOLEAN NOT NULL,
    senha VARCHAR(255) NOT NULL,
    foto VARCHAR(255),
    email VARCHAR(255) NOT NULL
);

-- Criação da tabela Cliente
CREATE TABLE cliente (
    id_cliente BIGINT AUTO_INCREMENT PRIMARY KEY,
    nome_cliente VARCHAR(255) NOT NULL,
    telefone_cliente VARCHAR(20),
    email_cliente VARCHAR(255) NOT NULL
);

-- Criação da tabela Agendamento
CREATE TABLE agendamento (
    id_agendamento BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_cliente BIGINT NOT NULL,
    horario TIMESTAMP NOT NULL,
    id_barbeiro BIGINT,
    id_produto BIGINT NOT NULL,
    ativo BOOLEAN NOT NULL,
    CONSTRAINT fk_cliente FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    CONSTRAINT fk_barbeiro FOREIGN KEY (id_barbeiro) REFERENCES barbeiro(id_barbeiro),
    CONSTRAINT fk_produto FOREIGN KEY (id_produto) REFERENCES produto(produto_id)
);

-- Criação da tabela CarrinhoCompras
CREATE TABLE carrinho_compras (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_agendamento BIGINT NOT NULL UNIQUE,
    valor_total DECIMAL(10,2),
    abertura TIMESTAMP,
    status VARCHAR(10) NOT NULL,
    pagamento VARCHAR(10) NOT NULL,
    CONSTRAINT fk_agendamento FOREIGN KEY (id_agendamento) REFERENCES agendamento(id_agendamento)
);

-- Criação da tabela ItemCarrinho
CREATE TABLE item_carrinho (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    id_produto BIGINT NOT NULL,
    quantidade INT NOT NULL,
    valor_unitario DECIMAL(10,2) NOT NULL,
    id_carrinho BIGINT NOT NULL,
    CONSTRAINT fk_produtos FOREIGN KEY (id_produto) REFERENCES produto(produto_id),
    CONSTRAINT fk_carrinho FOREIGN KEY (id_carrinho) REFERENCES carrinho_compras(id)
);