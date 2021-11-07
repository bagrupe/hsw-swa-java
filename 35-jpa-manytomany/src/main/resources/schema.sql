create table T_CUSTOMER (
    ID integer identity primary key, 
    CUSTOMER_NAME varchar(200) not null,
    BIRTH_DATE date not null,
    VERSION integer not null
);

create table T_ADDRESS (
    ID integer identity primary key,
    STREET varchar(200) not null,
    ZIP_CITY varchar(200) not null,
    VERSION integer not null
);

create table T_CUSTOMER_ADDRESS (
    CUSTOMER_ID integer not null foreign key references T_CUSTOMER(id),
    ADDRESS_ID integer not null foreign key references T_ADDRESS(id)
);