/* logico_agviagens: */

CREATE TABLE Cliente (
    nome VARCHAR,
    endereco VARCHAR,
    cpf INTEGER PRIMARY KEY,
    telefone INTEGER,
    email VARCHAR,
    RG INTEGER
);

CREATE TABLE Passagem (
    empresaArea VARCHAR,
    numeroBilhete INTEGER PRIMARY KEY,
    origem VARCHAR,
    destino VARCHAR,
    dataViagem DATE,
    horario TIME,
    acento VARCHAR,
    dadosPassageiro VARCHAR
);

CREATE TABLE Compra (
    fk_Cliente_cpf INTEGER,
    fk_Passagem_numeroBilhete INTEGER,
    idPedido INTEGER PRIMARY KEY
);
 
ALTER TABLE Compra ADD CONSTRAINT FK_Compra_2
    FOREIGN KEY (fk_Cliente_cpf)
    REFERENCES Cliente (cpf)
    ON DELETE RESTRICT;
 
ALTER TABLE Compra ADD CONSTRAINT FK_Compra_3
    FOREIGN KEY (fk_Passagem_numeroBilhete)
    REFERENCES Passagem (numeroBilhete)
    ON DELETE SET NULL;