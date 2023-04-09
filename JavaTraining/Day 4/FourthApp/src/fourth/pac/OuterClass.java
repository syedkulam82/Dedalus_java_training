package fourth.pac;

public class OuterClass {
	static int i =10;
	public void oDisplay()
	{
		System.out.println("i == " + ++i);
	}	
	
	static class InnerClass
	{
		public void iDisplay()
		{
			System.out.println("i == " + i);
		}
	}
}
