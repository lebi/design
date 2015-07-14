package decorator;

public class Decorator extends Icecream{

	protected Icecream cream;
	
	public void setCream(Icecream cream){
		this.cream=cream;
	}
	
	@Override
	public void add() {
		cream.add();
	}
	
}
