drop table memp;
create table memp(eno number(5),ename varchar2(10),sal number(20));

desc memp;

insert into memp values(10,'Ram',1000);
insert into memp values(20,'Ravi',2000);
savepoint A;
insert into memp values(30,'Akhil',3000);
savepoint B;
insert into memp(eno,ename) values(40,'Asha');
savepoint C;
update memp set sal=4500 where eno=40;
rollback to C;
delete from memp where eno=40 ;
update memp set sal=5000 where eno=40;
commit;



select * from memp;
rollback;
desc memp
alter table memp add phone number(5);
alter table memp modify phone number(10);
alter table memp drop column phone;
select * from memp;

truncate table memp;
alter table memp rename column phone to mobile;

delete from memp where eno=30;

Transaction : TCL
--- Begins with DML
--- Ends with TCL - commit,rollback ,savepoint(bookmark)
-- All the DDL stmt will have auto commit.
-- All DML requires explicit commit.
-- After commit rollback will not work
-- After commit savepoints will be deleted.

-------------------------------------------------
--Insert using subqueries:

insert into table(col,col) values (subquery);

create table tab1(col1 number,col2 number);
create table tab2(col3 number,col4 number);

select * from tab1,tab2;
--syntax 1:
insert into tab1(col1,col2) select empno, sal from emp;

--
--insert into tab2(col2, col4) values (select t1.col2,t2.col4 from tab1 t1 ,tab2 t2);

select * from tab2;
drop table tab2;

create table tab2 as select * from emp;   -- take a backup of a table

drop table stu2
create table stu2(rollno number, sname varchar2(10), dept number);
insert into stu2(rollno,sname,dept) select empno,ename,deptno from emp; 

select * from stu2;
-- Multiple insert

create table stu2(rollno number, sname varchar2(10), dept number);

insert all
into stu2(rollno,sname,dept) values(100,'Chiru',20)
into stu2(rollno,sname,dept) values(200,'Chitra',20)
into stu2(rollno,sname,dept) values(300,'Shankar',20)
into stu2(rollno,sname,dept) values(400,'Sanjeev',20)
select * from dual;

select * from stu2;

-----------------------------------------------------
DCL

create role chiru identified by chiru;

Other DB Objects

view:
drop view myview;
create or replace view myview as select empno,ename,sal,deptno from emp;

select * from myview;

desc chiruview;
drop table gurutab;
create or replace force  view chiruview as select no,name from gurutab;
create table gurutab(no number, name varchar2(10));
insert into gurutab values(1,'asd');
insert into gurutab values(2,'asdf');
select * from chiruview;

insert into chiruview values(3,'hello');

create table abctab(dob number(5), mgr number(5));
insert into abctab values(11,222);
insert into abctab values(12,999);
select * from abctab;

create or replace  view chiruview as select max(a.dob),min(g.no) from gurutab g join abctab a on g.no<a.dob;
select * from chiruview;

create or replace view mview as select empno, ename,deptno from emp where deptno=20
with read only constraint wro_mview; 

insert into mview (empno,ename,deptno) values(4446,'Sharuk',30);
select * from mview;

create sequence mphseq
  increment by 1
  start with 1
 maxvalue  10
 nocycle
 nocache;
 
 alter sequence mphseq
  maxvalue  10
 cycle
 cache 5 ;
 
 desc tab2;
 
 create table tab2(empno number(5),ename varchar2(10),deptno number(5));
 insert into  tab2(empno,ename,deptno) values(mphseq.NEXTVAL,'Sharuk',30);
 
 select * from tab2;
 
constrainst:
Primary key    --  NO null, NO duplicates
Unique key   -- No duplicates, accepts null
Notnull          -- No Null, accepts duplicates  cant give at the table level
check           -- only constraint with exptression 
foreign key - to cfreate r/s among tables


2types
Table level contr
Column level contr

drop table employee2;

create table dept2(dno number(5) constraint dep2_pk_dno primary key,dname varchar2(10));

create table employee2(empno number(5) constraint emp2_pk_empno primary key, ename varchar2(10) not null,phone number(5) unique,  
sal number(5), deptno number(5), constraint emp2_ck_sal check(sal>5000), 
constraint emp2_fk_deptno foreign key(deptno) references dept2(dno));

insert into employee2 values(1,'Raja',4444,6000,10);
insert into employee2 values(2,'Raja',4444,6000);

insert into dept2 values(10,'IT');

select * from employee2;