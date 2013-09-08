# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table card (
  id                        integer not null,
  name                      varchar(255),
  colors                    varchar(255),
  type                      varchar(255),
  set                       varchar(255),
  rarity                    varchar(255),
  constraint pk_card primary key (id))
;

create table pickorder (
  id                        integer not null,
  name                      varchar(255),
  constraint pk_pickorder primary key (id))
;

create table PICKORDER_CARD (
  rank                      integer,
  card_id                   integer,
  pickorder_id              integer)
;

create table task (
  id                        bigint not null,
  label                     varchar(255),
  constraint pk_task primary key (id))
;

create sequence card_seq;

create sequence pickorder_seq;

create sequence task_seq;

alter table PICKORDER_CARD add constraint fk_PICKORDER_CARD_card_1 foreign key (card_id) references card (id) on delete restrict on update restrict;
create index ix_PICKORDER_CARD_card_1 on PICKORDER_CARD (card_id);
alter table PICKORDER_CARD add constraint fk_PICKORDER_CARD_pickorder_2 foreign key (pickorder_id) references pickorder (id) on delete restrict on update restrict;
create index ix_PICKORDER_CARD_pickorder_2 on PICKORDER_CARD (pickorder_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists card;

drop table if exists pickorder;

drop table if exists PICKORDER_CARD;

drop table if exists task;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists card_seq;

drop sequence if exists pickorder_seq;

drop sequence if exists task_seq;

