select distinct job from emp;

select * from job;

--Create a program to retrieve the number of years of service for a specific employee.

--a. Create a stored function called GET_SERVICE_YRS to retrieve the total number of years
--of service for a specific employee.
--The function should accept the employee ID as a parameter and return the number of years
--of service. Add error handling to account for an invalid employee ID.

Create Or Replace Function GET_SERVICE_YRS(empID in number)
Return number Is

service_yrs number(5);

Begin
    select extract(year from sysdate) - extract(year from hiredate) into service_yrs from emp where empno = empID;
    return service_yrs;

Exception
    when NO_DATA_FOUND then
        dbms_output.put_line('Employee Number Does Not Exist');
        return null;
End;

select GET_SERVICE_YRS(7566) from dual;


--b. Invoke the function. You can use the following data:
--EXECUTE DBMS_OUTPUT.PUT_LINE(get_service_yrs(999))
--Hint: The above statement should produce an error message because there is no employee
--with employee ID 999.

EXECUTE DBMS_OUTPUT.PUT_LINE(GET_SERVICE_YRS(999));
EXECUTE DBMS_OUTPUT.PUT_LINE(GET_SERVICE_YRS(7566));
EXECUTE DBMS_OUTPUT.PUT_LINE ('Approximately .... ' ||get_service_yrs(7499) || ' years')


--c. Create a stored procedure called UPD_SAL to update the  salaries
--for a specific job in the EMP table.
--Pass three parameters to the procedure: the job , a new minimum salary, and a new
--maximum salary for the job. Add exception handling to account for an invalid job name in the
--EMP table. Also, raise an exception if the maximum salary supplied is less than the minimum salary.

Create Or Replace PROCEDURE UPD_SAL(jobToUpd in varchar2, newMinSal in number, newMaxSal in number) 
IS
INVALID_MAXSAL Exception;
Begin    
    If newMaxSal < newMinSal then
        Raise INVALID_MAXSAL;
    End If;
    
    update job 
    set minsal = newMinSal,
        maxsal = newMaxSal
    where job = jobToUpd;
    
    If SQL%ROWCOUNT = 0 then 
        RAISE NO_DATA_FOUND;
    Else
        dbms_output.put_line('Salary updated for the specified JOB..');
    End If;
    
Exception
    when NO_DATA_FOUND then
        dbms_output.put_line('Invalid Job Name specified..');
    when INVALID_MAXSAL then
        dbms_output.put_line('Maximum Salary should be higher than Minimum Salary..');
End;


EXECUTE UPD_SAL('CLERK', 1500, 1200);   -- Throws error Maximum Salary should be higher than Minimum Salary..
EXECUTE UPD_SAL('SECURITY', 1500, 2500);   -- Throws error Invalid Job Name specified..


-- d. Make these functions available in a package name EMPPACK

Create or Replace package emppack as
    Function GET_SERVICE_YRS(empID in number) Return number;
    PROCEDURE UPD_SAL(jobToUpd in varchar2, newMinSal in number, newMaxSal in number);
end;


emppack.get_service_yrs(999);
