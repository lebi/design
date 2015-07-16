package ioc;

import java.beans.BeanInfo;
import java.beans.IntrospectionException;
import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.InputStream;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

public class IoCContainer {
	private Map<String,Object> beanMap=new HashMap<String, Object>(); 
	public void init(String file) {
		try {
			SAXReader reader =new SAXReader();
			ClassLoader loader=IoCContainer.class.getClassLoader();
			InputStream ins = loader.getResourceAsStream(file);
			Document doc=reader.read(ins);
			Element root=doc.getRootElement();
			Element node;
			for (Iterator<Element> i=root.elementIterator("bean");i.hasNext();){
				node=i.next();
				Attribute id=node.attribute("id");
				Attribute cname=node.attribute("class");
				Class bean=Class.forName(cname.getText());
				BeanInfo info=Introspector.getBeanInfo(bean);
				PropertyDescriptor pd[]=info.getPropertyDescriptors();
				Method setter=null;
				Object beanIns=bean.newInstance();
				for(Iterator<Element> iter=node.elementIterator("property");iter.hasNext();){
					Element property=iter.next();
					Attribute name=property.attribute("name");
					String value=null;
					for(Iterator<Element> viter=property.elementIterator("value");viter.hasNext();){
						Element valueNode=viter.next();
						value=valueNode.getText();
						break;
					}
					for(int n=0;n<pd.length;n++){
						if(pd[n].getName().equalsIgnoreCase(name.getText())){
							setter=pd[n].getWriteMethod();
							System.out.println(beanIns.toString());
							setter.invoke(beanIns, value);
						}
					}
				}
				beanMap.put(id.getText(), beanIns);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public Object getBean(String beanId){
		return beanMap.get(beanId);
	}
	static public void main(String[] args){
		IoCContainer container=new IoCContainer();
		container.init("ioc.xml");
		User user=(User)container.getBean("user");
		System.out.println(user.getUsername());
		System.out.println(user.getAge());
	}
}

class User{
	private String username;
	private String age;
	public final String getUsername() {
		return username;
	}
	public final void setUsername(String username) {
		this.username = username;
	}
	public final String getAge() {
		return age;
	}
	public final void setAge(String age) {
		this.age = age;
	}
}
