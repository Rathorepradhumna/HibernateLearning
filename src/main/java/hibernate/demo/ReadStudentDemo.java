package hibernate.demo;

import org.hibernate.cfg.Configuration;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import demo.entity.Student;


public class ReadStudentDemo {
	public static void main(String args[]) {
		
		  Logger log = Logger.getLogger(ReadStudentDemo.class.getName());  
		SessionFactory factory  = new Configuration()
									.configure("hibernate.cfg.xml")
									.addAnnotatedClass(Student.class)
									.buildSessionFactory();
		Session session = factory.getCurrentSession();
		try {
		     log.info("Creating the new Student object");
			Student tempStudent = new Student("Pradhumna" , "Rathore" , "pradhumnarathore@gmail.com");
			
			log.info("saving the student");
			session.beginTransaction();
			
			session.save(tempStudent);
			
			session.getTransaction().commit();
			
			//reading from database
			session = factory.getCurrentSession();
			
			session.beginTransaction();
			
			log.info("/n getting student bt id"  + tempStudent.getId());
			
			Student myStudent = session.get(Student.class, tempStudent.getId());
			
			log.info("get complete"  + myStudent);
			
			session.getTransaction().commit();
			
			log.info("done");
		}
		finally {
			factory.close();
		}
									
	}
}
