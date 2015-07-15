package strategy;

public interface Strategy {
	public void writeToLog();
}

class Normal implements Strategy{

	@Override
	public void writeToLog() {
		System.out.println("normal log");
	}
}

class Warning implements Strategy{

	@Override
	public void writeToLog() {
		System.out.println("warning log");
	}
	
}

class Danger implements Strategy{

	@Override
	public void writeToLog() {
		System.out.println("danger log");
	}
	
}

class Context{
	public void checkState(Strategy strategy){
		strategy.writeToLog();
	}
}

class Test{
	public static void main(String[] args){
		Context context=new Context();
		Strategy danger=new Danger();
		Strategy warning=new Warning();
		context.checkState(warning);
		context.checkState(danger);
	}
}