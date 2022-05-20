create table articles
(
    id   serial primary key,
    name varchar(50) not null
);

create table balance
(
    id          serial primary key,
    create_date timestamp(3) not null
);

create table operations
(
    id          serial primary key,
    article_id  int references articles not null,
    balance_id  int references balance  not null,
    debit       numeric(18, 2)          not null,
    credit      numeric(18, 2)          not null,
    create_date timestamp(3)            not null
);
