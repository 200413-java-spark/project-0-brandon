create table products(
	prod_id serial primary key,
	prod_name varchar,
	prod_qty integer
);

insert into products (prod_name,prod_qty) values ('butter',8);
insert into products (prod_name,prod_qty) values ('milk',7);
insert into products (prod_name,prod_qty) values ('bread',10);
