package decorator;

public class Milk extends Decorator{

	@Override
	public void add() {
		System.out.println("milk\t");
		super.add();
	}
	
}
