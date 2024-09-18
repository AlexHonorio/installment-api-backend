create table parcelamento(
	id bigint not null,
	client_id bigint not null,
	description varchar(20) not null,
	total_value decimal(10,2) not null,
	installments int,
	date_creation date not null,

	primary key (id)
);

alter table parcelamento add constraint fk_parcelmento_cliente
foreign key (client_id) references cliente (id);