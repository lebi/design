package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public interface MyProxy {
	public void update();
}

class Handler implements MyProxy{

	@Override
	public void update() {
		System.out.println("handler update");
	}
	
}

class HandleMyProxy implements MyProxy{
	private MyProxy proxy;

	public HandleMyProxy(MyProxy MyProxy){
		this.proxy=MyProxy;
	}
	@Override
	public void update() {
		System.out.println("MyProxy before");
		this.proxy.update();
		System.out.println("MyProxy end");
	}
}

class JDKMyProxy implements InvocationHandler{
	private Object proxy;
	public JDKMyProxy(Object proxy){
		System.out.println("proxy construct");
		this.proxy=proxy;
	}
	@Override
	public Object invoke(Object object, Method method, Object[] args)
			throws Throwable {
		// TODO Auto-generated method stub
		System.out.println("before");
		System.out.println(object.getClass().getName());
		System.out.println(method);
		method.invoke(proxy, args);
		System.out.println("end");
		return "a";
	}
}

class Test {
	public static void main(String[] argc) {
//		MyProxy handle=new Handler();
//		MyProxy handleMyProxy=new HandleMyProxy(handle);
//		handleMyProxy.update();
		MyProxy handle=new Handler();
		MyProxy myProxy=(MyProxy)Proxy.newProxyInstance(MyProxy.class.getClassLoader(), Handler.class.getInterfaces(), new JDKMyProxy(handle));
		myProxy.update();
		System.out.println(myProxy.getClass().getName());
		try {
			Method method=myProxy.getClass().getMethod("update",null);
			method.invoke(myProxy,null);
		} catch (Exception e) {
			e.printStackTrace();
		} 
	}
}

