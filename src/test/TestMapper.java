package test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMapper {
	private static ApplicationContext ctx; 
	
	public static void init() {
		ctx = new ClassPathXmlApplicationContext("/conf/spring/applicationContext-main.xml");
	}
	
	public static void main(String[] args) {
		try {
			init();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.exit(0);
		}
	}
}
