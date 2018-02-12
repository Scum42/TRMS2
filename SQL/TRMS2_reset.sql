Skip to content
This repository
Search
Pull requests
Issues
Marketplace
Explore
 @nbirchfield
 Sign out
 Unwatch 4
  Star 0  Fork 0 libardia/TRMS2
 Code  Issues 0  Pull requests 0  Projects 0  Wiki  Insights
Branch: master Find file Copy pathTRMS2/SQL/TRMS2_reset.sql
c09bf71  15 hours ago
 nicholas birchfield Added tourny_to_round table in SQL script
1 contributor
RawBlameHistory     
120 lines (106 sloc)  3.18 KB
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
create table tournament (
    tournament_id number(10) primary key,
    tourny_type varchar2(256) not null,
    style varchar2(256) not null, --Will be bracket only for now
    owner_id number(10) not null,
    judge_id number(10) not null,
    min_num number(10) not null,
    max_num number(10) not null
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
create table tourny_to_round (
    t_id number(10) references tournament (tournament_id),
    r_id number(10) references round (round_id),
    constraint tourny_round_pk primary key (t_id, r_id)
);
--
create table results (
    result_id number(10) primary key,
    win number(10), -- player id of winner
    loss number(10) -- player id of loser
);
--
create table team_to_user (
    t_id number(10) references tournament (tournament_id),
    p_id number(10) references users (user_id),
    constraint team_user_pk primary key (t_id, p_id)
);
--
create table tourny_to_user (
    participant_id number(10) references users (user_id),
    tourny_id number(10) references tournament (tournament_id),
    constraint tourny_user_pk primary key (participant_id, tourny_id)
);

-------- Constraints --------
alter table team
add constraint fk_captain foreign key (captain)
references users (user_id) on delete cascade;

alter table tournament
add constraint fk_owner_id foreign key (owner_id)
references users (user_id) on delete cascade;

alter table tournament
add constraint fk_judge_id foreign key (judge_id)
references users (user_id) on delete cascade;

alter table round
add constraint fk_player1 foreign key (player1)
references users (user_id) on delete cascade;

alter table round
add constraint fk_player2 foreign key (player2)
references users (user_id) on delete cascade;

alter table round
add constraint fk_result foreign key (r_result)
references results (result_id) on delete cascade;

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
create sequence result_pk_seq;
© 2018 GitHub, Inc.
Terms
Privacy
Security
Status
Help
Contact GitHub
API
Training
Shop
Blog
About