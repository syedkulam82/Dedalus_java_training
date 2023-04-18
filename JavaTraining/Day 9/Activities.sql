-- Group functions  - ignores NULL values

select sum(sal),count(*),min(sal),max(sal),avg(sal) from emp;
select count(comm) from emp;
select count(nvl(comm,1)) from emp ;
 
 
 
 --group by clause  -- to create subgroups
 
 Rules:
1) Columns in the select list shd be there in group by clause
   select job,deptno from emp group by deptno,job;

2) Columns in the group by clause may or may not be there in the select list
 	 select job from emp group by deptno,job;


3) Alias name cannot be used in group by
	 select deptno en from emp group by deptno;

4) group by results in unique values/results
	select deptno from emp group by deptno;


5) The columns in the select list within group function may or maynot be there in group by clause.
	select min(sal),deptno from emp group by deptno;


6) To restrict the no.of rows in the group use having clause
	select min(sal),deptno from emp group by deptno having deptno=20;


7) The column used in having clause shd be used in group by clause.
	select min(sal),deptno from emp group by deptno,sal having sal>1000;

8) If the column in the having clause is within the group function , then it may or maynot be in the group by clause.
	select min(sal),deptno from emp group by deptno having min(sal)>900;

9) Having clause cannot accept alias name.
	select min(sal),deptno  from emp group by deptno dn having dn=30;

10) Cannot use group function with where clause
	select sal,deptno from emp where min(sal)>=950 

--Joins
---------

Natural join  --  it is a type of equi join where the equality condition is taken implicity
--column used in NATURAL join cannot have qualifier

select ename,job,sal,deptno,dname from emp natural join dept;

--Where clause shd be given after join condition.
select ename,job,sal,deptno,dname from emp join dept using(deptno) where job like 'SALESMAN';

-- For applying the join condition use on NOT where.
select e.ename,e.job,e.sal,d.deptno,d.dname from emp e  join dept d on e.deptno=d.deptno where job like 'MANAGER';

select e.ename,e.job,e.sal,e.deptno,d.dname from emp e  join dept d on e.deptno>20;


select e.ename,e.job,e.sal,e.deptno,d.dname from emp e  full outer join dept d on e.deptno=d.deptno;

select m.ename || '  is the manager of  ' || e.ename "Manager Details" from emp  e join emp m
on  m.empno = e.mgr;

select e.ename,e.deptno,d.dname from emp e cross join dept d;

select * from salgrade

--150. List the emps along with of those who belongs to Dallas New York with Sal ranging from 2000 to 5000 joined in 1981.
select * from emp e, dept d 
where e.sal between 2000 and 5000
and EXTRACT( YEAR FROM e.hiredate ) = 1981
and (d.loc = 'DALLAS' or d.loc = 'NEW YORK')

--151. List the Empno, Ename, Sal, grade of all emps.
select e.empno, e.ename, e.sal, sg.grade
from emp e, salgrade sg
where e.sal between sg.losal and sg.hisal

--152. List the grade 2 & 3 emps of Chicago.
select *
from emp e, salgrade sg, dept d
where d.deptno = e.deptno
and e.sal between sg.losal and sg.hisal
and (sg.grade = 2 or sg.grade = 3)
and d.loc = 'CHICAGO'

select * from dept



