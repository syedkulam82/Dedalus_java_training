package fourth.pac;

class MyOuter
{
	int x =7;
	class MyInner extends MyOuter
	{
		public void InnerMethod()
		{
			System.out.println("x == " + x);
		}
	}
	public void OuterMethod()
	{
		System.out.println("From outer method = " + x);
		MyInner inn = new MyInner();
		inn.InnerMethod();
	}

}
