create table chicken(
chicken_seq varchar2(10) primary key,
chicken_kind varchar2(20),
chicken_grade varchar2(10),
chicken_age varchar2(5),
indate date
)
create sequence chicken_seq
create table egg(
egg_seq varchar2(10) primary key,
chicken_seq varchar2(10),
egg_price varchar2(10),
egg_grade varchar2(10)
)
create sequence egg_seq

select * from CHICKEN