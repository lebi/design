package factory;

public class SimpleFactory {
	public static Operation getOperation(String op){
		Operation oper=null;
		switch(op){
			case("+"):
				oper=new AddOperation();
				break;
			case("-"):
				oper=new SubOperation();
				break;
			case("*"):
				oper=new MulOperation();
				break;
			case("/"):
				oper=new DivOperation();
				break;
		}
		return oper;
	}
	
	public static void main(String[] args){
		SimpleFactory.getOperation("+");
		SimpleFactory.getOperation("-");     
		//����Ҫ����µĲ�������Ҫͬʱ�޸Ŀͻ��˺ͼ򵥹����ࡣ
	}
}

abstract class Operation{
}

class AddOperation extends Operation{
	public AddOperation(){
		System.out.println("+ operation");
	}

}

class SubOperation extends Operation{
	public SubOperation(){
		System.out.println("- operation");
	}

}

class DivOperation extends Operation{
	public DivOperation(){
		System.out.println("/ operation");
	}

}

class MulOperation extends Operation{
	public MulOperation(){
		System.out.println("* operation");
	}
}