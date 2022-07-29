use exchange_db;
create table currency_exchange (id bigint not null auto_increment, exchange_value double precision, from_currency varchar(255), to_currency varchar(255), primary key (id)) engine=InnoDB;
insert into currency_exchange(from_currency, to_currency, exchange_value) values('USD', 'INR', 79.90);
insert into currency_exchange(from_currency, to_currency, exchange_value) values('USD', 'EUR', 0.9866);
insert into currency_exchange(from_currency, to_currency, exchange_value) values('INR', 'JPY', 1.71);
insert into currency_exchange(from_currency, to_currency, exchange_value) values('EUR', 'INR', 80.97);
