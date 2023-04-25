package factorydpat.com;

interface Pizza {
	void prepare();

	void bake();

	void cut();

	void box();
}

class PepperoniPizza implements Pizza {

	@Override
	public void prepare() {
		System.out.println("Preparing Pepperoni Pizza");

	}

	@Override
	public void bake() {

		System.out.println("Baking Pepperoni Pizza");
	}

	@Override
	public void cut() {
		System.out.println("Cutting Pepperoni Pizza");

	}

	@Override
	public void box() {
		System.out.println("Boxing Pepperoni Pizza");

	}

}

class VeggiePizza implements Pizza {
	@Override
	public void prepare() {
		System.out.println("Preparing Veggie Pizza");

	}

	@Override
	public void bake() {

		System.out.println("Baking Veggie Pizza");
	}

	@Override
	public void cut() {
		System.out.println("Cutting Veggie Pizza");

	}

	@Override
	public void box() {
		System.out.println("Boxing Veggie Pizza");

	}

}

class CheesePizza implements Pizza {
	@Override
	public void prepare() {
		System.out.println("Preparing Cheese Pizza");

	}

	@Override
	public void bake() {

		System.out.println("Baking Cheese Pizza");
	}

	@Override
	public void cut() {
		System.out.println("Cutting Cheese Pizza");

	}

	@Override
	public void box() {
		System.out.println("Boxing Cheese Pizza");

	}

}

class PizzaFactory {
	public Pizza getPizza(String pizzaType) {
		if (pizzaType == null) {
			return null;
		}
		if (pizzaType.equalsIgnoreCase("PepperoniPizza")) {
			return new PepperoniPizza();
		} else if (pizzaType.equalsIgnoreCase("VeggiePizza")) {
			return new VeggiePizza();
		} else if (pizzaType.equalsIgnoreCase("CheesePizza")) {
			return new CheesePizza();
		}
		return null;
	}
}

public class FactoryDpat {
	public static void main(String[] args) {
		PizzaFactory pizzaFactory = new PizzaFactory();

		Pizza pizza1 = pizzaFactory.getPizza("PepperoniPizza");
		pizza1.prepare();
		pizza1.bake();
		pizza1.cut();
		pizza1.box();

		Pizza pizza2 = pizzaFactory.getPizza("VeggiePizza");
		pizza2.prepare();
		pizza2.bake();
		pizza2.cut();
		pizza2.box();

		Pizza pizza3 = pizzaFactory.getPizza("CheesePizza");
		pizza3.prepare();
		pizza3.bake();
		pizza3.cut();
		pizza3.box();
	}
}