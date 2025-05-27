package tester;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cdac.dependent.PublicSchool;

public class TestSpringContainer {

	public static void main(String[] args) {
		try (ClassPathXmlApplicationContext ctx = 
				new ClassPathXmlApplicationContext("bean-config.xml")) {

			System.out.println("SC up n running !");
			/*
			 * task - call business logic method of public 
			 * method of o.s.b.beans.factory.BeanFactory
			 * <----ApplicationCpntext
			 * <----ClassPathXmlApplicationContext
			 * public<T> T getBaen(String beanId, class<T>beanClass)
			 * throws BeanException
			 */
			PublicSchool school1 = ctx.getBean("public_school", PublicSchool.class);//1st demand
			PublicSchool school2 = ctx.getBean("public_school", PublicSchool.class);
			
			System.out.println(school1 == school2);//true: singleton
			//invoke B.L
			
			school1.manageAcademics();
			
			//jvm -ctx.close()->shut SC-> Sc call destroy method -> bean mae
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
