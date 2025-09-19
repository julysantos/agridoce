-- 1) Tabelas base (sem dependências)
create table categoria (
    id_categoria int auto_increment primary key,
    nome_categoria varchar (120) not null,
    descricao text
);

create table restaurante (
    id_restaurante int auto_increment primary key,
    cnpj varchar (14) not null,
    nome_restaurante varchar (240) not null,
    telefone_restaurante varchar (11) not null,
    foto_restaurante varchar(255)
);

create table roles (
    id_roles int auto_increment primary key,
    nome varchar(25) unique not null
);

create table usuario (
    id_usuario bigint auto_increment primary key,
    login varchar(255) unique not null,
    senha varchar(255) not null
);

create table entregador (
    id_entregador int auto_increment primary key,
    nome varchar (120) not null,
    telefone_entrega varchar (11) not null,
    placa_veiculo varchar (7) not null
);

-- 2) Tabelas que dependem das anteriores
create table usuario_roles (
    usuario_id bigint not null,
    role_id int not null,
    primary key (usuario_id, role_id),
    foreign key (usuario_id) references usuario(id_usuario),
    foreign key (role_id) references roles(id_roles)
);

create table cliente (
    id_cliente int auto_increment primary key,
    nome_cliente varchar (120) not null,
    telefone_cliente varchar (11) not null,
    id_usuario_cliente bigint,
    foreign key (id_usuario_cliente) references usuario(id_usuario)
);

create table endereco (
    id_endereco int auto_increment primary key,
    id_cliente_end int,
    id_restaurante_end int,
    rua varchar (120) not null,
    numero varchar (120) not null,
    bairro varchar (90) not null,
    cep varchar (8) not null,
    foreign key (id_cliente_end) references cliente(id_cliente),
    foreign key (id_restaurante_end) references restaurante(id_restaurante)
);

create table produto (
    id_produto int auto_increment primary key,
    nome_prod varchar (120) not null,
    dispon_prod enum('DISPONIVEL','ESGOTADO','INDISPONIVEL') not null,
    descricao_prod varchar (120),
    preco_prod decimal (10,2) not null,
    foto_prod varchar(255),
    id_categoria_prod int,
    id_restaurante_prod int,
    foreign key (id_categoria_prod) references categoria(id_categoria),
    foreign key (id_restaurante_prod) references restaurante(id_restaurante)
);

create table pedido (
    id_pedido int auto_increment primary key,
    data_pedido date,
    status_pedido enum ('AGUARDANDO_PAGAMENTO', 'PAGAMENTO_CONFIRMADO', 'EM_PREPARO') not null,
    valor_total decimal (10,2) not null,
    id_cliente_ped int,
    foreign key (id_cliente_ped) references cliente(id_cliente)
);

create table pagamento (
    id_pagamento int auto_increment primary key,
    id_pedido_pag int,
    valor_pag decimal (10,2) not null,
    metodo_pag varchar (120) not null,
    foreign key (id_pedido_pag) references pedido(id_pedido)
);

create table entrega (
    id_entrega int auto_increment primary key,
    id_pedido_ent int,
    id_entregador_ent int,
    status_entrega enum ('SAIU_PARA_ENTREGA', 'ENTREGUE', 'PEDIDO_CONCLUIDO') not null,
    tempo_estimado time,
    foreign key (id_pedido_ent) references pedido(id_pedido),
    foreign key (id_entregador_ent) references entregador(id_entregador)
);

