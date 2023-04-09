package firstapplication.pack;

public class HelloWorld {
	public static void main(String[] args) {
		FreshJuice juice = new FreshJuice();
		juice.size = FreshJuice.FreshJuiceSize.MEDIUM ;
		System.out.println("Size: " + juice.size);
	      
	    Calculator cal = new Calculator();
	    int num1 = 10;
	    int num2 = 6;
	    System.out.println("Addition of " + num1 + " & " + num2 + " is " + cal.Add(num1, num2));
	    System.out.println("Subtraction of " + num1 + " & " + num2 + " is " + cal.Subtract(num1, num2));
	    System.out.println("Multiplication of " + num1 + " & " + num2 + " is " + cal.Multiply(num1, num2));
	    System.out.println("Division of " + num1 + " & " + num2 + " is " + cal.Divide(num1, num2));
	    
	    CalculatorAdv calAdv = new CalculatorAdv();
	    System.out.println("Reminder of the division of " + num1 + " & " + num2 + " is " + calAdv.Mod(num1, num2));
	}
}

class FreshJuice {
	   enum FreshJuiceSize{ SMALL, MEDIUM, LARGE }
	   FreshJuiceSize size;
	}