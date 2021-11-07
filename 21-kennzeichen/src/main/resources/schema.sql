drop table T_KENNZEICHEN if exists;

create table T_KENNZEICHEN (
    ID integer identity primary key, 
    KENNZEICHEN varchar(10) not null,
    RESERVIERT integer not null,
    VERGEBEN integer not null,
    TOKEN varchar(50));