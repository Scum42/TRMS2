-- Remove the user to start fresh
drop user trms2 cascade;

-- Make the user
create user trms2
identified by p4ssw0rd
default tablespace users
temporary tablespace temp
quota 10m on users;

-- Permissions for the user
grant connect to trms2;
grant resource to trms2;
grant create session to trms2;
grant create table to trms2;
grant create view to trms2;

-- Connect to the user we just made
conn trms2/p4ssw0rd;

drop table tournament cascade constraints;
drop table tourny_registry cascade constraints;
drop table tourny_rounds cascade constraints;
drop table login cascade constraints;

drop sequence tournyid_seq;
drop sequence register_seq;
drop sequence rounds_seq;
drop sequence team_pk_seq;
drop sequence users_pk_seq;
drop sequence round_pk_seq;
drop sequence result_pk_seq;
drop sequence team_user_pk_seq;
drop sequence tourny_user_pk_seq;
drop sequence tourny_round_pk_seq;

create table users
(
    user_id number(20) primary key,
    firstname varchar2(32),
    lastname varchar2(32),
    username varchar2(32) unique not null,
    pass varchar2(32) not null,
    email varchar2(32) unique not null
);
--
create table team (
    team_id number(10) primary key,
    team_name varchar2(256) unique not null,
    captain number(10) not null
);

--
create table team_to_user (
    record_id number(10) primary key,
    t_id number(10) not null,
    p_id number(10) not null
);
--
create table tournament (
    tournament_id number(10) primary key,
    tuourny_type varchar2(256) not null,
    style varchar2(256) not null, --Will be bracket only for now
    owner_id number(10) not null,
    judge_id number(10) not null,
    min_num number(10) not null,
    max_num number(10) not null
);
--
create table tourny_to_user (
    record_id number(10) primary key,
    participant_id number(10) not null,
    tourny_id number(10) not null
);
--
create table tourny_to_round (
    record_id number(10) primary key,
    round_id number(10) not null,
    tourny_id number(10) not null
);
--
create table round (
    round_id number(10) primary key,
    round_num number(10) not null,
    player1 number(10) not null,
    player2 number(10) not null,
    r_result number(10) not null
);
--
create table results (
    result_id number(10) primary key,
    win number(10), -- player id of winner
    loss number(10) -- player id of loser
);

-------- Constraints --------
alter table team_to_user
add constraint fk_t_id foreign key (t_id)
references team (team_id) on delete cascade;

alter table team_to_user
add constraint fk_p_id foreign key (p_id)
references users (user_id) on delete cascade;

alter table team
add constraint fk_captain foreign key (captain)
references users (user_id) on delete cascade;

alter table tournament
add constraint fk_owner_id foreign key (owner_id)
references users (user_id) on delete cascade;

alter table tournament
add constraint fk_judge_id foreign key (judge_id)
references users (user_id) on delete cascade;

alter table tourny_to_round
add constraint fk_tourny_id foreign key (tourny_id)
references tournament (tournament_id) on delete cascade;

alter table tourny_to_round
add constraint fk_round_id foreign key (round_id)
references round (round_id) on delete cascade;

alter table round
add constraint fk_player1 foreign key (player1)
references users (user_id) on delete cascade;

alter table round
add constraint fk_player2 foreign key (player2)
references users (user_id) on delete cascade;

alter table round
add constraint fk_result foreign key (r_result)
references results (result_id) on delete cascade;

alter table tourny_to_user
add constraint fk_participant_id foreign key (participant_id)
references users (user_id) on delete cascade;

alter table tourny_to_user
add constraint fk_tourny_user_id foreign key (tourny_id)
references tournament (tournament_id) on delete cascade;

alter table results
add constraint fk_win foreign key (win)
references users (user_id) on delete cascade;

alter table results
add constraint fk_loss foreign key (loss)
references users (user_id) on delete cascade;


------ Sequences for Hibernate -------
create sequence tournyid_seq;
create sequence register_seq;
create sequence rounds_seq;
create sequence team_pk_seq;
create sequence users_pk_seq;
create sequence round_pk_seq;
create sequence team_user_pk_seq;
create sequence result_pk_seq;
create sequence tourny_user_pk_seq;
create sequence tourny_round_pk_seq;