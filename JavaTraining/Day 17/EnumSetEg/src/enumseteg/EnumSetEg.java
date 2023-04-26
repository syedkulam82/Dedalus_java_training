package enumseteg;

import java.util.EnumSet;
import java.util.Iterator;

public class EnumSetEg {
	// an enum named Size
	enum Size {
		SMALL, MEDIUM, LARGE, EXTRALARGE
	}

	public static void main(String[] args) {

		// Creating an EnumSet using allOf() -contains all the values of the specified
		// enum type Size
		EnumSet<Size> sizes = EnumSet.allOf(Size.class);

		System.out.println("EnumSet: " + sizes);

		// Creating an EnumSet using range()
		EnumSet<Size> sizes1 = EnumSet.range(Size.MEDIUM, Size.EXTRALARGE);

		System.out.println("EnumSet1: " + sizes1);

		// Using of() with a single parameter -
		// The of() method creates an enum set containing the specified elements
		EnumSet<Size> sizes3 = EnumSet.of(Size.MEDIUM);
		System.out.println("EnumSet3: " + sizes3);

		EnumSet<Size> sizes4 = EnumSet.of(Size.SMALL, Size.LARGE);
		System.out.println("EnumSet4: " + sizes4);

		// Creating an EnumSet using allOf()
		EnumSet<Size> sizes5 = EnumSet.allOf(Size.class);

		Iterator<Size> iterate = sizes5.iterator();

		System.out.print("EnumSet5: ");
		while (iterate.hasNext()) {
			System.out.print(iterate.next());
			System.out.print(", ");
		}

		// Creating an EnumSet using allOf()
		EnumSet<Size> sizes6 = EnumSet.allOf(Size.class);

		// Creating an EnumSet using noneOf()
		EnumSet<Size> sizes7 = EnumSet.noneOf(Size.class);

		// Using add method
		sizes7.add(Size.MEDIUM);
		System.out.println("EnumSet7 Using add(): " + sizes7);

		// Using addAll() method
		sizes7.addAll(sizes1);
		System.out.println("EnumSet7 Using addAll(): " + sizes7);
	}
}