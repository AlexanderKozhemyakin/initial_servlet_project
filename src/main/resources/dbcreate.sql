drop table products;
drop table WEBUSERS;
drop table PRODUCTS_PICTURES;
drop table SESSIONS_CARTS;

create table products (
                          id INT NOT NULL,
                          name VARCHAR(50),
                          desc VARCHAR(256),
                          price VARCHAR(256),
                          picture_name VARCHAR(256)
);

create table WEBUSERS (
                          LOGIN VARCHAR(100) NOT NULL,
                          PASSWORD VARCHAR(256) NOT NULL,
                          NAME VARCHAR(256) NOT NULL,
                          LASTNAME VARCHAR(256),
                          ADDRESS VARCHAR(512),
                          EMAIL VARCHAR(256),
                          CONTACTNUMBER VARCHAR(256) NOT NULL
);

create table PRODUCTS_PICTURES (
                                   product_id INT NOT NULL,
                                   title VARCHAR(100),
                                   image_file_name VARCHAR(256),
                                   author VARCHAR(256),
                                   image blob
);

create table SESSIONS_CARTS (
                                SESSION_ID VARCHAR(1024) NOT NULL,
                                PRODUCT VARCHAR(256),
                                QUANTITY VARCHAR(256),
                                USERNAME VARCHAR(256),
                                PRICE VARCHAR(256),
                                STATUS VARCHAR(256)
);

insert into products(id,name,desc,price,picture_name) values (1,'tshirt1','test good1','50','tshirt1.jpeg');
insert into products(id,name,desc,price,picture_name) values (2,'tshirt2','test good2','65.11','tshirt2.jpeg');
insert into products(id,name,desc,price,picture_name) values (3,'tshirt3','test good3','10.99','tshirt3.jpeg');
insert into products(id,name,desc,price,picture_name) values (4,'tshirt4','test good4','77.7','tshirt4.jpeg');
insert into products(id,name,desc,price,picture_name) values (5,'tshirt5','test good5','5','tshirt5.jpeg');

insert into WEBUSERS(LOGIN,PASSWORD,NAME,LASTNAME,ADDRESS,EMAIL,CONTACTNUMBER ) values ('test','test','test','test','test','test@test.ru','test');

insert into PRODUCTS_PICTURES(product_id,title,image_file_name,author,image) values (1,'test title','tshirt1.jpeg','test author','data:image/png;base64,iVBORw0KGgoAAAANSUhEUgAAAAgAAAAIAQMAAAD+wSzIAAAABlBMVEX///+/v7+jQ3Y5AAAADklEQVQI12P4AIX8EAgALgAD/aNpbtEAAAAASUVORK5CYII');

insert into SESSIONS_CARTS(session_id,product,quantity,username,price,status) values ('test_session_id_of_testuser','tshirt1',1,'test','55.99','CONFIRMED');
insert into SESSIONS_CARTS(session_id,product,quantity,username,price,status) values ('test_session_id_of_testuser','tshirt2',1,'test','57.99','CONFIRMED');
insert into SESSIONS_CARTS(session_id,product,quantity,username,price,status) values ('test_session_id_of_testuser','tshirt3',1,'test','155.99','CONFIRMED');