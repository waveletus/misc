package spring.java.lxb;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

@SuppressWarnings("deprecation")
public class Drawing {
	private static final String springFile = "spring.xml";

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Triangle triange = new Triangle();

		ApplicationContext context = getAppContextByXML(springFile);
		Triangle triangle = (Triangle) context.getBean("triangle");
		triangle.draw();

		context = getAppContextFromAnnotationConfig();
		triangle = (Triangle) context.getBean("triangle");
		triangle.draw();

		DefaultListableBeanFactory xbf = new DefaultListableBeanFactory();
		XmlBeanDefinitionReader reader = new XmlBeanDefinitionReader(xbf);
		reader.loadBeanDefinitions(new ClassPathResource(springFile));
		triangle = (Triangle) xbf.getBean("triangle");
		triangle.draw();

		BeanFactory factory = new XmlBeanFactory(new ClassPathResource(springFile));
		triangle = (Triangle) factory.getBean("triangle");
		triangle.draw();


	}

	private static AnnotationConfigApplicationContext getAppContextFromAnnotationConfig() {
		return new AnnotationConfigApplicationContext(AppConfig.class);
	}

	private static ApplicationContext getAppContextByXML(String xml) {
		return new ClassPathXmlApplicationContext(xml);
	}

}
