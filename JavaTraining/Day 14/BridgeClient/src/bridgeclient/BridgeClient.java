/*
Abstraction
Making the class abstract, so that you cannot instantiate it

*/
abstract class ElectronicItem {
	protected String productType;
	protected double cost;
	// Composition - implementor
	protected PriceType priceType;

	protected ElectronicItem(PriceType priceType) {
		this.priceType = priceType;
	}

	protected void showPriceDetail() {
		priceType.displayProductPrice(productType, cost);
	}

// The additional methods for demonstration-2
	protected void getDiscount(int percentage) {
		priceType.festiveSeasonDiscount(percentage);
	}

	protected void conveyThanks() {
		priceType.sayThanks();
	}
}

//Implementor
//PriceType.java
interface PriceType {
	void displayProductPrice(String product, double cost);

	// The additional method(s) in implementation-2
	void festiveSeasonDiscount(int percentage);

	void sayThanks();
}

//OnlinePrice.java
class OnlinePrice implements PriceType {
	@Override
	public void displayProductPrice(String productType, double cost) {

		System.out.println("The " + productType + "'s online cost is $" + cost * .9);
	}

	@Override
	public void festiveSeasonDiscount(int percentage) {
		System.out.println("You can get a maximum of " + percentage + "% discount in festive season.");
	}

	@Override
	public void sayThanks() {
		System.out.println("Thank you for your interest in our product.");
	}
}

//ShowroomPrice.java
class ShowroomPrice implements PriceType {
	@Override
	public void displayProductPrice(String productType, double cost) {
		System.out.println("The " + productType + "'s showroom price is $" + cost);
	}

	@Override
	public void festiveSeasonDiscount(int percentage) {
		System.out.println("You can get a maximum of " + percentage + "% discount in the festive seasons.");
	}

	@Override
	public void sayThanks() {
		System.out.println("Thank you for your interest in our product.");
	}
}

//Television.java
class Television extends ElectronicItem {
	/*
	 * Implementation specific: Delegating the task to the Implementor object.
	 */
	public Television(PriceType priceType) {
		super(priceType);
		this.productType = "television";
		this.cost = 2000;
	}
	// No additional method exists for Television
}

//DVD.java
class DVD extends ElectronicItem {
	/*
	 * Implementation specific: Delegating the task to the Implementor object.
	 */
	public DVD(PriceType priceType) {
		super(priceType);
		this.productType = "DVD";
		this.cost = 3000;
	}

	// Specific method in the DVD class
	public void getDoubleDiscountWithThanks() {
		getDiscount(10); // 10% discount
		getDiscount(5); // Additional 5% discount
		conveyThanks();
	}
}

//Client.java
class BridgeClient {
	public static void main(String[] args) {
		System.out.println("***Implementation of Bridge Pattern.***");
		System.out.println("Verifying the market price of a television.");
		// Verifying online price
		ElectronicItem eItem = new Television(new OnlinePrice());
		eItem.showPriceDetail();
		// Verifying the offline/showroom price
		eItem = new Television(new ShowroomPrice());
		eItem.showPriceDetail();
		eItem.getDiscount(7);
		eItem.conveyThanks();
		// Error: the following method is DVD specific.
		// eItem.getDoubleDiscountWithThanks();
		System.out.println("----------");
		System.out.println("Verifying the market price of a DVD.");
		// Verifying online price
		eItem = new DVD(new OnlinePrice());
		eItem.showPriceDetail();
		// Verifying the offline/showroom price
		eItem = new DVD(new ShowroomPrice());
		eItem.showPriceDetail();
		// Checking the DVD specific method
		((DVD) eItem).getDoubleDiscountWithThanks();
	}
}