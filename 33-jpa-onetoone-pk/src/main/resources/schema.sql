create table T_CUSTOMER (
    CUSTOMER_ID integer identity primary key, 
    CUSTOMER_NAME varchar(200) not null,
    BIRTH_DATE date not null,
    VERSION integer not null
);

create table T_ADDRESS (
    CUSTOMER_ID integer not null foreign key references T_CUSTOMER(customer_id), 
    STREET varchar(200) not null,
    ZIP_CITY varchar(200) not null,
    VERSION integer not null
);