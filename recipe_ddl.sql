show databases;

create table food (id bigint not null auto_increment, category varchar(10), img varchar(255), name varchar(50) not null, primary key (id)) engine=InnoDB;
create table ingredient (id bigint not null auto_increment, category varchar(10), name varchar(20) not null, primary key (id)) engine=InnoDB;
create table recipe (id bigint not null auto_increment, main_material bit not null, food_name varchar(50), ingredient_name varchar(20), primary key (id)) engine=InnoDB;
create table sauce (id bigint not null auto_increment, name varchar(20) not null, primary key (id)) engine=InnoDB;

-- alter table food add constraint UK_qkhr2yo38c1g9n5ss0jl7gxk6 unique (name);
-- alter table ingredient add constraint UK_bcuaj97y3iu3t2vj26jg6hijj unique (name);
-- alter table sauce add constraint UK_s4feg9vkis7xjax33j89i96s0 unique (name);
-- alter table recipe add constraint FK8fg37x136bum4fx4gol7wxmd1 foreign key (food_name) references food (name);
-- alter table recipe add constraint FKll9cjn9egj9uv6552t1cvuj5y foreign key (ingredient_name) references ingredient (name);

alter table food add constraint UK_NAME_UNIQUE unique (name);
alter table ingredient add constraint UK_NAME_UNIQUE unique (name);
alter table sauce add constraint UK_NAME_UNIQUE unique (name);
alter table recipe add constraint FK_FOOD_NAME foreign key (food_name) references food (name);
alter table recipe add constraint FK_INGREDIENT_NAME foreign key (ingredient_name) references ingredient (name);


show databases;
show tables;