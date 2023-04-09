package second.app;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Map;
import java.util.HashMap;

public class MainClass {
		
	public static void main(String[] args) {
		System.out.println("My Name - " + getName());
		System.out.println("My Name - " + getName("Kulam"));
		
		System.out.println("My Manager Name - " + (new Manager()).getName());
		System.out.println("My Manager Name - " + (new Manager()).getEmployeeName());
		
		System.out.println("My Manager Name - " + (new Employee()).getNameX());
		
		System.out.println("My Manager Name - " + (new Employee()).getDefaultName());
		
		List<String> list = new ArrayList<String>();
		list.add("Ram");
		list.add("Ganesh");
		list.add("Zia");
		System.out.println(list);
		
		Set <String> list1 = new HashSet<String>();
		list1.add("Ram");
		list1.add("Ganesh");
		list1.add("Zia");
		System.out.println(list1);
		
		Map<Integer, String> map= new HashMap<>();  
		map.put(100, "Julaiga");
		map.put(101, "Nisha");
		map.put(102, "Silvia");
		map.put(104, "Vanthana");
		map.put(103, "Deepthi");
		map.put(105, "Elavarasi");
		System.out.println(map);
		System.out.println(map.size());
	}
	
	private static String getName() {
		return "Syed";
	}
	
	private static String getName(String name) {
		return name;
	}
	

}
