package hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.Student;


public class CreateStudentDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(CreateStudentDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		     log.info("Creating the new Student object");
			Student tempStudent1 = new Student("Hardik" , "Gupta" , "hardik@gmail.com");
			Student tempStudent2 = new Student("Poorva" , "Paliwal" , "poorvapaliwal@gmail.com");
			Student tempStudent3 = new Student("Namrata" , "Soni" , "namratasoni@gmail.com");
			session.beginTransaction();
			log.info("saving the student");
			session.save(tempStudent1);
			session.save(tempStudent2);
			session.save(tempStudent3);
			
			session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			factory.close();
		}
									
	}
}
