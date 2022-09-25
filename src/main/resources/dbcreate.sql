drop table products;
drop table orders;
drop table WEBUSERS;
drop table PRODUCTS_PICTURES;

create table products (
                          id INT NOT NULL,
                          name VARCHAR(50),
                          desc varchar(256)
);

create table orders(
                       operday VARCHAR(50) not null,
                       productid INT,
                       quantity INT,
                       price NUMERIC,
                       clientid int
);

create table WEBUSERS (
                          LOGIN VARCHAR(100) NOT NULL,
                          PASSWORD varchar(256) NOT NULL,
                          NAME varchar(256) NOT NULL,
                          LASTNAME varchar(256),
                          ADDRESS varchar(512),
                          EMAIL varchar(256),
                          CONTACTNUMBER varchar(256) NOT NULL
);

create table PRODUCTS_PICTURES (
                                   product_id INT NOT NULL,
                                   title VARCHAR(100),
                                   author VARCHAR(256),
                                   image blob
);

insert into products(id,name,desc) values (1,'T-SHIRT 1','test good1');
insert into products(id,name,desc) values (2,'T-SHIRT 2','test good2');
insert into products(id,name,desc) values (3,'T-SHIRT 3','test good3');
insert into products(id,name,desc) values (4,'T-SHIRT 4','test good4');
insert into products(id,name,desc) values (5,'T-SHIRT 5','test good5');

insert into WEBUSERS(USERNAME,PASSWORD,NAME,LASTNAME,ADDRESS,EMAIL,CONTACTNUMBER ) values ('test','test','test','test','test','test@test.ru','test');

insert into PRODUCTS_PICTURES(product_id,title,author,image) values (1,'test title','test author','data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAgAAAAIAQMAAAD+wSzIAAAABlBMVEX///+/v7+jQ3Y5AAAADklEQVQI12P4AIX8EAgALgAD/aNpbtEAAAAASUVORK5CYII');