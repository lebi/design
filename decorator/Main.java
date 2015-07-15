package decorator;

public class Main {
	public static void main(String[] argc){
		Icecream cream=new Icecream();
		Milk milk=new Milk();
		Chocolate chocolate=new Chocolate();
		
		milk.setCream(cream);
		chocolate.setCream(milk);
		chocolate.add();
	}
}
