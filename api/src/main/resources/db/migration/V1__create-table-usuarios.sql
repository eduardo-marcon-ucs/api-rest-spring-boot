CREATE TABLE usuarios (
    id bigint not null AUTO_INCREMENT,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    profissao VARCHAR(100) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    bairro VARCHAR(100) NOT NULL,
    cep VARCHAR(8) NOT NULL,
    uf CHAR(2) NOT NULL,
    numero INT NOT NULL,
    complemento VARCHAR(100) NOT NULL,

    primary key(id)
);
