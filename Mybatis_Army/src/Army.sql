create table UNITS(
units_seq varchar2(10) primary key,--군대번호
units_name varchar2(20),--군대이름
unit_username varchar2(20),
unit_password varchar2(20)
)
create sequence units_seq

create table SUPPLIES(
supplies_seq varchar2(10) primary key,--보급품 번호
supply_class varchar2(10),--보급품종류
supplies_name varchar2(100),--보급품이름
supplies_quantity number(32),--보급품수량
units_seq  varchar2(10),
	constraint UNITS_SUPPLIES_FK
    foreign key (units_seq)
    references UNITS(units_seq)
)


create sequence supplies_seq


insert into SUPPLIES(
	supplies_seq,
	supply_class,
	supplies_name,
	supplies_quantity,
	units_seq
)
values(
	supplies_seq.nextval
	#{supply_class},
	#{supplies_name},
	#{supplies_quantity},
	#{'1'}
)
insert into SUPPLIES(
	supplies_seq,
	supply_class,
	supplies_name,
	supplies_quantity,
	units_seq
)
values(
	supplies_seq.nextval,
	'2종',
	'전투복 하의',
	25,
	'1'
)
select * from units
select * from supplies
drop table units
drop table SUPPLIES
drop sequence units_seq
drop sequence supplies_seq

delete SUPPLIES where units_seq='2'