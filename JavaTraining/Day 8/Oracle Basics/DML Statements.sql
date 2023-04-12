select * from dalemp;
----------------------------------------------------------------------------------------------------------
select * from emp;
select empno,ename from emp;  -- select column name
select empno,ename,sal from emp;

--as is optional
select empno,ename,sal as salary from emp;   
select empno,ename,sal "Annual salary" from emp;   -- alias shd b enclosed within "  "

select empno,ename,sal  "Annual salary" from emp;
select empno, ename, sal, sal+200 Bonus from emp;  -- accepts expr

select distinct deptno from emp;
select distinct deptno,sal, ename from emp;
-- adding string litral using '  ' . Concatination operator is ||
select ename ||' works for   ' || mgr  "manager Details" from emp;

select ename || q'[work's for]'  || mgr  "manager Details" from emp;

describe emp;  -- gives table structure
desc emp;
-- Datas are case sensitive
select empNO,ename,sal as salary from emp where ename='SMITH';   
select empno,ename,sal as salary,job  from emp where ename='SMITH' and  job='CLERK' ;   
select empno,ename,sal as salary,job  from emp where ename='SMITH' or  sal>2500 ;   
-- between and - incl of the range
select empno,ename,sal as salary,job  from emp where sal  between 1000 and 3000;

-- like - pattern matching   %   _
select empno,ename,sal as salary,job  from emp where ename not like 'A%';
select empno,ename,sal as salary,job  from emp where ename like  '_A%';
select empno,ename,sal as salary,job  from emp where ename like '%N';


select empno,ename,sal as salary,job  from emp where sal not between 1000 and 3000;

select empno,ename,sal as salary,job  from emp where ename not like 'A%';
select empno,ename,sal as salary,job  from emp where ename like  '_A%';
select empno,ename,sal as salary,job  from emp where ename like '%N';
--*************************
select empno,ename,sal as salary,job,deptno  from emp where deptno  in(10,20);
select empno,ename,sal as salary,job,deptno  from emp where deptno=10 or deptno=20;

select empno,ename,sal as salary,job,deptno,comm  from emp where comm is not null;

-- sorting
select empno,ename,sal as salary,job,deptno,comm  from emp order by ename desc;-- column name in order by

select empno,ename en,sal as salary,job,deptno,comm  from emp order by 2 ; -- column position in select list in order by
select empno,ename en,sal as salary,job,deptno,comm  from emp order by en ; -- alias name in order by
select empno,ename en,sal as salary,job,deptno,comm  from emp where sal >1000 order by en; 

select &en from emp;

select &enae from &etab where &s=&val; -- substitution variables
select ename from emp where sal=3000;

select &&ena from &etab where &s=&var;  --will prompt only once when varia prefixed with &&

--Functions:
select lower(ename) from emp;
select upper('hello') from dual;  -- dual is a dummy table with one cell
select initcap(ename) from emp;

select concat('Sakshi','Shri') from dual;
select length('Sakshi ') from dual;
select instr('sakshi ', 's') from dual;
select  ename, substr(ename,1,3) from emp;
select  ename, substr(ename,3) from emp;

select replace('ambrtam','am','jj') from dual; -- consider the string
select translate('ambrtam','amb','bo4') from dual; -- consider the character

select length('     hei     ') from dual;
select length(trim('     hei     ')) from dual;
select lpad('Hello',10,'#') from dual;
select rpad('Hello',10,'#') from dual;

select chr(66) from dual;
select ascii('B') from dual;


select ROUND(45.926, 2) from dual;
select ROUND(45.926, 1) from dual;
select ROUND(45.926, 0) from dual;
select ROUND(45.926, -1) from dual;
select ROUND(444.926, -1) from dual;


select trunc(45.926, 2) from dual;
select trunc(45.926, 1) from dual;
select trunc(45.926, 0) from dual;
select trunc(45.926, -1) from dual;
select trunc(45.926, -2) from dual;
select mod(1600,300) from dual;

select sysdate from dual;  -- Date format DD-MON-RR   (DD-MM-RR)
select current_timestamp from dual;

select round('06-Jan-21','year') from dual;
select round('06-Jan-21','month') from dual;
select trunc('06-Jan-21','year') from dual;
select trunc('06-Jan-21','month') from dual;

select round('26-Jan-21','year') from dual;
select round('26-Jan-21','month') from dual;
select trunc('26-Jan-21','year') from dual;
select trunc('26-Jan-21','month') from dual;

select round('06-Jul-21','year') from dual;
select round('06-Jul-21','month') from dual;
select trunc('06-Jul-21','year') from dual;
select trunc('06-Jul-21','month') from dual;

select round('26-Jul-21','year') from dual;
select round('26-Jul-21','month') from dual;
select trunc('26-Jul-21','year') from dual;
select trunc('26-Jul-21','month') from dual;

select round('15-Jun-21','year') from dual;
select round('15-Jun-21','month') from dual;
select trunc('15-Jun-21','year') from dual;
select trunc('15-Jun-21','month') from dual;  --Ans: