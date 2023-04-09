package fourth.pac;

import fourth.pac.MyOuter.MyInner;

public class MainClass {
	
	static int num1;
	int num2;
	
	static
	{	
		System.out.println("From Static Block2");
		num1=99;
	}
	//First Static Block	
	static
	{	
		System.out.println("From Static Block1");
		num1=60;
	}

	public static void main(String[] args) {
		
		String[] stringArray = new String[3];
		stringArray[0] = "Syed";
		stringArray[1] = "Kulam";
		stringArray[2] = "Sabeer";
		
		for(int i = 0; i < stringArray.length; i++)
			System.out.println(stringArray[i]);
		
		
		
		Employee[] empArray = new Employee[3];
		
		empArray[0] = new Employee();
		empArray[0].setEno("101");
		empArray[0].setEname("Syed");
		
		empArray[1] = new Employee();
		empArray[1].setEno("102");
		empArray[1].setEname("Kulam");
		
		empArray[2] = new Employee();
		empArray[2].setEno("103");
		empArray[2].setEname("Sabeer");
		
		for(int i = 0; i < empArray.length; i++) {
			System.out.println(empArray[i].getEno());
			System.out.println(empArray[i].getEname());
		}
		
		
		
		System.out.println(num1);
		
		
		
		String str1 = "I like Java";
		System.out.println("str 1 " + str1);
		System.out.println(" Is Empty ?" +str1.isEmpty());
		System.out.println(" Length of str1: " + str1.length());
		System.out.println(" charAt " +str1.charAt(4));
		System.out.println(" concat " + str1.concat(" Programming"));
		System.out.println(" equals : " +str1.equals("I like C") );
		System.out.println(" lowercase : " +str1.toLowerCase());
		System.out.println(" substring(2) " + str1.substring(2));
		System.out.println(" substring(2,5) " + str1.substring(2,5));	
		System.out.println("compare " + str1.compareTo("I like java"));
		System.out.println(" contains :" + str1.contains("Java"));
		System.out.println(" trim " + "    ABC    ");
		//System.out.println(" " + );


		String s1="Java";
		String s2="Java";
		s1="java";

		System.out.println(s1.hashCode());
		System.out.println(s2.hashCode());
		

		
		StringBuffer demo1 = new StringBuffer("Good");
		System.out.println(demo1.hashCode());
		System.out.println(demo1);
		demo1.append(" Afternoon");
		System.out.println(demo1);
		System.out.println(demo1.hashCode());
		
		StringBuilder demo2 = new StringBuilder("Good");
		System.out.println(demo2.hashCode());
		System.out.println(demo2);
		demo2.append(" Evening");
		System.out.println(demo2);
		System.out.println(demo2.hashCode());
		
		
		
		OuterClass.InnerClass ic = new OuterClass.InnerClass();
		ic.iDisplay();

		OuterClass oc = new OuterClass();
		oc.oDisplay();
		
		
		
		MyOuter mo = new MyOuter();
		//MyInner inn = new MyInner(); //invalid
		//inn.InnerMethod();
		//<outerclassname>.<innerclassname> objname = <outerclass instancename>.new <innerclassname>();
		MyOuter.MyInner mi = mo.new MyInner(); //instantiate inner class
		mi.InnerMethod();
		mo.OuterMethod();
		//mi.OuterMethod();  illegal
		//mo.InnerMethod();   illegal
		 
	}

}
