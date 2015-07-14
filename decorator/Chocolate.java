package decorator;

public class Chocolate extends Decorator{

	@Override
	public void add() {
		System.out.println("chocolate\t");
		super.add();
	}
	
}
