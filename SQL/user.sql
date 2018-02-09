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
