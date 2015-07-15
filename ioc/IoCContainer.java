package ioc;

import java.io.InputStream;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

public class IoCContainer {
	public void init(String file){
		try {
			SAXReader reader =new SAXReader();
			ClassLoader loader=Thread.class.getClassLoader();
			InputStream ins = loader.getResourceAsStream(file);
			Document doc=reader.read(ins);
		} catch (DocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
