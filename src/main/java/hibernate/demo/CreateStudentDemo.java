package hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.StudentDemo;


public class CreateStudentDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(CreateStudentDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(StudentDemo.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		     log.info("Creating the new Student object");
			StudentDemo tempStudent1 = new StudentDemo("Hardik" , "Gupta" , "hardik@gmail.com");
			StudentDemo tempStudent2 = new StudentDemo("Poorva" , "Paliwal" , "poorvapaliwal@gmail.com");
			StudentDemo tempStudent3 = new StudentDemo("Namrata" , "Soni" , "namratasoni@gmail.com");
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
