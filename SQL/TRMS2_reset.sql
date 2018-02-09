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

create sequence users_pk_seq;
create table users
(
    id number(20) primary key,
    firstname varchar2(32),
    lastname varchar2(32),
    username varchar2(32) unique not null,
    email varchar2(32) unique not null
)

create table tournament (
    tournament_id number(10) primary key,
    type varchar2(256) not null,
    style varchar(256) not null, --Will be bracket only for now
    owner_id number(10) not null,
    judge_id number(10) not null,
    min_num number(10) not null,
    max_num number(10) not null
);

create table tourny_registry (
    record_id number(10) primary key,
    participant_id number(10) not null,
    tourny_id number(10) not null
);

create table tourny_rounds (
    record_id number(10) primary key,
    round_num number(10) not null,
    tourny_id number(10) not null,
    player_1 number(10), -- Allow to be null or have a default value
    player_2 number(10), -- same as above
    team_1 number(10), -- same as above
    team_2 number(10), -- same as above
    win number(10) not null, -- default value for pending results
    loss number(10) not null
);

-------- Constraints --------
/*
alter table tournament
add constraint fk_owner_id foreign key (owner_id)
references users (user_id) on delete cascade;

alter table tournament
add constraint fk_judge_id foreign key (judge_id)
references users (user_id) on delete cascade;

alter table tourny_registry
add constraint fk_tourny_id foreign key (tourny_id)
references tournament (tournament_id) on delete cascade;

alter table tourny_registry
add constraint fk_participant_id foreign key (participant_id)
references users (user_id) on delete cascade;

alter table tourny_rounds
add constraint fk_tourny_id foreign key (tourny_id)
references tournament (tournament_id) on delete cascade;

alter table tourny_rounds
add constraint fk_player1 foreign key (player_1)
references users (user_id) on delete cascade;

alter table tourny_rounds
add constraint fk_player2 foreign key (player_2)
references users (user_id) on delete cascade;
*/

------ Sequences for Hibernate -------
create sequence tournyid_seq;
create sequence register_seq;
create sequence rounds_seq;