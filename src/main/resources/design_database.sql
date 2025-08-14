-- Design a database for an online store that sells products 
-- to customers, handles orders
-- Main Actors
-- Product (id,name, price)
-- Order (id,order_date)
-- Customer (id,name)





create table customers(
	customer_id int,
	customer_name varchar(30) not null,
	constraint customer_id_pk primary key(customer_id)
)

create table orders(
	order_id int,
	order_date date not null,
	customer_id int,
	constraint order_id_pk primary key(order_id),
	foreign key (customer_id)
	references customers(customer_id)
)


create table products(
	product_id int,
	product_name varchar(30) not null,
	constraint product_id_pk primary key(product_id)
)

create table order_product(
	order_id int,
	product_id int,
	
	foreign key (order_id)
	references orders(order_id),
	
	foreign key (product_id)
	references products(product_id)
	
)
