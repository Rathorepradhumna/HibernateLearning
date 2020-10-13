package hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.Student;


public class DeleteStudentDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(DeleteStudentDemo.class.getName());  
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
			
			 //delete myStudent object
			 
			// log.info("deleting student" + myStudent);
			 //session.delete(myStudent);
			 log.info("deleting student with id=2");
			session.createQuery("delete from Student where id=2").executeUpdate();
			
			 
			 session.getTransaction().commit();
			 
			
			
			log.info("done");
		}
		finally {
			factory.close();
		}
									
	}
}
