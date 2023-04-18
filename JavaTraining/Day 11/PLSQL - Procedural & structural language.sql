plsql-1.sql
PLSQL : Procedural Language / Structured Query Language
-----------------

declare                         -- OPTIONAL
     -- Declaration block
begin                             -- MANDATORY
     -- executable block
exception                      -- OPTIONAL
    --  exception block

end;                               -- MANDATORY
/                                     -- EXECUTOR


SET SERVEROUTPUT  ON
Pgm1 :
BEGIN
   DBMS_OUTPUT.PUT_LINE('WELCOME');
END;
/                   
Pgm2:
---------
declare
    x number :=10;
begin
    dbms_output.put_line(x);
end;
/

pgm 3:
-----------
--<<outer>>
declare
    x  number :=100;
begin
     --<<inner>>
     declare
            x  number :=200;
     begin
              dbms_output.put_line('  From inner block  ' ||x);
              dbms_output.put_line('  From inner block  ' ||outer.x);    -- right
    end;
            dbms_output.put_line('  From outer block  ' ||x);
            dbms_output.put_line('  From outer block  ' ||inner.x);      -- error
end;
/

pgm 4:

Variable : Place holder with a name
Types of variables:
1) Scalar var      ----   hold only one value/cell
2) Composite variable  -- hold one record

Non-plsql variable:
---------------------------
3) BInd variable   --> prefixed with colon  :
declare
   v_name varchar2(25);
begin
     select ename into v_name from emp where empno=7369;
      dbms_output.put_line(v_name);
end;
/

variable v_ename varchar2;
begin
     select ename into :v_ename from emp where empno=7369;     
end;
/
print v_ename;

---------------------------------------------
if then else
----------------
declare 
     salary number(8);
begin 
    salary :=&saly;
    if(salary <7000) then
        salary := salary+4000;
       dbms_output.put_line(' Salary now : ' ||salary);    
    elsif salary >10000 then
         dbms_output.put_line(' Salary now : ' ||salary);   
    else
       salary := salary+1000;
       dbms_output.put_line(' Salary now : ' ||salary);   
    end if;
end;
/

declare 
   grade char(3) := upper('&g');
   choice varchar2(20);
begin
    choice :=
     CASE grade
         when 'A' then 'Excellent'         
         when 'B' then 'Good'
         when 'C' then 'FAIR'
         else 'No such grade'
      end;
       dbms_output.put_line(' Grade  : ' ||grade || '  -------  ' || choice);   
end;
/

Loops:
---------
1) for
2) loop



begin
   for i in 1..10   loop
       dbms_output.put_line(' i  : ' || i);   
   end loop;
end;
/

declare 
   x number :=0;
begin
    loop
       dbms_output.put_line(' x : ' || x);  
       x:=x+1;
       if x=5 then exit;
       end if;    
    end loop;
end;
/

composite variable
---------------------------

declare 
  type emprec is record(
       vid number(5),
       vname varchar2(20),
       vsal number(8,2));
  
   er  emprec;
begin
  -- er.vid :=100;
 --  er.vname :='John';
 --  er.vsal :=10000;
   
      select empno,ename,sal into er.vid,er.vname, er.vsal from emp where empno=7369;
    dbms_output.put_line(' Id : ' || er.vid);  
     dbms_output.put_line(' Name : ' || er.vname);  
      dbms_output.put_line(' Sal : ' || er.vsal);  
   
end;
/

-------------------------------------------------------------------------

CREATE  a replica of emp table. Name it as emp2
    Add a column name incentive
    if sal > 1000
       incentive shd be sal + 500
    else
       incentive shd be sal +300 
    for empnumber = 7369;

create table emp2 as select * from emp;
alter table emp2 add incentive number(10);

DECLARE
eno number(5) := &EnterempNumber;
vsal number(10);
begin
select sal into vsal from emp2 where empno=eno; 
    if vsal > 1000 then
       update emp2 set incentive=sal + 500 where empno= eno;
    else
      update emp2 set incentive=sal +300 where empno= eno;
   end if;
end;
/

-------------------------------------
Alter the emp table by adding a column experience
     using plsql block
         Accept the hiredate during the runtime and calculate the experience. 
         Update the experience in the table 
         
alter table emp2 add experience number(10);

DECLARE
hd date;
eno number(10) :=&eno;
begin
select hiredate into hd from emp2 where empno=eno;     
update emp2 set experience=(sysdate-hd)/365 where empno=eno;   
end;
/

select ADD_MONTHS( DATE '2016-02-29', 1 )  from dual;
SELECT CURRENT_DATE FROM dual;

SELECT CURRENT_TIMESTAMP FROM dual;

select MONTHS_BETWEEN( DATE '2017-07-01', DATE '2017-01-01' ) from dual;
select NEXT_DAY( sysdate, 'MONDAY' ) from dual;

update emp2 set experience=null;

DECLARE
dt1 DATE := TO_DATE('&new_dt', 'DD-MON-YYYY');
get_day VARCHAR2(15);
BEGIN
get_day := rtrim(TO_CHAR(dt1, 'DAY'));
IF get_day  in ('SUNDAY') THEN
  DBMS_OUTPUT.PUT_LINE('The day of the given date is '||get_day||' sunday');
ELSE
  DBMS_OUTPUT.PUT_LINE ('The day of the given date it is not sunday');
END IF;
END;
/

-------------------------------------------------------------
CURSOR: 

--> It is a named memory location which is under the developers control.

What can be done?
--> Load all your records as per your need
->> fetch and work on the records

Steps to be followed:
1) Declare the cursor   --> name the cursor and specifiy the set of records to be loaded in that area
2) open the cursor
3) Fetch records from the cursor
4) Close the cursor.

Cursor attributes:

set serveroutput on;
declare
    emprec emp%rowtype;
    cursor mycur is select * from emp where deptno=10;
begin
    open mycur;
    loop
    fetch mycur into emprec;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(emprec.empno || '     ' || emprec.ename || '    ' || emprec.deptno || emprec.job); 
    end loop;
    close mycur;
end;
/





declare
    eno emp.empno%type;
    enam emp.ename%type;
    job emp.job%type;
    manager emp.mgr%type;
    hdate emp.hiredate%type;
    salry emp.sal%type;
    commn emp.comm%type;
    dno emp.deptno%type;
    cursor mycur is select * from emp where deptno=10;
begin
    if not mycur%ISOPEN then
    open mycur;
    end if;
    loop
    fetch mycur into eno,enam,job,manager,hdate,salry, commn,dno;
    exit when mycur%NOTFOUND;    
    dbms_output.put_line(eno || '     ' || enam || '    ' ||dno); 
    end loop;
    close mycur;
end;
/
-----------------------------------------------------