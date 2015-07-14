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

class Context