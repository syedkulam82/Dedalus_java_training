package third.pac;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.io.*;
import java.nio.file.attribute.UserPrincipalNotFoundException;

public class MainClass {
	//Integer is lower bound
	public static void addNumToList(List<? super Integer> list)
	{
		for(int i=0;i<10;i++)
		{
			list.add(i);
		}
		System.out.println(list);
	}
		
	//Number is the Upper bound
	public static void sumallNum(List<? extends Number> list)
	{
		double d =0;
		for(Number n :list)
		{
			d=d+n.doubleValue();
		}
		System.out.println(d);
	}
		
		
	public static void main(String[] args) throws IOException
	{
		List<Object> list1 = new ArrayList<Object>();
		addNumToList(list1);
		List<Number> list2 = new ArrayList<Number>();
		addNumToList(list2);

		List<Integer> a = Arrays.asList(1,2,3);
		sumallNum(a);
		
		List<Double> b = Arrays.asList(1.1,2.1,3.1);
		sumallNum(b);
		
		try {
			int x=18, y=28, z=0;
			z = x + y;
			System.out.println("Z: " + z);
			
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			
			System.out.println("Enter a number: ");
			x = Integer.parseInt(br.readLine());
			
			System.out.println("Entered number is " + x);
		}
		catch(NumberFormatException ex) {
			ex.printStackTrace();
			System.out.println("Number Execution - Failed");
		}
		finally {
			System.out.println("Number Execution - Success");
		}
		
		
		
		try{
			throw new UserNotFoundException();
		}
		catch(UserNotFoundException unf) {
			System.out.println(unf);
		}
		
		

		try{
			
			Employee emp1 = new Employee();
			emp1.setEno("1554099");
			emp1.setEname("Syed Kulam A");
			
			FileOutputStream fos = new FileOutputStream("C:\\Syed\\dedalus.txt");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(emp1);
			System.out.println("Serilized and written into file dedalus.txt");
			
			oos.close();
			fos.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("No file" + fnf.getMessage());
		}

		
		try{
		
			FileInputStream fis = new FileInputStream("C:\\Syed\\dedalus.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			
			Employee emp = (Employee)ois.readObject();
			System.out.println("DeSerilized from file dedalus.txt");
			System.out.println(emp.getEno());
			System.out.println(emp.getEname());
			ois.close();
			fis.close();
		}
		catch(FileNotFoundException fnf)
		{
			System.out.println("No file" + fnf.getMessage());
		}
		catch(ClassNotFoundException cnf)
		{
			System.out.println("No Emp class");
		}
	}
}

