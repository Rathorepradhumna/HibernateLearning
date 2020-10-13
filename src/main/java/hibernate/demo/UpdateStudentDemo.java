package hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.Student;


public class UpdateStudentDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(UpdateStudentDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
			int studentId = 1;
			
			session = factory.getCurrentSession();
			
			
			session.beginTransaction();
			 log.info("getting student with id" + studentId);
			 Student myStudent = session.get(Student.class, studentId);
			 
			 log.info("updating studen");
			 myStudent.setFirstName("Ram");

			 session.getTransaction().commit();
			 
			 //new code to update all email
			 
			 session = factory.getCurrentSession();
			 session.beginTransaction();
			 
			 log.info("update mail for all stundent");
			session.createQuery("update Student set email = 'foo@gmail.com'")
				.executeUpdate();
			session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			factory.close();
		}
									
	}
}
