drop table products;
drop table sales;
drop table WEBUSERS;

create table products (
    id INT NOT NULL,
    name VARCHAR(50),
    desc varchar(256)
);

create table sales(
    oper_day date not null,
    productid INT,
    quantity INT,
    price BigDecimal
);

create table WEBUSERS (
    USERNAME VARCHAR(100) NOT NULL,
    PASSWORD varchar(256)
);

insert into products(id,name,description) values (1,'T-SHIRT 1','test good1');
insert into products(id,name,description) values (2,'T-SHIRT 2','test good2');
insert into products(id,name,description) values (3,'T-SHIRT 3','test good3');
insert into products(id,name,description) values (4,'T-SHIRT 4','test good4');
insert into products(id,name,description) values (5,'T-SHIRT 5','test good5');

insert into WEBUSERS(USERNAME,PASSWORD) values ('A','B');