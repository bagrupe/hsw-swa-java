create table T_PRODUCT (
    ID integer identity primary key, 
    NAME varchar(100) not null,
    SHORT_DESCRIPTION varchar(50) not null,
    LONG_DESCRIPTION varchar(255),
    PRODUCT_IMAGE varchar(255),
    PRICE decimal not null,
    VAT integer not null,
    ACTIVE integer not null
);