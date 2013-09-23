# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table card (
  id                        bigint not null,
  name                      varchar(255),
  colors                    varchar(255),
  type                      varchar(255),
  set                       varchar(255),
  rarity                    varchar(255),
  constraint pk_card primary key (id))
;

create table pickorder (
  id                        bigint not null,
  name                      varchar(255),
  constraint pk_pickorder primary key (id))
;

create table PICKORDER_CARD (
  name                      varchar(255),
  colors                    varchar(255),
  type                      varchar(255),
  set                       varchar(255),
  rarity                    varchar(255),
  card_id                   bigint not null,
  rank                      integer)
;

create sequence card_seq;

create sequence pickorder_seq;

create sequence PICKORDER_CARD_seq;

alter table PICKORDER_CARD add constraint fk_PICKORDER_CARD_card_1 foreign key (card_id) references card (id) on delete restrict on update restrict;
create index ix_PICKORDER_CARD_card_1 on PICKORDER_CARD (card_id);



# --- !Downs

SET REFERENTIAL_INTEGRITY FALSE;

drop table if exists card;

drop table if exists pickorder;

drop table if exists PICKORDER_CARD;

SET REFERENTIAL_INTEGRITY TRUE;

drop sequence if exists card_seq;

drop sequence if exists pickorder_seq;

drop sequence if exists PICKORDER_CARD_seq;

