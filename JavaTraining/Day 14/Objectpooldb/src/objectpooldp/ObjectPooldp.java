package objectpooldp; 

import java.util.HashSet;
import java.util.Set;
class Employee {
    private int id;
    private String name;
    private String email;

    public Employee() {
        // default constructor
    }

    public Employee(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    // getters and setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


class EmployeePool {
    private static EmployeePool instance;
    private Set<Employee> employees;
    private int poolSize;

    private EmployeePool() {
        employees = new HashSet<>();
        poolSize = 3;
    }

    public static synchronized EmployeePool getInstance() {
        if (instance == null) {
            instance = new EmployeePool();
        }
        return instance;
    }

    public synchronized Employee acquire() {
        if (employees.isEmpty()) {
            return new Employee();
        }
        Employee e = employees.iterator().next();
        employees.remove(e);
        return e;
    }

    public synchronized void release(Employee e) {
        if (employees.size() < poolSize) {
            employees.add(e);
        }
    }
}

public class ObjectPooldp{
	public static void main(String[] args) {
	    EmployeePool pool = EmployeePool.getInstance();

	    // Acquire three employees from the pool
	    Employee e1 = pool.acquire();
	    Employee e2 = pool.acquire();
	    Employee e3 = pool.acquire();

	    // Release two employees back into the pool
	    pool.release(e1);
	    pool.release(e2);

	    // Acquire two more employees from the pool
	    Employee e4 = pool.acquire();
	    Employee e5 = pool.acquire();
	    Employee e6 = pool.acquire();
	    Employee e7 = pool.acquire();

	    // e1 and e2 should be the same object as before
	    System.out.println(e1 == e4); // true
	    System.out.println(e2 == e5); // true
	    
	    System.out.println(e1);
	    System.out.println(e2);
	    System.out.println(e3);
	    System.out.println(e4);
	    System.out.println(e5);
	    System.out.println(e6);
	    System.out.println(e7);
	}

}
