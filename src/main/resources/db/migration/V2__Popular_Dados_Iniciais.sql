insert into categoria(nome_categoria, descricao)
values ("Bolos", "Bolos caseiros e fofinhos");

insert into restaurante(cnpj, nome_restaurante, telefone_restaurante)
values ("67339895000164", "Panificadora & Confeitaria Agridoce", "9837832125");

insert into produto(nome_prod, dispon_prod, descricao_prod, preco_prod, foto_prod ,id_categoria_prod, id_restaurante_prod)
values ("Bolo de Chocolate", "Disponível", "Bolo de chocolate com recheio e calda", 27.30,"src/main/resources/static/images/bolo_chocolate.jpeg", 1, 1);

insert into cliente (nome_cliente, telefone_cliente)
values ("Jorge", "9624705648");

insert into pedido (data_pedido, status_pedido, valor_total, id_cliente_ped)
values ('2025-09-11', "AGUARDANDO_PAGAMENTO", 27.30, 1);

insert into roles (nome) values ('ROLE_USER'), ('ROLE_ADMIN')
on duplicate key update nome=nome;