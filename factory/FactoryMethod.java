package factory;

public interface FactoryMethod {
	public OpMethod getOperation();
	

}

class AddFactory implements FactoryMethod{

	@Override
	public OpMethod getOperation() {
		return new AddOp();
	}
}

class SubFactory implements FactoryMethod{

	@Override
	public OpMethod getOperation() {
		return new SubOp();
	}
}

interface OpMethod{
	public void getMoethod();
}

class AddOp implements OpMethod{

	@Override
	public void getMoethod() {
		System.out.println("add method");
	}
	
}

class SubOp implements OpMethod{

	@Override
	public void getMoethod() {
		System.out.println("sub method");
	}
}

class Test{
	public static void main(String[] args){
		FactoryMethod factory=new AddFactory();
		OpMethod operation=factory.getOperation();
		operation.getMoethod();
	}
}
