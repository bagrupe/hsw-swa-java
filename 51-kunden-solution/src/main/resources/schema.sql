create table T_CUSTOMER (
    ID integer identity primary key, 
    PASSWORD varchar(32) not null,
    PRENAME varchar(100) not null,
    SURNAME varchar(100) not null,
    BIRTHDATE date not null,
    STREET varchar(100) not null,
    STREETNO varchar(10) not null,
    ZIPCODE varchar(20) not null,
    CITY varchar(30) not null,
    COUNTRY varchar(30) not null,
    IBAN varchar(22) not null,
    ACTIVE integer not null
);