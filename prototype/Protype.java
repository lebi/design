package prototype;

public abstract class Protype implements Cloneable{
	public Protype(){
		System.out.println("protype");
	}
	
	public Protype clone() throws CloneNotSupportedException{
		return (Protype) super.clone();
	}
	
	public Protype cloneA(){
		try {
			return (ProtypeA)this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ProtypeA();
	}

	public Protype cloneB(){
		try {
			return (ProtypeB)this.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ProtypeB();
	}
	
	public static void main(String[] argc){
		Action act=new Action();
		System.out.println("create");
		ProtypeA pa=new ProtypeA();
		System.out.println("run");
		act.run(pa);
	}
}

class ProtypeA extends Protype{
	public ProtypeA(){
		super();
		System.out.println("protype A");
	}
}


class ProtypeB extends Protype{
	public ProtypeB(){
		super();
		System.out.println("protype B");
	}
}

class Action{
	public void run(Protype p){
		Protype pa=p.cloneA();
	}
}