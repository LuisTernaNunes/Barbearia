CREATE TABLE barbeiro (
    idBarbeiro BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    PRIMARY KEY (idBarbeiro)
);

CREATE TABLE cliente (
    idCliente BIGINT NOT NULL AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    PRIMARY KEY (idCliente)
);

CREATE TABLE agendamento (
    idAgendamento BIGINT NOT NULL AUTO_INCREMENT,
    idCliente BIGINT NOT NULL,
    idBarbeiro BIGINT NOT NULL,
    PRIMARY KEY (idAgendamento),
    CONSTRAINT fk_agendamento_cliente_id FOREIGN KEY (idCliente) REFERENCES cliente(idCliente),
    CONSTRAINT fk_agendamento_barbeiro_id FOREIGN KEY (idBarbeiro) REFERENCES barbeiro(idBarbeiro)
);
